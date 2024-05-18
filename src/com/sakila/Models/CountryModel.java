package com.sakila.Models;

import java.sql.ResultSet; 
import java.sql.SQLException;
import java.util.ArrayList; 
import com.sakila.Data.Country; 

public class CountryModel extends DBEntity {
	private ArrayList<Country> comodel;
	
	public CountryModel() {
		
	}
	private void Mapping(ResultSet dset) {
		comodel = new ArrayList<Country>();
	        try {
	            while (dset.next()) {
	            	Country objco = new Country();
	            	objco.ID = dset.getShort("country_id");
	            	objco.Name = dset.getString("country");
	            	objco.UpdateDate = dset.getTimestamp("last_update");	               	                
	                comodel.add(objco);
	            }
	            dset.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	public ArrayList<Country> Get(){
		String sql = "SELECT * FROM country WHERE ";
        sql += "Concat(country_id,country,last_update) ";
        Mapping(getData(sql));
        return comodel;
	}
	public boolean Post(Country odata){
		String sql = "INSERT INTO country (country_id,country,last_update) VALUES ( ";
	    sql += "'" + odata.ID + "', ";
	    sql += "'" + odata.Name + "', ";
	    sql += "'" + odata.UpdateDate + "')";	    
		return  execSQL(sql);
	}
	public boolean Put(Country odata){
	    String sql = "UPDATE country SET ";
	    sql += "country = '" + odata.Name + "', ";
	    sql += "last_update = '" + odata.UpdateDate + "' ";
	    sql += "WHERE country_id = '" + odata.ID + "'";
	    return execSQL(sql);
	}
	public boolean Delete(Short countryId) {
	    String sql = "DELETE FROM country WHERE country_id = '" + countryId + "'";
	    return execSQL(sql);
	}
}
