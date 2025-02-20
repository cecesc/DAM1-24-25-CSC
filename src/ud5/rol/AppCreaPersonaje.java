package ud5.rol;

import ud5.rol.Personaje.raza;

public class AppCreaPersonaje {
    public static void main(String[] args) throws Exception {
        Personaje per = new Personaje("Bac");

        Personaje personaje = new Personaje("perso", raza.ELFO);
        per.mostrar();

        System.out.println(personaje);

    }

}
