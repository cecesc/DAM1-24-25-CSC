package ud3.ejercicios;

public class CuentaCorriente {
    String dni;
    String nombreTitular;
    double saldo;

    CuentaCorriente(String dni, String nombreTitular) {
        this.dni = dni;
        this.nombreTitular = nombreTitular;
        saldo = 0;
    }

    public boolean sacarDinero(double importe) {
        if (saldo >= importe) {
            saldo -= importe;
            return true;
        }
        return false;
    }

    public void ingresaDinero(double importe) {
        saldo += importe;
    }

    public void mostrarInfo() {
        System.out.println("Cuenta Corriente");
        System.out.println("-Titular: " + nombreTitular + ". DNI ( " + dni + " )");
        System.out.println("-Saldo: " + saldo + " euros");
    }
}
