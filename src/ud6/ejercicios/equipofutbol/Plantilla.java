package ud6.ejercicios.equipofutbol;

import java.util.Map;

public class Plantilla {
public static void altaJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador jugador) {
        plantilla.put(dorsal, jugador);
    }

    public static Jugador eliminarJugador(Map<Integer, Jugador> plantilla, Integer dorsal) {
        return plantilla.remove(dorsal);
    }

    public static void mostrar(Map<Integer, Jugador> plantilla) {
        for (Map.Entry<Integer, Jugador> entry : plantilla.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }

    public static void mostrar(Map<Integer, Jugador> plantilla, String posicion) {
        for (Map.Entry<Integer, Jugador> entry : plantilla.entrySet()) {
            if (entry.getValue().getPosicion().name().equalsIgnoreCase(posicion)) {
                System.out.println(entry.getKey() + " - " + entry.getValue());
            }
        }
    }

    public static boolean editarJugador(Map<Integer, Jugador> plantilla, Integer dorsal, Jugador nuevo) {
        if (plantilla.containsKey(dorsal)) {
            Jugador existente = plantilla.get(dorsal);
            existente.setNombre(nuevo.getNombre());
            existente.setPosicion(nuevo.getPosicion());
            existente.setEstatura(nuevo.getEstatura());
            return true;
        }
        return false;
    }
}
