package ud4.practicas.agenda;
import java.util.ArrayList;
import java.util.Scanner;

class Contacto {
    String nombre, apellidos, telefono, email;

    public Contacto(String nombre, String apellidos, String telefono, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.email = email;
    }

    @Override
    public String toString() {
        return nombre + " " + apellidos + " | Tel: " + telefono + " | Email: " + email;
    }
}

public class Agenda {
    public static void main(String[] args) {
        ArrayList<Contacto> agenda = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\nAGENDA");
            System.out.println("1. Añadir contacto");
            System.out.println("2. Listar contactos");
            System.out.println("3. Eliminar contacto");
            System.out.println("4. Vaciar agenda");
            System.out.println("5. Buscar contacto");
            System.out.println("0. SALIR");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Apellidos: ");
                    String apellidos = scanner.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    agenda.add(new Contacto(nombre, apellidos, telefono, email));
                    System.out.println("Contacto añadido.");
                    break;
                case 2:
                    if (agenda.isEmpty()) {
                        System.out.println("La agenda está vacía");
                    } else {
                        for (int i = 0; i < agenda.size(); i++) {
                            System.out.println(i + ". " + agenda.get(i));
                        }
                    }
                    break;
                case 3:
                    System.out.print("Número del contacto a eliminar: ");
                    int index = scanner.nextInt();
                    if (index >= 0 && index < agenda.size()) {
                        agenda.remove(index);
                        System.out.println("Contacto eliminado.");
                    } else {
                        System.out.println("Índice no válido.");
                    }
                    break;
                case 4:
                    agenda.clear();
                    System.out.println("Agenda vaciada.");
                    break;
                case 5:
                    System.out.print("Nombre del contacto a buscar: ");
                    String buscado = scanner.nextLine();
                    boolean encontrado = false;
                    for (Contacto c : agenda) {
                        if (c.nombre.equalsIgnoreCase(buscado)) {
                            System.out.println(c);
                            encontrado = true;
                        }
                    }
                    if (!encontrado) {
                        System.out.println("No se encontró el contacto.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}