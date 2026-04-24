/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.logartimosdiferencial.service;

/**
 *
 * @author JHORCY
 */
public class Derivador {

    public static String derivar(String polinomio) {
        polinomio = polinomio.trim().toLowerCase();
        String[] terminos = polinomio.split("(?=[+-])");
        String resultado = "";

        for (String termino : terminos) {
            termino = termino.trim();
            if (termino.isEmpty()) {
                continue;
            }

            String derivadaTermino = derivarTermino(termino);

            if (!derivadaTermino.equals("0")) {
                resultado += derivadaTermino;
            }
        }

        if (resultado.isEmpty()) {
            return "0";
        }

        // limpia el + al inicio si quedó
        if (resultado.startsWith("+")) {
            resultado = resultado.substring(1);
        }

        return resultado;
    }

    private static String derivarTermino(String termino) {

        termino = termino.trim();

        if (termino.contains("x^")) {
            String[] partes = termino.split("x\\^");

            double coef = parsearCoef(partes[0]);

            double exp = Double.parseDouble(partes[1].trim());

            double nuevoCoef = coef * exp;
            double nuevoExp = exp - 1;

            if (nuevoExp == 0) {

                return formatear(nuevoCoef);
            } else if (nuevoExp == 1) {

                return formatear(nuevoCoef) + "x";
            } else {

                return formatear(nuevoCoef) + "x^"
                        + formatear(nuevoExp);
            }
        }

        if (termino.contains("x")) {
            String coefStr = termino.replace("x", "").trim();
            double coef = parsearCoef(coefStr);
            return formatear(coef);
        }

        return "0";
    }

    private static double parsearCoef(String s) {
        s = s.trim();
        if (s.isEmpty() || s.equals("+")) {
            return 1;
        }
        if (s.equals("-")) {
            return -1;
        }
        return Double.parseDouble(s);
    }

    private static String formatear(double num) {
        if (num == (int) num) {
            int entero = (int) num;
            if (entero > 0) {
                return "+" + entero;
            }
            return String.valueOf(entero);
        }
        if (num > 0) {
            return "+" + num;
        }
        return String.valueOf(num);
    }
}
