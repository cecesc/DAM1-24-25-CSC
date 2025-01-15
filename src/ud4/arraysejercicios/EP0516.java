public class MapaDeJuego {

    public static boolean sePuedeViajar(boolean[][] mapa, int origen, int destino) {
        int n = mapa.length; // Número de lugares
        boolean[] visitados = new boolean[n]; // Array para marcar lugares visitados

        return dfs(mapa, origen, destino, visitados);
    }

    private static boolean dfs(boolean[][] mapa, int actual, int destino, boolean[] visitados) {
        // Si ya estamos en el destino, devolvemos true
        if (actual == destino) {
            return true;
        }

        // Marcamos el lugar actual como visitado
        visitados[actual] = true;

        // Recorremos todos los lugares conectados al lugar actual
        for (int i = 0; i < mapa.length; i++) {
            if (mapa[actual][i] && !visitados[i]) { // Si hay conexión y no hemos visitado el lugar
                if (dfs(mapa, i, destino, visitados)) { // Llamada recursiva
                    return true;
                }
            }
        }

        // Si no encontramos una ruta, devolvemos false
        return false;
    }

    public static void main(String[] args) {
        // Ejemplo de mapa de juego
        boolean[][] mapa = {
            {false, true, false, false, false},
            {false, false, true, false, false},
            {false, false, false, true, false},
            {false, false, false, false, true},
            {false, false, false, false, false}
        };

        int origen = 0;
        int destino = 4;

        if (sePuedeViajar(mapa, origen, destino)) {
            System.out.println("Es posible viajar del lugar " + origen + " al lugar " + destino);
        } else {
            System.out.println("No es posible viajar del lugar " + origen + " al lugar " + destino);
        }
    }
}
