package recuperacion.aparcamiento;

public class VehiculoPesado extends Vehiculo {
    private double peso;
    private double altura;

    public VehiculoPesado(String matricula, double peso, double altura) {
        super(matricula);
        this.peso = peso;
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public double getAltura() {
        return altura;
    }

    @Override
    public String toString() {
        return "VehiculoPesado{" + "matricula='" + getMatricula() +
               "', peso=" + peso + ", altura=" + altura + '}';
    }
}

