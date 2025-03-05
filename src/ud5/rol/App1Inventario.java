package ud5.rol;

import ud5.rol.Personaje.raza;

public class App1Inventario {
    public static void main(String[] args) {
        PersonajeEx arturo = new PersonajeEx("Arturo", raza.HUMANO);
        PersonajeEx valkiria = new PersonajeEx("Valkiria", raza.ELFO);

        Personaje[] personajes = {arturo, valkiria};
        personajes = Personaje.sortAgilidadDesc(personajes);

        // Mostrar los personajes ordenados por agilidad
        for (Personaje p : personajes) {
            System.out.println(p.getNombre() + ": Agilidad = " + p.agilidad);
        }
    }
}
