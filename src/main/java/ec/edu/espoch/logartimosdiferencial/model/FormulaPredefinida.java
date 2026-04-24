/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.logartimosdiferencial.model;

/**
 *
 * @author JHORCY
 */
public class FormulaPredefinida {

    protected int id;
    protected String nombre;
    protected String expresion;
    protected String derivada;
    protected String paso1;
    protected String paso2;
    protected String paso3;

    public FormulaPredefinida(int id, String nombre, String expresion, String derivada, String paso1, String paso2, String paso3) {
        this.id = id;
        this.nombre = nombre;
        this.expresion = expresion;
        this.derivada = derivada;
        this.paso1 = paso1;
        this.paso2 = paso2;
        this.paso3 = paso3;

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getExpresion() {
        return expresion;
    }

    public String getDerivada() {
        return derivada;
    }

    public String getPaso1() {
        return paso1;
    }

    public String getPaso2() {
        return paso2;
    }

    public String getPaso3() {
        return paso3;
    }

}
