package ud5.clasesejercicios;

import java.util.Arrays;

public class Lista {
    private Integer[] elementos;

    public Lista() {
        elementos = new Integer[0];
    }

    public int length() {
        return elementos.length;
    }

    public void insertarFinal(Integer e) {
        elementos = Arrays.copyOf(elementos, elementos.length + 1);
        elementos[elementos.length - 1] = e;
    }

    public void insertarInicio(Integer e) {
        Integer[] aux = new Integer[elementos.length + 1];
        System.arraycopy(elementos, 0, aux, 1, elementos.length);
        aux[0] = e;
        elementos = aux;
    }

    public void insertarEn(Integer e, int i) {
        Integer[] aux = Arrays.copyOf(elementos, elementos.length + 1);
        aux[i] = e;
        System.arraycopy(elementos, i, aux, i + 1, elementos.length - i);
        elementos = aux;
    }

    public void insertarFinal(Lista l) {
        elementos = Arrays.copyOf(elementos, elementos.length + l.length());
        System.arraycopy(l.elementos, 0, elementos, elementos.length - l.length(), l.length());
    }

    public Integer eliminarEn(int i) {
        Integer e = null;

        if (i >= 0 && i < elementos.length) {
            e = elementos[i];
            Integer[] aux = Arrays.copyOf(elementos, elementos.length - 1);
            System.arraycopy(elementos, i + 1, aux, i, elementos.length - i - 1);
            elementos = aux;
        }

        return e;
    }

    public Integer valorEn(int i) {
        return (i >= 0 && i < elementos.length) ? elementos[i] : null;
    }

    public int buscar(Integer e) {
        int i = 0;
        int pos = -1;
        while (i < elementos.length && pos == -1) {
            if (elementos[i] == e)
                pos = i;
            i++;
        }

        return pos;
    }

    /*
     * public void mostrar(){
     * System.out.println(Arrays.toString(elementos));
     * }
     */

    @Override
    public String toString() {
        return Arrays.toString(elementos);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;

        Lista otra = (Lista) obj;

        return Arrays.equals(this.elementos, otra.elementos);
    }

    public static Lista concatena(Lista l1, Lista l2) {
        Lista l = new Lista();
        l.insertarFinal(l1);
        l.insertarFinal(l2);
        return l;
    }
}
