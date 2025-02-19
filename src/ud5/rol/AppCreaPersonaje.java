package ud5.rol;

import ud5.rol.Personaje.raza;

public class AppCreaPersonaje {
    public static void main(String[] args) {
        Personaje personaje = new Personaje("perso", raza.HOBBIT);
        personaje.mostrar();
        
        System.out.println( personaje);

            }
        
}
