package ud5.clasesejercicios;

public class Cola extends Lista {
    private Integer[] elementos;
    private int primero;  // Índice del primer elemento
    private int ultimo;   // Índice donde se insertará el siguiente elemento
    private int tamaño;   // Número de elementos actuales

    public Cola(int capacidadInicial) {
        elementos = new Integer[capacidadInicial];
        primero = 0;
        ultimo = 0;
        tamaño = 0;
    }

    public Cola() {
        this(10);  // Capacidad por defecto
    }

    public void encolar(Integer elemento) {
        if (tamaño == elementos.length) {
            ampliarArray();
        }
        elementos[ultimo] = elemento;
        ultimo = (ultimo + 1) % elementos.length;  // Circular
        tamaño++;
    }

    public Integer desencolar() {
        if (estaVacia()) {
            return null;
        }
        Integer elemento = elementos[primero];
        elementos[primero] = null;  // Opcional (para no dejar referencias 'fantasma')
        primero = (primero + 1) % elementos.length;
        tamaño--;
        return elemento;
    }

    public boolean estaVacia() {
        return tamaño == 0;
    }

    public int tamaño() {
        return tamaño;
    }

    public void mostrar() {
        System.out.print("Cola: ");
        for (int i = 0; i < tamaño; i++) {
            System.out.print(elementos[(primero + i) % elementos.length] + " ");
        }
        System.out.println();
    }

    private void ampliarArray() {
        Integer[] nuevoArray = new Integer[elementos.length * 2];
        for (int i = 0; i < tamaño; i++) {
            nuevoArray[i] = elementos[(primero + i) % elementos.length];
        }
        elementos = nuevoArray;
        primero = 0;
        ultimo = tamaño;
    }
}
