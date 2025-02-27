package ud5.rol;

import java.util.Scanner;

import ud5.rol.Personaje.raza;

public class AppCreaPersonaje {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        Personaje per = new Personaje("Bac");

        Personaje personaje = new Personaje("perso", raza.ELFO);
        per.mostrar();

        System.out.println(personaje);

        // Solicitar el nombre del personaje
        System.out.print("Introduce el nombre del personaje: ");
        String nombre = scanner.nextLine();

        // Solicitar la raza del personaje
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
                razaSeleccionada = Personaje.raza.HUMANO;
                break;
            case 2:
                razaSeleccionada = Personaje.raza.ELFO;
                break;
            case 3:
                razaSeleccionada = Personaje.raza.ENANO;
                break;
            case 4:
                razaSeleccionada = Personaje.raza.HOBBIT;
                break;
            case 5:
                razaSeleccionada = Personaje.raza.ORCO;
                break;
            case 6:
                razaSeleccionada = Personaje.raza.TROLL;
                break;
            default:
                System.out.println("Opción no válida. Se asignará la raza HUMANO por defecto.");
                razaSeleccionada = Personaje.raza.HUMANO;
                break;
        }

        // Crear el personaje
        Personaje personaje = new Personaje(nombre, razaSeleccionada);

        // Mostrar los detalles del personaje
        System.out.println("Personaje creado:");
        personaje.mostrar();

        scanner.close();
    }
}
    
    




