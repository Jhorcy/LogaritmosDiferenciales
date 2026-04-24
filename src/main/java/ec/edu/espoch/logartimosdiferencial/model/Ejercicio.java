/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.logartimosdiferencial.model;

/**
 *
 * @author JHORCY
 */
public class Ejercicio {

    private  int id;
    private FormulaPredefinida formula;
    private double valorX;
    private String fecha;
    private boolean resuelto;

    public Ejercicio(int id, FormulaPredefinida formula, double valorX, String fecha) {
        this.id = id;
        this.formula = formula;
        this.valorX = valorX;
        this.fecha = fecha;
        this.resuelto = true;
    }

    public int getId() {
        return id;
    }

    public FormulaPredefinida getFormula() {
        return formula;
    }

    public double getValorX() {
        return valorX;
    }

    public String getFecha() {
        return fecha;
    }

    public boolean isResuelto() {
        return resuelto;
    }

    @Override
    public String toString() {
        return "#" + id + " | f(x)=" + formula.getExpresion()
                + " | x=" + valorX + " | " + fecha;
    }

}
