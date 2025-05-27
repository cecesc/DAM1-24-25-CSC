package ud7.futbol;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Testeo {
    public static void main(String[] args) {
        List<Jugador> jugadores = new ArrayList<>();

        // Crear jugadores y porteros
        Portero portero1 = new Portero("Portero1", "Portero", 10, 0, 0, 0, 20, 5);
        Portero portero2 = new Portero("Portero2", "Portero", 15, 0, 0, 0, 15, 8);
        Portero portero3 = new Portero("Portero3", "Portero", 20, 0, 0, 0, 10, 10);

        Jugador jugador1 = new Jugador("Jugador1", "Delantero", 20, 15, 2, 0);
        Jugador jugador2 = new Jugador("Jugador2", "Defensa", 25, 5, 3, 1);

        // Agregar jugadores a la lista
        jugadores.add(portero1);
        jugadores.add(portero2);
        jugadores.add(portero3);
        jugadores.add(jugador1);
        jugadores.add(jugador2);

        // Recorrer la lista y guardar información de los porteros en un archivo
        try {
            FileOutputStream fileOut = new FileOutputStream("porteros.dat");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            for (Jugador jugador : jugadores) {
                if (jugador instanceof Portero) {
                    jugador.imprimir(); // Mostrar información de portero
                    objectOut.writeObject(jugador); // Guardar portero en archivo
                }
            }
            objectOut.close();
            fileOut.close();
            System.out.println("La información de los porteros ha sido guardada en porteros.dat");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}