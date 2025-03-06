package ud5.rol;

import java.util.ArrayList;
import java.util.List;

public class PersonajeEx extends Personaje {
    private int monedas = 0;
    private Item itemManoIzq;
    private Item itemManoDch;
    private Armadura armaduraCabeza;
    private Armadura armaduraCuerpo;

    private List<Item> inventario = new ArrayList<>();

    public PersonajeEx(String nombre, raza raza) {
        super(nombre, raza);
    }

    public boolean addToInventario(Item item) {
        double cargaMaxima = 50 + this.constitucion * 2;
        double cargaTotal = inventario.stream().mapToDouble(Item::getPeso).sum();

        if (cargaTotal + item.getPeso() <= cargaMaxima) {
            inventario.add(item);
            return true;
        }
        return false;
    }

    public void mostrarInventario() {
        System.out.println("Inventario de " + this.nombre + ":");
        double cargaTotal = 0;
        for (int i = 0; i < inventario.size(); i++) {
            Item item = inventario.get(i);
            cargaTotal += item.getPeso();
            System.out.println((i + 1) + ". " + item.getNombre() + ", peso: " + item.getPeso() + " kilos, precio: " + item.getPrecio() + " monedas");
        }
        System.out.println("Carga total transportada: " + cargaTotal + " / " + (50 + this.constitucion * 2) + " kilos");
    }

    public boolean equipar(Item item) {
        if (item instanceof Arma) {
            Arma arma = (Arma) item;
            if (arma.isDosManos()) {
                if (itemManoIzq == null && itemManoDch == null) {
                    itemManoIzq = arma;
                    itemManoDch = arma;
                    return true;
                }
            } else {
                if (itemManoIzq == null) {
                    itemManoIzq = arma;
                    return true;
                } else if (itemManoDch == null) {
                    itemManoDch = arma;
                    return true;
                }
            }
        } else if (item instanceof Armadura) {
            Armadura armadura = (Armadura) item;
            if (armadura.getTipo() == Armadura.Tipo.YELMO && armaduraCabeza == null) {
                armaduraCabeza = armadura;
                return true;
            } else if (armadura.getTipo() == Armadura.Tipo.ARMADURA && armaduraCuerpo == null) {
                armaduraCuerpo = armadura;
                return true;
            }
        }
        return false;
    }

}

