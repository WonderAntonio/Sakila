package com.sakila.Controlers;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import com.sakila.Data.Actor;
import com.sakila.Models.ActorModel;

public class ActorController {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int opcion, respuesta;
		do {
        System.out.println("Elige una opción:");
        System.out.println("1. Ver tabla de Actores");
        System.out.println("2. Insertar en la tabla de Actores");
        System.out.println("3. Actualizar la tabla de Actores");
        System.out.println("4. Borrar datos ingresados por el usuario en la tabla de Actor");
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
		ActorModel objautor = new ActorModel();
		showDataSet(objautor.Get());
		
	}
	private static void Post(Scanner pin) {
		// Solicitar al usuario que ingrese los datos del nuevo autor
	    Actor newActor = new Actor();
	    System.out.println("Ingrese el ID del nuevo actor:");
	    newActor.ID = pin.nextShort();
	    pin.nextLine(); // Limpiar el buffer del scanner
	    System.out.println("Ingrese el nombre del nuevo actor:");
	    newActor.FirstName = pin.nextLine();
	    System.out.println("Ingrese el apellido del nuevo actor:");
	    newActor.LastName = pin.nextLine();
	    newActor.UpdateDate = Timestamp.valueOf(LocalDateTime.now());
    
	    // Crear una instancia de AuthorModel
	    ActorModel actorModel = new ActorModel();

	    // Insertar el nuevo autor
	    boolean inserted = actorModel.Post(newActor);
	    if (inserted) {
	        System.out.println("Nuevo actor insertado correctamente.");
	    } else {
	        System.out.println("Error al insertar el nuevo actor.");
	    }
	    //scanner.close();
	}
	
	private static void Put(Scanner pin) {
		// Solicitar al usuario que ingrese el ID del autor a actualizar
	    System.out.println("Ingrese el ID del actor que desea actualizar:");
	    Short actorId = pin.nextShort();
	    pin.nextLine(); // Limpiar el buffer del scanner
	    // Solicitar al usuario que ingrese los nuevos datos del autor
	    Actor updatedActor = new Actor();
	    updatedActor.ID = actorId; // ID del autor a actualizar
	    System.out.println("Ingrese el nuevo nombre del actor:");
	    updatedActor.FirstName = pin.nextLine();
	    System.out.println("Ingrese el nuevo apellido del actor:");
	    updatedActor.LastName = pin.nextLine();
	    updatedActor.UpdateDate = Timestamp.valueOf(LocalDateTime.now());
	   
	    // Crear una instancia de AuthorModel
	    ActorModel actorModel = new ActorModel();

	    boolean updated = actorModel.Put(updatedActor);
	    if (updated) {
	        System.out.println("actor actualizado correctamente.");
	    } else {
	        System.out.println("Error al actualizar el actor.");
	    }
	}
	private static void Delete(Scanner scanner) {
	    System.out.println("Ingrese el ID del actor ingresado que desea eliminar:");
	    Short actorId = scanner.nextShort();

	    ActorModel actorModel = new ActorModel();

	    boolean deleted = actorModel.Delete(actorId);
	    if (deleted) {
	        System.out.println("Actor eliminado correctamente.");
	    } else {
	        System.out.println("Error al eliminar el actor.");
	    }
	}
	//Iterar los autors y muestra matriz en screen
	private static void showDataSet(ArrayList<Actor> odt) {
		System.out.println("Id\t|Nombre\t|Apellidos|Fecha\t|");
		for (Actor ac : odt) {
			System.out.println(ac.ID+"\t|"+ac.FirstName+"\t|"+ac.LastName+"\t|"+ac.UpdateDate+"\t|");
		}
	}
}
