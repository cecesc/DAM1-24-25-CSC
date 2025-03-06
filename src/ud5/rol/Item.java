package ud5.rol;

import java.util.Objects;

public class Item {
    public String nombre;
    public double peso;
    public int precio;

    public Item(String nombre, double peso, int precio) {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (peso <= 0 || precio < 0) {
            throw new IllegalArgumentException("El peso debe ser positivo y el precio no puede ser negativo.");
        }
        this.nombre = nombre;
        this.peso = peso;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeso() {
        return peso;
    }

    public int getPrecio() {
        return precio;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Item item = (Item) obj;
        return Double.compare(item.peso, peso) == 0 && 
        precio == item.precio && Objects.equals(nombre, item.nombre);
    }

    @Override
    public String toString() {
        return nombre + ", peso: " + peso + " kilos, precio: " + precio + " monedas";
    }
}
