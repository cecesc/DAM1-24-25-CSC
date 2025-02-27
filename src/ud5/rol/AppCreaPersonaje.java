package ud5.rol;

import java.util.Scanner;

import ud5.rol.Personaje.raza;

public class AppCreaPersonaje {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Introduce el nombre del personaje: ");
        String nombre = scanner.nextLine();

        System.out.println("Selecciona la raza del personaje:");
        System.out.println("1. HUMANO");
        System.out.println("2. ELFO");
        System.out.println("3. ENANO");
        System.out.println("4. HOBBIT");
        System.out.println("5. ORCO");
        System.out.println("6. TROLL");
        System.out.print("Opción: ");
        int opcionRaza = scanner.nextInt();

        Personaje.raza razaSeleccionada = null;

        switch (opcionRaza) {
            case 1:
                razaSeleccionada = raza.HUMANO;
                break;
            case 2:
                razaSeleccionada = raza.ELFO;
                break;
            case 3:
                razaSeleccionada = raza.ENANO;
                break;
            case 4:
                razaSeleccionada = raza.HOBBIT;
                break;
            case 5:
                razaSeleccionada = raza.ORCO;
                break;
            case 6:
                razaSeleccionada = raza.TROLL;
                break;
            default:
                System.out.println("Opción no válida. Se asignará la raza HUMANO por defecto.");
                razaSeleccionada = raza.HUMANO;
                break;
        }

        Personaje persona = new Personaje(nombre, razaSeleccionada);

        System.out.println("Personaje creado:");
        persona.mostrar();

        scanner.close();
    }
}
