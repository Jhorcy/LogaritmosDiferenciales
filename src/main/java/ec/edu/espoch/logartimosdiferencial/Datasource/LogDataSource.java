/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ec.edu.espoch.logartimosdiferencial.Datasource;

import ec.edu.espoch.logartimosdiferencial.Dao.ILogDao;
import ec.edu.espoch.logartimosdiferencial.model.Ejercicio;
import ec.edu.espoch.logartimosdiferencial.model.FormulaPredefinida;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author JHORCY
 */
public class LogDataSource implements ILogDao {

    private FormulaPredefinida[] formulas;
    private ArrayList<Ejercicio> historial;
    private FormulaPredefinida formulaElegida;
    private double valorX;
    private int contadorId;

    public LogDataSource() {
        historial = new ArrayList<>();
        contadorId = 1;

        formulas = new FormulaPredefinida[]{
            new FormulaPredefinida(
            1,
            "Potencia variable",
            "x^x",
            "f'(x) = x^x · (ln(x) + 1)",
            "Paso 1: Aplicar ln → ln(f(x)) = x·ln(x)",
            "Paso 2: Derivar → f'(x)/f(x) = ln(x) + 1",
            "Paso 3: f'(x) = x^x · (ln(x) + 1)"
            ),
            new FormulaPredefinida(
            2,
            "Potencia trigonométrica",
            "x^(sen x)",
            "f'(x) = x^(senx) · (cos(x)·ln(x) + sen(x)/x)",
            "Paso 1: Aplicar ln → ln(f(x)) = sen(x)·ln(x)",
            "Paso 2: Derivar → f'(x)/f(x) = cos(x)·ln(x) + sen(x)/x",
            "Paso 3: f'(x) = x^(senx) · (cos(x)·ln(x) + sen(x)/x)"
            ),
            new FormulaPredefinida(
            3,
            "Logaritmo en base variable",
            "(ln x)^x",
            "f'(x) = (ln x)^x · (ln(ln x) + 1/ln(x))",
            "Paso 1: Aplicar ln → ln(f(x)) = x·ln(ln(x))",
            "Paso 2: Derivar → f'(x)/f(x) = ln(ln(x)) + 1/ln(x)",
            "Paso 3: f'(x) = (ln x)^x · (ln(ln x) + 1/ln(x))"
            )
        };
    }

    
    public FormulaPredefinida[] getFormulas() {
        return formulas;
    }

    public ArrayList<Ejercicio> getHistorial() {
        return historial;
    }

    @Override
    public void mostrarFormulas() {
        for (FormulaPredefinida f : formulas) {
            System.out.println(f.getId() + ". f(x) = " + f.getExpresion());
        }
    }

    @Override
    public boolean resolver(int idFormula, double valorX) {
        for (FormulaPredefinida f : formulas) {
            if (f.getId() == idFormula) {
                this.formulaElegida = f;
                this.valorX = valorX;
                return true;
            }
        }
        return false;
    }

    @Override
    public void imprimirResultado() {
        if (formulaElegida == null) {
            return;
        }
        System.out.println(formulaElegida.getPaso1());
        System.out.println(formulaElegida.getPaso2());
        System.out.println(formulaElegida.getPaso3());
        System.out.println("Resultado: " + formulaElegida.getDerivada());
    }

    @Override
    public boolean guardar() {
        if (formulaElegida == null) {
            return false;
        }
        Ejercicio e = new Ejercicio(
                contadorId++,
                formulaElegida,
                valorX,
                LocalDate.now().toString()
        );
        historial.add(e);
        return true;
    }

    @Override
    public void mostrarHistorial() {
        for (Ejercicio e : historial) {
            System.out.println(e.toString());
        }
    }

    // getter para la vista — devuelve la fórmula activa
    public FormulaPredefinida getFormulaElegida() {
        return formulaElegida;
    }
}
