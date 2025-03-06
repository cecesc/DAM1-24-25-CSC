package ud5.clasesejercicios;

public class Colores {

    private String[] colores;
    private int cantidad;

    public Colores() {
        colores = new String[20]; // Capacidad inicial, se puede ampliar si hace falta
        colores[0] = "Rojo";
        colores[1] = "Verde";
        colores[2] = "Azul";
        colores[3] = "Amarillo";
        colores[4] = "Naranja";
        colores[5] = "Morado";
        colores[6] = "Rosa";
        colores[7] = "Marrón";
        colores[8] = "Negro";
        colores[9] = "Blanco";
        cantidad = 10; // Hay 10 colores iniciales
    }

    public void añadirColor(String color) {
        if (buscar(color) == -1) {
            if (cantidad == colores.length) {
                ampliarArray();
            }
            colores[cantidad] = color;
            cantidad++;
        }
    }

    private void ampliarArray() {
        String[] nuevoArray = new String[colores.length * 2];
        System.arraycopy(colores, 0, nuevoArray, 0, colores.length);
        colores = nuevoArray;
    }

    public String[] coloresAlAzar(int n) {
        if (n > cantidad) {
            throw new IllegalArgumentException("No hay suficientes colores disponibles.");
        }

        String[] copia = new String[cantidad];
        System.arraycopy(colores, 0, copia, 0, cantidad);

        barajar(copia);

        String[] seleccionados = new String[n];
        System.arraycopy(copia, 0, seleccionados, 0, n);

        return seleccionados;
    }

    private void barajar(String[] array) {
        for (int i = array.length - 1; i > 0; i--) {
            int j = (int) (Math.random() * (i + 1));
            String temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    public void mostrarColores() {
        System.out.print("[");
        for (int i = 0; i < cantidad; i++) {
            System.out.print(colores[i]);
            if (i < cantidad - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    private int buscar(String color) {
        for (int i = 0; i < cantidad; i++) {
            if (colores[i].equals(color)) {
                return i;
            }
        }
        return -1;
    }
}

