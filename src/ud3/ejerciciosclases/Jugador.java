/* Queremos gestionar la plantilla de un equipo de fútbol. Para ello vamos a crear la clase Jugador. 
De cada jugador se guarda el DNI, el nombre, la posición en el campo - para simplificar, los jugadores 
pueden ser porteros, defensas, centrocampistas y delanteros - y su estatura. Define la clase Jugador y
 un enumerado para la posición en el campo. Implementa un método para mostrar la ficha de un jugador y 
 constructores variados que permitan crear: 
jugadores sólo con nombre.
jugadores con nombre y posición
jugadores con todos los datos.

Crea un pequeño programa principal con ejemplos de uso de la clase Jugador */

package ud3.ejerciciosclases;

enum Posicion {
    PORTERO,
    DEFENSA,
    CENTROCAMPISTA,
    DELANTERO
}

class Jugador {
    private String dni;
    private String nombre;
    private Posicion posicion;
    private double estatura;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String nombre, Posicion posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    public Jugador(String dni, String nombre, Posicion posicion, double estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.posicion = posicion;
        this.estatura = estatura;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public double getEstatura() {
        return estatura;
    }

    public void cambiarPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    public void mostrarFicha() {
        System.out.println("DNI: " + (dni != null ? dni : "No disponible"));
        System.out.println("Nombre: " + nombre);
        System.out.println("Posición: " + (posicion != null ? posicion : "No disponible"));
        System.out.println("Estatura: " + estatura + " m");
        System.out.println("-----------------------------");
    }

    public static void main(String[] args) {
        Jugador jugador1 = new Jugador("Juan Pérez");
        Jugador jugador2 = new Jugador("Carlos López", Posicion.DEFENSA);
        Jugador jugador3 = new Jugador("12345678A", "María García", Posicion.CENTROCAMPISTA, 1.70);

        System.out.println("Fichas de los jugadores:");
        jugador1.mostrarFicha();
        jugador2.mostrarFicha();
        jugador3.mostrarFicha();

        jugador3.cambiarPosicion(Posicion.DELANTERO);
        System.out.println("Después de cambiar la posición de María García:");
        jugador3.mostrarFicha();
    }

}
