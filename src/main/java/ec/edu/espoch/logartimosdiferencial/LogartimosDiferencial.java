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

        LogDataSource gestor = new LogDataSource(); // ✅ el objeto
        Scanner scanner      = new Scanner(System.in);
        int opcion           = 0; // ✅ nombre diferente a gestor

        do {
            System.out.println("------------------------------");
            System.out.println("| DIFERENCIACION LOGARITMICA |");
            System.out.println("------------------------------");
            System.out.println("| 1. Resolver un ejercicio   |");
            System.out.println("| 2. Ver historial           |");
            System.out.println("| 3. Salir                   |");
            System.out.println("------------------------------");
            System.out.print("Elige una opcion: ");
            opcion = scanner.nextInt(); // ✅ scanner minúscula

            switch (opcion) {

                case 1:
                    System.out.println("\n── Formulas disponibles ──");
                    gestor.mostrarFormulas();

                    System.out.print("\nElige el numero de formula: ");
                    int idFormula = scanner.nextInt(); // ✅ scanner minúscula

                    System.out.print("Ingresa el valor de x: ");
                    double valorX = scanner.nextDouble(); // ✅ scanner minúscula

                    if (gestor.resolver(idFormula, valorX)) {
                        gestor.imprimirResultado();
                        gestor.guardar();
                        System.out.println("\n✅ Ejercicio guardado en historial.");
                    } else {
                        System.out.println("\n⚠ Formula no encontrada.");
                    }
                    break;

                case 2:
                    System.out.println("\n── Historial de ejercicios ──");
                    gestor.mostrarHistorial();
                    break;

                case 3:
                    System.out.println("\nHasta luego ");
                    break;

                default:
                    System.out.println("\n⚠ Opcion invalida, intenta de nuevo.");
            }

        } while (opcion != 3); // ✅ dentro del main

        scanner.close(); // ✅ scanner minúscula
    }               // ← cierra el main
}                   // ← cierra la clase