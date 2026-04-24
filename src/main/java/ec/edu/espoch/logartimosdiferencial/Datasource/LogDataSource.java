package ec.edu.espoch.logartimosdiferencial.Datasource;

import ec.edu.espoch.logartimosdiferencial.Dao.ILogDao;
import ec.edu.espoch.logartimosdiferencial.model.Ejercicio;
import ec.edu.espoch.logartimosdiferencial.model.FormulaPredefinida;
import java.time.LocalDate;
import java.util.ArrayList;

public class LogDataSource implements ILogDao {

    private FormulaPredefinida[] formulas;
    private ArrayList<Ejercicio> historial;
    private FormulaPredefinida   formulaElegida;
    private int                  contadorId;
    private String u;
    private String uPrima;
    private String base;
    private String a;
    private String n;

    public LogDataSource() {
        historial  = new ArrayList<>();
        contadorId = 1;

        formulas = new FormulaPredefinida[]{
            new FormulaPredefinida(1, "f(x) = ln(u)",
                "ln(u)", "f'(x) = u'/u", "", "", ""),
            new FormulaPredefinida(2, "f(x) = log_b(u)",
                "log_b(u)", "f'(x) = u'/(u*ln(b))", "", "", ""),
            new FormulaPredefinida(3, "f(x) = a*ln(u)",
                "a*ln(u)", "f'(x) = a*u'/u", "", "", ""),
            new FormulaPredefinida(4, "f(x) = ln(u)^n",
                "ln(u)^n", "f'(x) = n*ln(u)^(n-1)*u'/u", "", "", "")
        };
    }

    // ── getters ──────────────────────────────────────
    public FormulaPredefinida[] getFormulas()       { return formulas; }
    public ArrayList<Ejercicio> getHistorial()      { return historial; }
    public FormulaPredefinida   getFormulaElegida() { return formulaElegida; }

    // ── setters ──────────────────────────────────────
    public void setU(String u)           { this.u = u; }
    public void setUPrima(String uPrima) { this.uPrima = uPrima; }
    public void setBase(String base)     { this.base = base; }
    public void setA(String a)           { this.a = a; }
    public void setN(String n)           { this.n = n; }

    
    @Override
    public void mostrarFormulas() {
        for (FormulaPredefinida f : formulas) {
            System.out.println(f.getId() + ".  " + f.getNombre()
                + "   ->   " + f.getDerivada());
        }
    }

    @Override
    public boolean resolver(int idFormula, double valorX) {
        for (FormulaPredefinida f : formulas) {
            if (f.getId() == idFormula) {
                this.formulaElegida = f;
                return true;
            }
        }
        return false;
    }

    @Override
public void imprimirResultado() {
    if (formulaElegida == null) return;

   
    String uPrimaCalculada = ec.edu.espoch.logartimosdiferencial
                               .service.Derivador.derivar(u);

    
    if (uPrimaCalculada.startsWith("+")) {
        uPrimaCalculada = uPrimaCalculada.substring(1);
    }

    System.out.println("\n-- Resolucion paso a paso --");

    switch (formulaElegida.getId()) {

        case 1: // f(x) = ln(u)
            System.out.println("Formula:  f(x) = ln(" + u + ")");
            System.out.println("---------------------------------");
            System.out.println("Paso 1: Identificar u");
            System.out.println("        u  = " + u);
            System.out.println("Paso 2: Derivar u automaticamente");
            System.out.println("        u' = " + uPrimaCalculada);
            System.out.println("Paso 3: Aplicar f'(x) = u'/u");
            System.out.println("        f'(x) = " + uPrimaCalculada
                + " / (" + u + ")");
            System.out.println("---------------------------------");
            System.out.println("Resultado: f'(x) = "
                + uPrimaCalculada + " / (" + u + ")");
            break;

        case 2: // f(x) = log_b(u)
            System.out.println("Formula:  f(x) = log_" + base + "(" + u + ")");
            System.out.println("---------------------------------");
            System.out.println("Paso 1: Identificar u y base b");
            System.out.println("        u  = " + u);
            System.out.println("        b  = " + base);
            System.out.println("Paso 2: Derivar u automaticamente");
            System.out.println("        u' = " + uPrimaCalculada);
            System.out.println("Paso 3: Aplicar f'(x) = u'/(u*ln(b))");
            System.out.println("        f'(x) = " + uPrimaCalculada
                + " / ((" + u + ")*ln(" + base + "))");
            System.out.println("---------------------------------");
            System.out.println("Resultado: f'(x) = " + uPrimaCalculada
                + " / ((" + u + ")*ln(" + base + "))");
            break;

        case 3: // f(x) = a·ln(u)
            System.out.println("Formula:  f(x) = " + a + "*ln(" + u + ")");
            System.out.println("---------------------------------");
            System.out.println("Paso 1: Identificar a y u");
            System.out.println("        a  = " + a);
            System.out.println("        u  = " + u);
            System.out.println("Paso 2: Derivar u automaticamente");
            System.out.println("        u' = " + uPrimaCalculada);
            System.out.println("Paso 3: Aplicar f'(x) = a*u'/u");
            System.out.println("        f'(x) = " + a + "*"
                + uPrimaCalculada + " / (" + u + ")");
            System.out.println("---------------------------------");
            System.out.println("Resultado: f'(x) = " + a + "·"
                + uPrimaCalculada + " / (" + u + ")");
            break;

        case 4: // f(x) = ln(u)^n
            System.out.println("Formula:  f(x) = ln(" + u + ")^" + n);
            System.out.println("---------------------------------");
            System.out.println("Paso 1: Identificar u y n");
            System.out.println("        u  = " + u);
            System.out.println("        n  = " + n);
            System.out.println("Paso 2: Derivar u automaticamente");
            System.out.println("        u' = " + uPrimaCalculada);
            System.out.println("Paso 3: Aplicar f'(x) = n*ln(u)^(n-1)*u'/u");
            System.out.println("        f'(x) = " + n
                + "*ln(" + u + ")^(" + n + "-1)*"
                + uPrimaCalculada + "/(" + u + ")");
            System.out.println("---------------------------------");
            System.out.println("Resultado: f'(x) = " + n
                + "*ln(" + u + ")^(" + n + "-1)*"
                + uPrimaCalculada + "/(" + u + ")");
            break;
    }
}

    @Override
    public boolean guardar() {
        if (formulaElegida == null) return false;
        Ejercicio e = new Ejercicio(
            contadorId++,
            formulaElegida,
            0,
            LocalDate.now().toString()
        );
        historial.add(e);
        return true;
    }

    @Override
    public void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("No hay ejercicios en el historial.");
            return;
        }
        for (Ejercicio e : historial) {
            System.out.println(e.toString());
        }
    }
}