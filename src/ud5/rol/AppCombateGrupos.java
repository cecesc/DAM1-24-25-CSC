package ud5.rol;

import java.util.Random;
import ud5.rol.Personaje.raza;

public class AppCombateGrupos {
    public static void main(String[] args) {
        Personaje[] grupo1 = generarGrupo("Equipo A");
        Personaje[] grupo2 = generarGrupo("Equipo B");

        System.out.println("=== FICHAS INICIALES ===");
        mostrarGrupo(grupo1);
        mostrarGrupo(grupo2);

        combatir(grupo1, grupo2);

        System.out.println("=== FICHAS FINALES ===");
        mostrarGrupo(grupo1);
        mostrarGrupo(grupo2);
    }

    public static Personaje[] generarGrupo(String nombreGrupo) {
        Random rdn = new Random();
        String[] nombres = { "Valquiria", "Casstel", "Draken", "Nicktos", "Bordomir", "Seraphea", "Strormentor",
                "Hados" };
        Personaje.raza[] razas = raza.values();

        int numPersonajes = rdn.nextInt(4) + 3;
        Personaje[] grupo = new Personaje[numPersonajes];

        for (int i = 0; i < numPersonajes; i++) {
            String nombre = nombres[rdn.nextInt(nombres.length)] + "-" + nombreGrupo;
            Personaje.raza raza = razas[rdn.nextInt(razas.length)];
            grupo[i] = new Personaje(nombre, raza);
        }
        return grupo;
    }

    public static void mostrarGrupo(Personaje[] grupo) {
        for (int i = 0; i < grupo.length; i++) {
            if (grupo[i] != null) {
                grupo[i].mostrar();
                System.out.println();
            }
        }
    }

    public static void combatir(Personaje[] grupo1, Personaje[] grupo2) {

        while (grupoVivo(grupo1) && grupoVivo(grupo2)) {
            for (int i = 0; i < grupo1.length; i++) {
                if (grupo1[i] != null && grupo1[i].estaVivo()) {
                    Personaje enemigo = obtenerEnemigoVivo(grupo2);
                    if (enemigo == null)
                        break;

                    int daño = grupo1[i].atacar(enemigo);
                    System.out.println(grupo1[i].getNombre() + " ataca a " + enemigo.getNombre() + " y causa " + daño
                            + " de daño.");
                    System.out.println();
                    if (!enemigo.estaVivo()) {
                        System.out.println(enemigo.getNombre() + " ha muerto.");
                        System.out.println();
                    }
                }
            }

            for (int i = 0; i < grupo2.length; i++) {
                if (grupo2[i] != null && grupo2[i].estaVivo()) {
                    Personaje enemigo = obtenerEnemigoVivo(grupo1);
                    if (enemigo == null)
                        break;

                    int daño = grupo2[i].atacar(enemigo);
                    System.out.println(grupo2[i].getNombre() + " ataca a " + enemigo.getNombre() + " y causa " + daño
                            + " de daño.");
                    System.out.println();
                    if (!enemigo.estaVivo()) {
                        System.out.println(enemigo.getNombre() + " ha muerto.");
                        System.out.println();
                    }
                }
            }
        }

        System.out.println("\n=== FIN DEL COMBATE ===");
        if (grupoVivo(grupo1)) {
            System.out.println("El equipo A ha ganado.");
            System.out.println();
        } else {
            System.out.println("El equipo B ha ganado.");
            System.out.println();
        }
    }

    public static boolean grupoVivo(Personaje[] grupo) {
        for (int i = 0; i < grupo.length; i++) {
            if (grupo[i] != null && grupo[i].estaVivo())
                return true;
        }
        return false;
    }

    public static Personaje obtenerEnemigoVivo(Personaje[] grupo) {
        for (int i = 0; i < grupo.length; i++) {
            if (grupo[i] != null && grupo[i].estaVivo()) {
                return grupo[i];
            }
        }
        return null;
    }
}
