package com.sakila.Controlers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;

import com.sakila.Data.City;
import com.sakila.Models.CityModel;

public class CityController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion, respuesta;;
		do {
        System.out.println("Elige una opción:");
        System.out.println("1. Ver tabla de City");
        System.out.println("2. Insertar en la tabla de City");
        System.out.println("3. Actualizar la tabla de City");
        System.out.println("4. Borrar datos ingresados por el usuario en la tabla de City");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
        switch (opcion) {
            case 1:
                Get(scanner);
                break;
            case 2:
				Post(scanner);
                break;
            case 3:
				Put(scanner);
            	break;
            case 4:
                Delete(scanner);
            	break;
        }
        System.out.println("Desea continuar[0|1]");
        respuesta = scanner.nextInt();
		} while (respuesta != 0);
       //scanner.close();
	}
	private static void Get(Scanner pin) {
		CityModel objcity = new CityModel();
		showDataSet(objcity.Get());
		
	}
	private static void Post(Scanner pin) {
			// Solicitar al usuario que ingrese los datos del nuevo actor
			City newCity = new City();
			System.out.println("Ingrese el ID de la ciudad:");
			newCity.ID = pin.nextShort();
			pin.nextLine();
			System.out.println("Ingrese el nombre de la ciudad:");
			newCity.Name = pin.nextLine();			
			System.out.println("Ingrese el ID del pais:");
			newCity.CountryID = pin.nextShort();
			pin.nextLine();
			newCity.UpdateDate = Timestamp.valueOf(LocalDateTime.now());

			// Crear una instancia de TitleModel
			CityModel cityModel = new CityModel();

			// Insertar el nuevo título
			boolean inserted = cityModel.Post(newCity);
			if (inserted) {
			    System.out.println("Nuevo ciudad insertada correctamente.");
			} else {
			    System.out.println("Error al insertar la nueva ciudad.");
			}
			//scanner.close();
		}
	
	private static void Put(Scanner pin) {
			// Solicitar al usuario que ingrese el ID del actor a actualizar
			 System.out.println("Ingrese el ID de la ciudad que desea actualizar:");
			    Short cityId = pin.nextShort();
			    pin.nextLine();
			    // Solicitar al usuario que ingrese los nuevos datos del título
			    City updatedCity = new City();
			    updatedCity.ID = cityId; // ID del título a actualizar
			    System.out.println("Ingrese el nuevo nombre de la ciudad:");
			    updatedCity.Name = pin.nextLine();
			    System.out.println("Ingrese el ID del pais:");
			    updatedCity.CountryID = pin.nextShort();
			    pin.nextLine();
			    updatedCity.UpdateDate = Timestamp.valueOf(LocalDateTime.now());
			    // Crear una instancia de TitleModel
			    CityModel cityModel = new CityModel();

			    // Actualizar el título existente
			    boolean updated = cityModel.Put(updatedCity);
			    if (updated) {
			        System.out.println("ciudad actualizado correctamente.");
			    } else {
			        System.out.println("Error al actualizar la ciudad.");
			    }
			    //scanner.close();
		}
	
	private static void Delete(Scanner scanner) {
	    // Solicitar al usuario que ingrese el ID del autor que desea eliminar
	    System.out.println("Ingrese el ID de la ciudad que desea eliminar:");
	    Short cityId = scanner.nextShort();

	    // Crear una instancia de AuthorModel
	    CityModel cityModel = new CityModel();

	    // Intentar eliminar el autor y mostrar el resultado
	    boolean deleted = cityModel.Delete(cityId);
	    if (deleted) {
	        System.out.println("Autor eliminado correctamente.");
	    } else {
	        System.out.println("Error al eliminar el autor.");
	    }
	}
	//Iterar los autors y muestra matriz en screen
	private static void showDataSet(ArrayList<City> odt) {
		System.out.println("Id\t|Name\t|CountryId\t|Fecha\t|");
		for (City ci : odt) {
			System.out.println(ci.ID+"\t|"+ci.Name+"\t|"+ci.CountryID+"\t|"+ci.UpdateDate+"\t|");
		}
	}
}
