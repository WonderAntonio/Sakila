package com.sakila.Models;

import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 
import com.sakila.Data.Actor;


public class ActorModel extends DBEntity {
	private ArrayList<Actor> acmodel;
	
	public ActorModel() {
		
	}
	private void Mapping(ResultSet dset) {
	    acmodel = new ArrayList<Actor>();
	        try {
	            while (dset.next()) {
	            	Actor objac = new Actor();
	            	objac.ID = dset.getShort("actor_id");
	            	objac.FirstName = dset.getString("first_name");
	            	objac.LastName = dset.getString("last_name");
	            	objac.UpdateDate = dset.getTimestamp("last_update");
	            	acmodel.add(objac);
	            }
	            dset.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	public ArrayList<Actor> Get(){
		String sql = "SELECT * FROM actor WHERE ";
        sql += "Concat(actor_id,first_name,last_name,last_update) ";
        Mapping(getData(sql));
        return acmodel;
	}
	public boolean Post(Actor odata){
	    String sql = "INSERT INTO actor (actor_id,first_name,last_name,last_update) VALUES ( ";
	    sql += "'" + odata.ID + "', ";
	    sql += "'" + odata.FirstName + "', ";
	    sql += "'" + odata.LastName + "', ";
	    sql += "'" + odata.UpdateDate + "')";
	    return  execSQL(sql);
	}
	public boolean Put(Actor odata) {
	    String sql = "UPDATE actor SET ";
	    sql += "first_name = '" + odata.FirstName + "', ";
	    sql += "last_name = '" + odata.LastName + "', ";
	    sql += "last_update = '" + odata.UpdateDate + "' ";
	    sql += "WHERE actor_id = '" + odata.ID + "'";
	    return execSQL(sql); 
	}
	public boolean Delete(Short actorId) {
	    String sql = "DELETE FROM actor WHERE actor_id = '" + actorId + "'";
	    return execSQL(sql);
	}
}
