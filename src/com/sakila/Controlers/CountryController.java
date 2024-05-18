package com.sakila.Controlers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import com.sakila.Data.Country;
import com.sakila.Models.CountryModel;

public class CountryController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion, respuesta;
		do {
        System.out.println("Elige una opción:");
        System.out.println("1. Ver tabla de Country");
        System.out.println("2. Insertar en la tabla de Country");
        System.out.println("3. Actualizar la tabla de Country");
        System.out.println("4. Borrar datos ingresados por el usuario en la tabla de Country");
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
		CountryModel objcountry = new CountryModel();
		showDataSet(objcountry.Get());
		
	}
	private static void Post(Scanner pin) {
		// Solicitar al usuario que ingrese los datos del nuevo autor
	    Country newCountry = new Country();
	    System.out.println("Ingrese el ID del nuevo pais:");
	    newCountry.ID = pin.nextShort();
	    pin.nextLine();
	    System.out.println("Ingrese el nombre del nuevo pais:");
	    newCountry.Name = pin.nextLine();    
	    newCountry.UpdateDate = Timestamp.valueOf(LocalDateTime.now());
    
	    // Crear una instancia de AuthorModel
	    CountryModel countryModel = new CountryModel();

	    // Insertar el nuevo autor
	    boolean inserted = countryModel.Post(newCountry);
	    if (inserted) {
	        System.out.println("Nuevo pais insertado correctamente.");
	    } else {
	        System.out.println("Error al insertar el nuevo pais.");
	    }
	}
	
	private static void Put(Scanner pin) {
		// Solicitar al usuario que ingrese el ID del autor a actualizar
	    System.out.println("Ingrese el ID del pais que desea actualizar:");
	    Short countryId = pin.nextShort();
	    pin.nextLine();
	    // Solicitar al usuario que ingrese los nuevos datos del autor
	    Country updatedCountry = new Country();
	    updatedCountry.ID = countryId; // ID del autor a actualizar
	    System.out.println("Ingrese el nuevo nombre del pais:");
	    updatedCountry.Name = pin.nextLine();
	    updatedCountry.UpdateDate = Timestamp.valueOf(LocalDateTime.now());
	   
	    // Crear una instancia de AuthorModel
	    CountryModel countryModel = new CountryModel();

	    // Actualizar el autor existente
	    boolean updated = countryModel.Put(updatedCountry);
	    if (updated) {
	        System.out.println("pais actualizado correctamente.");
	    } else {
	        System.out.println("Error al actualizar el pais.");
	    }
	}
	private static void Delete(Scanner scanner) {
	    // Solicitar al usuario que ingrese el ID del autor que desea eliminar
	    System.out.println("Ingrese el ID del pais que desea eliminar:");
	    Short cityId = scanner.nextShort();

	    // Crear una instancia de AuthorModel
	    CountryModel countryModel = new CountryModel();

	    // Intentar eliminar el autor y mostrar el resultado
	    boolean deleted = countryModel.Delete(cityId);
	    if (deleted) {
	        System.out.println("pais eliminado correctamente.");
	    } else {
	        System.out.println("Error al eliminar el pais.");
	    }
	}
	//Iterar los autors y muestra matriz en screen
	private static void showDataSet(ArrayList<Country> odt) {
		System.out.println("Id\t|Nombre\t|Fecha\t|");
		for (Country co : odt) {
			System.out.println(co.ID+"\t|"+co.Name+"\t|"+co.UpdateDate+"\t|");
		}
	}
}
