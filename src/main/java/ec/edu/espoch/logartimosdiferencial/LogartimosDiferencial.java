/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package ec.edu.espoch.logartimosdiferencial;

import ec.edu.espoch.logartimosdiferencial.Datasource.LogDataSource;
import java.util.Scanner;

/**
 * @author JHORCY
 */
public class LogartimosDiferencial {

    public static void main(String[] args) {

        LogDataSource gestor = new LogDataSource(); // objeto
        try (Scanner scanner = new Scanner(System.in)) {
            int opcion = 0; // diferente a gestor
            
            do {
                System.out.println("------------------------------");
                System.out.println("| DIFERENCIACION LOGARITMICA |");
                System.out.println("------------------------------");
                System.out.println("| 1. Resolver un ejercicio   |");
                System.out.println("| 2. Salir                   |");
                System.out.println("------------------------------");
                System.out.print("Elige una opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine();
                
                switch (opcion) {
                    
                    case 1:
                        System.out.println("\n-- Formulas disponibles --");
                        gestor.mostrarFormulas();
                        
                        System.out.print("\nElige el numero de formula: ");
                        int idFormula = scanner.nextInt();
                        scanner.nextLine();
                        
                        // solo pide u — la app deriva sola
                        System.out.print("Ingresa la funcion dentro del logaritmo");
                        System.out.print(" (ej: x^2-3x): ");
                        String u = scanner.nextLine();
                        gestor.setU(u);
                        
                        if (idFormula == 2) {
                            System.out.print("Ingresa la base b (ej: 10): ");
                            gestor.setBase(scanner.nextLine());
                        }
                        if (idFormula == 3) {
                            System.out.print("Ingresa el valor de a (ej: 5): ");
                            gestor.setA(scanner.nextLine());
                        }
                        if (idFormula == 4) {
                            System.out.print("Ingresa el valor de n (ej: 2): ");
                            gestor.setN(scanner.nextLine());
                        }
                        break;
                        
                    case 2:
                        System.out.println("\n──Hasta luego  ──");
                        break;
                        
                    default:
                        System.out.println("\nOpcion invalida.");
                }
                
            } while (opcion != 2);
        }
    }
}
