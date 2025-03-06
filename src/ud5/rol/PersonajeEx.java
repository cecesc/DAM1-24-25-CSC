package ud5.rol;

import java.util.ArrayList;
import java.util.List;

public class PersonajeEx extends Personaje {
    public int monedas = 0;
    public List<Item> inventario = new ArrayList<>();
    
    public Item itemManoIzq = null;
    public Item itemManoDch = null;
    public Armadura armaduraCabeza = null;
    public Armadura armaduraCuerpo = null;


    public PersonajeEx(String nombre, raza raza) {
        super(nombre, raza);
    }

    public PersonajeEx(String nombre) {
        super(nombre);
    }

    public int getMonedas() {
        return monedas;
    }

    public void setMonedas(int monedas) {
        if (monedas < 0) {
            throw new IllegalArgumentException("Las monedas no pueden ser negativas.");
        }
        this.monedas = monedas;
    }


    public List<Item> getInventario() {
        return new ArrayList<>(inventario);
    }

    public double getCargaMaxima() {
        return 50 + (constitucion * 2);
    }

    public double getCargaActual() {
        double carga = 0;
        for (Item item : inventario) {
            carga += item.getPeso();
        }
        return carga;
    }

    public boolean addToInventario(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("El item no puede ser nulo.");
        }
        if (getCargaActual() + item.getPeso() > getCargaMaxima()) {
            return false;
        }
        inventario.add(item);
        return true;
    }



    public void mostrarInventario() {
        System.out.println("Inventario de " + nombre + ":");
        for (int i = 0; i < inventario.size(); i++) {
            System.out.println((i + 1) + ". " + inventario.get(i));
        }
        System.out.printf("Carga total transportada: %.2f/%.0f kilos\n", getCargaActual(), getCargaMaxima());
    }


    public boolean equipar(Item item) {
        if (item instanceof Armadura) {
            Armadura armadura = (Armadura) item;
            switch (armadura.getTipo()) {
                case YELMO:
                    if (armaduraCabeza == null) {
                        armaduraCabeza = armadura;
                        return true;
                    }
                    break;
                case ARMADURA:
                    if (armaduraCuerpo == null) {
                        armaduraCuerpo = armadura;
                        return true;
                    }
                    break;
                case ESCUDO:
                    if (itemManoDch == null) {
                        itemManoDch = armadura;
                        return true;
                    } else if (itemManoIzq == null) {
                        itemManoIzq = armadura;
                        return true;
                    }
                    break;
            }
        } else if (item instanceof Arma) {
            Arma arma = (Arma) item;
            if (arma.esDosManos()) {
                if (itemManoDch == null && itemManoIzq == null) {
                    itemManoDch = arma;
                    itemManoIzq = arma;
                    return true;
                }
            } else {
                if (itemManoDch == null) {
                    itemManoDch = arma;
                    return true;
                } else if (itemManoIzq == null) {
                    itemManoIzq = arma;
                    return true;
                }
            }
        }
        return false;
    }


    public void mostrarEquipo() {
        if (armaduraCabeza != null) {
            System.out.println("- " + armaduraCabeza.getNombre() + " (+" + armaduraCabeza.getDefensa() + " defensa)");
        }
        if (armaduraCuerpo != null) {
            System.out.println("- " + armaduraCuerpo.getNombre() + " (+" + armaduraCuerpo.getDefensa() + " defensa)");
        }
        if (itemManoDch instanceof Arma) {
            Arma arma = (Arma) itemManoDch;
            System.out.println("- " + arma.getNombre() + " (+" + arma.getAtaque() + " ataque)");
        } else if (itemManoDch instanceof Armadura) {
            Armadura escudo = (Armadura) itemManoDch;
            System.out.println("- " + escudo.getNombre() + " (+" + escudo.getDefensa() + " defensa)");
        }
        if (itemManoIzq instanceof Armadura && itemManoIzq != itemManoDch) {
            Armadura escudo = (Armadura) itemManoIzq;
            System.out.println("- " + escudo.getNombre() + " (+" + escudo.getDefensa() + " defensa)");
        }
    }
}
