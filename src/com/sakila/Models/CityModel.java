package com.sakila.Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sakila.Data.City;


public class CityModel extends DBEntity {
private ArrayList<City> citymodel;
	
	public CityModel() {
		
	}
	private void Mapping(ResultSet dset) {
		citymodel = new ArrayList<City>();
	        try {
	            while (dset.next()) {
	            	City objci = new City();
	            	objci.ID = dset.getShort("city_id");
	            	objci.Name = dset.getString("city");
	            	objci.CountryID = dset.getShort("country_id");
	            	objci.UpdateDate = dset.getTimestamp("last_update");	               
	            	citymodel.add(objci);
	            }
	            dset.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	public ArrayList<City> Get(){
		// Consulta SQL para obtener todos los títulos y unirlos con la tabla de publishers
        String sql = "SELECT t.*, p.country FROM city t JOIN country p ON t.country_id = p.country_id";
        Mapping(getData(sql)); // Mapear los resultados de la consulta
        return citymodel; // Devolver la lista de títulos
	}
	public boolean Post(City odata){
		// Validar si el pub_id existe en la tabla publishers
        if (countryExists(odata.CountryID)) {
            // La validación pasó, proceder con la inserción
            String sql = "INSERT INTO city (city_id,city,country_id,last_update) VALUES ( ";
            sql += "'" + odata.ID + "', ";
            sql += "'" + odata.Name + "', ";
            sql += "'" + odata.CountryID + "', ";           
            sql += "'" + odata.UpdateDate + "')";
            return execSQL(sql);
        } else {
            // El pub_id no existe en la tabla publishers, manejar el error
            System.out.println("El ID del pais no existe en la base de datos.");
            return false;
        }
	}
	public boolean Put(City odata){
		 // Validar si el pub_id existe en la tabla publishers
        if (countryExists(odata.CountryID)) {
            // La validación pasó, proceder con la actualización
            String sql = "UPDATE city SET ";
            sql += "city = '" + odata.Name + "', ";
            sql += "country_id = '" + odata.CountryID + "', ";
            sql += "last_update = " + odata.UpdateDate + ", ";
            sql += " WHERE city_id = '" + odata.ID + "'";
            return execSQL(sql);
        } else {
            // El pub_id no existe en la tabla publishers, manejar el error
            System.out.println("El ID del pais no existe en la base de datos.");
            return false;
        }
	}
	 public boolean Delete(short cityID) {
	        // Consulta SQL para eliminar el título con el título_id dado
	        String sql = "DELETE FROM city WHERE city_id = '" + cityID + "'";
	        return execSQL(sql); // Ejecutar la consulta SQL de eliminación y devolver el resultado
	    }
        // Método para verificar si un publisher existe en la tabla publishers
        private boolean countryExists(short cityID) {
            String sql = "SELECT COUNT(*) FROM city WHERE country_id = '" + cityID + "'";
            ResultSet resultSet = getData(sql);
            try {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        }
}
