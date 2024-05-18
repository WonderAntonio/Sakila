package com.sakila.Controlers;

import java.util.Scanner;
import com.sakila.Models.DBEntity;

public class MenuControl {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
        DBEntity objEntity = new DBEntity();
		int opcion, respuesta;			
		do {					
        System.out.println("Elige una opción:");
        System.out.println("1. Explorar todo el modelo del DB");
        System.out.println("2. Explorar la tabla de Actor");
        System.out.println("3. Explorar la tabla de City");
        System.out.println("4. Explorar la tabla de Country");	        
        System.out.println("5. Cerrar DB");
        opcion = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner
		DBEntity obj = new DBEntity();
        switch (opcion) {
            case 1:
            	objEntity.ShowDbObject(scanner);
                break;
            case 2:
            	ActorController.main(args);
                break;
            case 3:
            	CityController.main(args);
            	break;
            case 4:
            	CountryController.main(args);
            	break;
            case 5:
            	obj.CloseDB();
                break;                     
        }
        System.out.println("Desea continuar[0|1]");
        respuesta = scanner.nextInt();
		} while (respuesta != 0);
        scanner.close();
	}
}
