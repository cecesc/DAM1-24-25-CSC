package ud5.rol;

import ud5.rol.Personaje.raza;

public class App1Inventario {
    public static void main(String[] args) {

        System.out.println("1. Inventario de personaje");
        System.out.println("==========================");

        PersonajeEx arturo = new PersonajeEx("Arturo", raza.HUMANO);

        Item cotaMalla = new Item("Cota de Malla", 10.0, 2000);
        Item espadaLarga = new Item("Espada larga", 3.0, 10000);
        Item espadon = new Item("Espadón a dos manos", 5.0, 1000);
        Item pan = new Item("Pan", 1.0, 1);
        Item agua = new Item("Agua", 2.0, 1);
        Item daga = new Item("Daga", 0.5, 200);
        Item antorcha = new Item("Antorcha", 0.75, 10);

        arturo.addToInventario(cotaMalla);
        arturo.addToInventario(espadaLarga);
        arturo.addToInventario(espadon);
        arturo.addToInventario(pan);
        arturo.addToInventario(agua);
        arturo.addToInventario(daga);
        arturo.addToInventario(antorcha);

        System.out.println();
        arturo.mostrarInventario();
    }
}
