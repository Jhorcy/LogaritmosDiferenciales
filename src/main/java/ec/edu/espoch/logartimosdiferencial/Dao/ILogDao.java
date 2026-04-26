/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ec.edu.espoch.logartimosdiferencial.Dao;

/**
 *
 * @author JHORCY
 */
public interface ILogDao {

    public void mostrarFormulas();

    public boolean resolver(int idFormula, double valorX);

    public void imprimirResultado();

}
