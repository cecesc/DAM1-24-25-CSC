package ud5.apuntesherencia;

public class Empleado extends Persona {
    double salario;
    String estatura;

    Empleado() {

    }

    Empleado(String nombre, double salario) {
        this.nombre = nombre;
        this.salario = salario;
    }

    public Empleado(String nombre, int edad, String estatura, double salario) {
        super(nombre, edad);
        this.estatura = estatura;
        this.salario = salario;
    }

    @Override
    void mostrarDatos() {
        System.out.println("EMPLEADOS:");
        super.mostrarDatos();
        //System.out.println(getApellido2());
        System.out.println(salario + " euros anuales.");

    }

    public static void main(String[] args) {
        Empleado pepe = new Empleado("Pepe", 10000);
        Empleado maria = new Empleado("Maria", 25, "M", 30000);
        System.out.println(maria.edad);
        pepe.saludar();

        System.out.println(pepe.estatura);
        maria.mostrarDatos();
        
        Persona p= pepe ;
        System.out.println(p.estatura);
        p.mostrarDatos();

        
        Empleado maricarmen = (Empleado) p;
        System.out.println(maricarmen.estatura);
        maricarmen.mostrarDatos();


    }
}
