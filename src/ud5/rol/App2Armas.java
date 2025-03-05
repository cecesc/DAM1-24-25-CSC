package ud5.rol;

import ud5.rol.Personaje.raza;

public class App2Armas {
    public static void main(String[] args) {
        PersonajeEx arturo = new PersonajeEx("Arturo", raza.HUMANO);

        // Agregar items
        Item cota = new Item("Cota de Malla", 10.0, 2000);
        arturo.addToInventario(cota);
        // Más items...

        arturo.mostrarInventario();
    }
}
