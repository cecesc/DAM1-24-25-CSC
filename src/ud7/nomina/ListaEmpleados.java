package ud7.nomina;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ListaEmpleados implements Serializable {

    private static final long serialVersionUID = 1L;

    public List<Empleado> lista;
    public double totalNómina = 0;

    public ListaEmpleados() {
        lista = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado a) {
        lista.add(a);
    }

    public void eliminarEmpleado(Empleado a) {
        lista.remove(a);
    }

    public Empleado obtenerEmpleado(int index) {
        return lista.get(index);
    }

    public void editarEmpleado(int index, Empleado empleado) {
        lista.set(index, empleado);
    }

    public double calcularTotalNómina() {
        totalNómina = 0;
        for (Empleado e : lista) {
            totalNómina += e.calcularNómina();
        }
        return totalNómina;
    }

    public String[][] obtenerMatriz() {
        String[][] datos = new String[lista.size()][3];
        for (int i = 0; i < lista.size(); i++) {
            Empleado e = lista.get(i);
            datos[i][0] = e.getNombre();
            datos[i][1] = e.getApellidos();
            datos[i][2] = Double.toString(e.calcularNómina());
        }
        return datos;
    }

    public String convertirTexto() {
        StringBuilder texto = new StringBuilder();
        for (Empleado e : lista) {
            texto.append("Nombre = ").append(e.getNombre()).append("\n")
                .append("Apellidos = ").append(e.getApellidos()).append("\n")
                .append("Cargo = ").append(e.getCargo()).append("\n")
                .append("Género = ").append(e.getGénero()).append("\n")
                .append("Salario = $").append(e.getSalarioDía()).append("\n")
                .append("Días trabajados = ").append(e.getDíasTrabajados()).append("\n")
                .append("Otros ingresos = $").append(e.getOtrosIngresos()).append("\n")
                .append("Pagos salud = $").append(e.getPagosSalud()).append("\n")
                .append("Aportes pensiones = $").append(e.getAportePensiones()).append("\n---------\n");
        }
        texto.append("Total nómina = $").append(String.format("%.2f", calcularTotalNómina()));
        return texto.toString();
    }

    public void guardarLista(String path) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(this);
        }
    }

    public static ListaEmpleados cargarLista(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (ListaEmpleados) ois.readObject();
        }
    }
}