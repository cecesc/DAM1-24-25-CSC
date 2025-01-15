package ud4.arraysejercicios;


public class EP0511 {
   public static int[] buscarTodos(int[] t, int clave) {
        // Primero, contamos cuántas veces aparece la clave en el array.
        int contador = 0;
        for (int i = 0; i < t.length; i++) {
            if (t[i] == clave) {
                contador++;
            }
        }

        // Si la clave no está, devolvemos un array vacío.
        if (contador == 0) {
            return new int[0];
        }

        // Creamos un array para almacenar los índices donde aparece la clave.
        int[] indices = new int[contador];
        int pos = 0;

        // Llenamos el array con los índices encontrados.
        for (int i = 0; i < t.length; i++) {
            if (t[i] == clave) {
                indices[pos++] = i;
            }
        }

        return indices;
    }

    public static void main(String[] args) {
        // Ejemplo de prueba
        int[] tabla = {1, 3, 7, 8, 7, 5, 6, 7, 8, 9};
        int clave = 7;

        int[] resultado = buscarTodos(tabla, clave);

        // Mostrar el resultado
        System.out.print("Índices encontrados: ");
        for (int indice : resultado) {
            System.out.print(indice + " ");
        }
    }
}
