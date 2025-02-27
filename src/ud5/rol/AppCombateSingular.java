package ud5.rol;

import ud5.rol.Personaje.raza;

public class AppCombateSingular {
    public static void main(String[] args) {
        Personaje p1 = new Personaje("p1", raza.ORCO);
        Personaje p2 = new Personaje("p2");

        p1.mostrar();
        System.out.println();
        p2.mostrar();
        System.out.println();

        System.out.println("Antes del combate:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println();

        Personaje enemigo = (p1.getPuntoVida() > p2.getPuntoVida()) ? p1 : p2;
        Personaje defensor = (enemigo == p1) ? p2 : p1;

        if (p1.estaVivo() && p2.estaVivo()) {
            System.out.printf("%s(%d) ataca a %s(%d)\n\n", enemigo.getNombre(), enemigo.getPuntoVida(),
                    defensor.getNombre(), defensor.getPuntoVida());
            int daño = enemigo.atacar(defensor);
            if (daño > 0) {
                System.out.printf("El ataque tiene éxito! %s pierde %d puntos de vida.\n\n", defensor.getNombre(), daño);
            } else {
                System.out.printf("%s esquiva el ataque!\n\n", defensor.getNombre());
            }
            if (!defensor.estaVivo()) {
                System.out.printf("%s ha muerto! Fin del combate.\n\n", defensor.getNombre());
            }
        
        }

        System.out.println("Después del combate:");
        System.out.println(p1);
        System.out.println(p2);

    }
}
