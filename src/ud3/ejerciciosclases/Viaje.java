/*Implementa la clase Viaje que representa un viaje compartido ofrecido por un conductor, que será un usuario (clase User) previamente creado, y que saldrá en una fecha y a una hora determinada desde un PuntoGeografico de origen hasta otro de destino. En cada viaje se registrarán también el número de plazas de pasajeros ofrecidas por el conductor.

Crea al menos un constructor que permita crear un viaje con todos sus atributos.
Crea getters y setters si es necesario.
Crea un método mostrar que presente detalladamente y con claridad toda la información relativa a un viaje.
Redefine el método toString() para que devuelva una cadena con el siguiente formato:

dd/mm/aaaa hh:mm - conductor - PuntoOrigen >> PuntoDestino

Añade un método que devuelva una cadena de caracteres como la siguiente:

https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route=42.38972%2C-8.71068%3B42.60752%2C-8.47149

Donde los valores coloreados se sustituyan por la latitud y longitud del punto.

public String urlOpenStreetMaps();
*/

import java.time.LocalDateTime;

public class Viaje {
    private User conductor; // Conductor del viaje
    private PuntoGeografico origen; // Punto de origen
    private PuntoGeografico destino; // Punto de destino
    private LocalDateTime fechaHora; // Fecha y hora del viaje
    private int plazas; // Número de plazas ofrecidas

    // Constructor que permite crear un viaje con todos sus atributos
    public Viaje(User conductor, PuntoGeografico origen, PuntoGeografico destino, LocalDateTime fechaHora, int plazas) {
        this.con ductor = conductor;
        this.origen = origen;
        this.destino = destino;
        this.fechaHora = fechaHora;
        this.plazas = plazas;
    }

    // Método para mostrar la información del viaje
    public void mostrar() {
        System.out.println("Viaje:");
        System.out.println("Conductor: " + conductor);
        System.out.println("Origen: " + origen.urlOpenStreetMaps());
        System.out.println("Destino: " + destino.urlOpenStreetMaps());
        System.out.println("Fecha y Hora: " + fechaHora);
        System.out.println("Plazas disponibles: " + plazas);
    }

    // Sobrescribir el método toString()
    @Override
    public String toString() {
        return String.format("%1$td/%1$tm/%1$tY %1$tH:%1$tM - %2$s - %3$s >> %4$s", 
                             fechaHora, conductor, origen, destino);
    }

    // Método para generar URL de OpenStreetMap para direcciones
    public String urlOpenStreetMaps() {
        return "https://www.openstreetmap.org/directions?engine=fossgis_osrm_car&route=" + 
               origen.getLatitud() + "%2C" + origen.getLongitud() + "%3B" + 
               destino.getLatitud() + "%2C" + destino.getLongitud();
    }
}
