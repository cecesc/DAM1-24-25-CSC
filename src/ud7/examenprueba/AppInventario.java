package ud7.examenprueba;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class AppInventario {
    private static final String FICHERO = "src/ud7/examenprueba/inventario.dat";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE INVENTARIO ---");
            System.out.println("1. Agregar producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar producto por código");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1:
                    agregarProducto(sc);
                    break;
                case 2:
                    listarProductos();
                    break;
                case 3:
                    buscarProductoPorCodigo(sc);
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        sc.close();
    }

    // Método para agregar un producto
    private static void agregarProducto(Scanner sc) {
        try {
            System.out.print("Código del producto: ");
            int codigo = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            System.out.print("Nombre del producto: ");
            String nombre = sc.nextLine();

            if (nombre.trim().isEmpty()) {
                System.out.println("Error: el nombre no puede estar en blanco.");
                return;
            }

            System.out.print("Cantidad: ");
            int cantidad = sc.nextInt();

            System.out.print("Precio: ");
            double precio = sc.nextDouble();

            List<Producto> productos = leerProductos();

            for (Producto p : productos) {
                if (p.getCodigo() == codigo) {
                    System.out.println("Error: el código ya existe.");
                    return;
                }
            }

            Producto nuevo = new Producto(codigo, nombre, cantidad, precio);
            productos.add(nuevo);
            escribirProductos(productos);

            System.out.println("Producto agregado correctamente.");

        } catch (InputMismatchException e) {
            System.out.println("Error: entrada no válida.");
            sc.nextLine(); // limpiar entrada inválida
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al guardar el producto: " + e.getMessage());
        }
    }

    // Método para listar todos los productos
    private static void listarProductos() {
        try {
            List<Producto> productos = leerProductos();

            if (productos.isEmpty()) {
                System.out.println("El inventario está vacío.");
                return;
            }

            productos.sort(Comparator.comparingInt(Producto::getCodigo));

            System.out.println("\n--- LISTA DE PRODUCTOS ---");
            for (Producto p : productos) {
                System.out.println(p);
            }

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el inventario: " + e.getMessage());
        }
    }

    // Método para buscar un producto por su código
    private static void buscarProductoPorCodigo(Scanner sc) {
        System.out.print("Introduce el código a buscar: ");
        int codigo = sc.nextInt();

        try {
            List<Producto> productos = leerProductos();

            for (Producto p : productos) {
                if (p.getCodigo() == codigo) {
                    System.out.println("Producto encontrado:\n" + p);
                    return;
                }
            }

            System.out.println("Producto no encontrado.");

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al buscar en el inventario: " + e.getMessage());
        }
    }

    // Método para leer todos los productos desde el fichero
    private static List<Producto> leerProductos() throws IOException, ClassNotFoundException {
        File fichero = new File(FICHERO);
        if (!fichero.exists() || fichero.length() == 0) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FICHERO))) {
            return (List<Producto>) ois.readObject();
        }
    }

    // Método para escribir todos los productos en el fichero
    private static void escribirProductos(List<Producto> productos) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FICHERO))) {
            oos.writeObject(productos);
        }
    }
}
