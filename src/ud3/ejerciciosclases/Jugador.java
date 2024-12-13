/* Queremos gestionar la plantilla de un equipo de fútbol. Para ello vamos a crear la clase Jugador. De cada jugador se guarda el DNI, el nombre, la posición en el campo - para simplificar, los jugadores pueden ser porteros, defensas, centrocampistas y delanteros - y su estatura. Define la clase Jugador y un enumerado para la posición en el campo. Implementa un método para mostrar la ficha de un jugador y constructores variados que permitan crear: 
jugadores sólo con nombre.
jugadores con nombre y posición
jugadores con todos los datos.

Crea getters que permitan recuperar los atributos de los jugadores. Crea un método que permita cambiar a un jugador de posición.

Crea un pequeño programa principal con ejemplos de uso de la clase Jugador.
*/

package ud3.ejerciciosclases;

// Enumerado para las posiciones en el campo
enum Posicion {
    PORTERO,
    DEFENSA,
    CENTROCAMPISTA,
    DELANTERO
}

// Clase Jugador
class Jugador {
    private String dni; // DNI del jugador
    private String nombre; // Nombre del jugador
    private Posicion posicion; // Posición del jugador en el campo
    private double estatura; // Estatura del jugador

    // Constructor para crear un jugador solo con nombre
    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    // Constructor para crear un jugador con nombre y posición
    public Jugador(String nombre, Posicion posicion) {
        this.nombre = nombre;
        this.posicion = posicion;
    }

    // Constructor para crear un jugador con todos los datos
    public Jugador(String dni, String nombre, Posicion posicion, double estatura) {
        this.dni = dni;
        this.nombre = nombre;
        this.posicion = posicion;
        this.estatura = estatura;
    }

    // Métodos getters para acceder a los atributos
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

    // Método para cambiar la posición del jugador
    public void cambiarPosicion(Posicion nuevaPosicion) {
        this.posicion = nuevaPosicion;
    }

    // Método para mostrar la ficha del jugador
    public void mostrarFicha() {
        System.out.println("DNI: " + (dni != null ? dni : "No disponible"));
        System.out.println("Nombre: " + nombre);
        System.out.println("Posición: " + (posicion != null ? posicion : "No disponible"));
        System.out.println("Estatura: " + estatura + " m");
        System.out.println("-----------------------------");
    }
    // Clase principal
    public static void main(String[] args) {
        // Crear jugadores
        Jugador jugador1 = new Jugador("Juan Pérez"); // Jugador solo con nombre
        Jugador jugador2 = new Jugador("Carlos López", Posicion.DEFENSA); // Jugador con nombre y posición
        Jugador jugador3 = new Jugador("12345678A", "María García", Posicion.CENTROCAMPISTA, 1.70); // Jugador con todos
                                                                                                    // los datos

        // Mostrar fichas de los jugadores
        System.out.println("Fichas de los jugadores:");
        jugador1.mostrarFicha(); // Mostrar ficha del jugador 1
        jugador2.mostrarFicha(); // Mostrar ficha del jugador 2
        jugador3.mostrarFicha(); // Mostrar ficha del jugador 3

        // Cambiar la posición de un jugador
        jugador3.cambiarPosicion(Posicion.DELANTERO); // Cambiar la posición de María García a DELANTERO
        System.out.println("Después de cambiar la posición de María García:");
        jugador3.mostrarFicha(); // Mostrar ficha actualizada del jugador 3
    }

}


