package ud6.practicas.biblioteca;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Biblioteca {
    private static int contadorBibliotecas = 1;
    private String nombreBiblioteca;
    static Scanner s = new Scanner(System.in);
    private ArrayList<Libro> libros = new ArrayList<>();

    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca + contadorBibliotecas;
        System.out.println("Número de biblioteca " + contadorBibliotecas);
        contadorBibliotecas++;
    }

    public void iniciarGestionBiblioteca() {
        int opcion;
        do {
            opcion = menu();
            switch (opcion) {
                case 1: listarlibros();
                case 2: nuevoLibro();
                case 3: eliminarArticulo();
                case 4: modificarArticulo();
                case 5: entradaLibros();
                case 6: salidaMercancia();
                case 9: modificarCodigo();
            }
        } while (opcion != 7);
    }

    private int menu() {
        pintaTitulo("BIBLIOTECA " + this.nombreBiblioteca);
        System.out.println("1. Listado");
        System.out.println("2. Alta");
        System.out.println("3. Baja");
        System.out.println("4. Modificación de artículo (excepto código)");
        System.out.println("5. Entrada de mercancía");
        System.out.println("6. Salida de mercancía");
        System.out.println("7. Salir");
        System.out.println("9. CAMBIO DE CÓDIGO de artículo");
        System.out.print("Introduzca una opción: ");
        return s.nextInt();
    }

    private void listarlibros() {
        pintaTitulo("LISTADO");
        for (Libro a : libros) {
            System.out.println(a);
        }
    }

    private void nuevoLibro() {
        pintaTitulo("NUEVO LIBRO");
        int codigoIn = generarCodigoLibro();
        System.out.println("Código válido: " + codigoIn);
        System.out.print("Título: ");
        String titulo = s.next();
        System.out.print("Autor: ");
        String autor = s.next();
        System.out.print("Editorial: ");
        String editorial = s.next();
        System.out.print("Referencia Bibliográfica: ");
        String ref = s.next();
        System.out.print("Año Publicación: ");
        int año = s.nextInt();
        System.out.print("Stock: ");
        int stock = s.nextInt();
        libros.add(new Libro(codigoIn, titulo, autor, editorial, ref, año, stock));
    }

    private void eliminarArticulo() {
        pintaTitulo("BAJA");
        System.out.print("Código del artículo: ");
        int codigo = s.nextInt();
        if (!existeCodigo(codigo)) {
            System.out.println("No existe ese código.");
        } else {
            libros.remove(posicionConCodigo(codigo));
            System.out.println("Artículo eliminado.");
        }
    }

    private void modificarArticulo() {
        pintaTitulo("MODIFICACIÓN");
        System.out.print("Código del libro: ");
        int codigo = s.nextInt();
        if (!existeCodigo(codigo)) {
            System.out.println("No existe ese código.");
            return;
        }

        Libro libro = libros.get(posicionConCodigo(codigo));

        System.out.println("Título actual: " + libro.getTitulo());
        System.out.print("Nuevo título (dejar en blanco para mantener): ");
        String nuevo = s.next();
        if (!nuevo.isEmpty()) libro.setTitulo(nuevo);

        System.out.println("Autor actual: " + libro.getAutor());
        System.out.print("Nuevo autor: ");
        nuevo = s.next();
        if (!nuevo.isEmpty()) libro.setAutor(nuevo);

        System.out.println("Editorial actual: " + libro.getEditorial());
        System.out.print("Nueva editorial: ");
        nuevo = s.next();
        if (!nuevo.isEmpty()) libro.setEditorial(nuevo);

        System.out.println("Ref. Bibliográfica actual: " + libro.getRefBibliografica());
        System.out.print("Nueva referencia: ");
        nuevo = s.next();
        if (!nuevo.isEmpty()) libro.setRefBibliografica(nuevo);

        System.out.println("Año publicación actual: " + libro.getAñoPublicacion());
        System.out.print("Nuevo año: ");
        int nuevoAño = s.nextInt();
        libro.setAñoPublicacion(nuevoAño);
    }

    private void entradaLibros() {
        pintaTitulo("ENTRADA DE LIBROS");
        System.out.print("Código del libro: ");
        int codigo = s.nextInt();
        if (!existeCodigo(codigo)) {
            System.out.println("No existe ese código.");
            return;
        }
        Libro libro = libros.get(posicionConCodigo(codigo));
        System.out.print("Unidades que entran: ");
        int cantidad = s.nextInt();
        libro.setStock(libro.getStock() + cantidad);
        System.out.println("Stock actualizado: " + libro.getStock());
    }

    private void salidaMercancia() {
        pintaTitulo("SALIDA DE MERCANCÍA");
        System.out.print("Código del libro: ");
        int codigo = s.nextInt();
        if (!existeCodigo(codigo)) {
            System.out.println("No existe ese código.");
            return;
        }
        Libro libro = libros.get(posicionConCodigo(codigo));
        System.out.print("Unidades que salen: ");
        int cantidad = s.nextInt();
        if (libro.getStock() >= cantidad) {
            libro.setStock(libro.getStock() - cantidad);
            System.out.println("Stock actualizado: " + libro.getStock());
        } else {
            System.out.println("No hay suficiente stock.");
        }
    }

    private void modificarCodigo() {
        pintaTitulo("MODIFICAR CÓDIGO");
        System.out.print("Código actual: ");
        int codigo = s.nextInt();
        if (!existeCodigo(codigo)) {
            System.out.println("No existe ese código.");
            return;
        }
        System.out.print("Nuevo código: ");
        int nuevo = s.nextInt();
        if (existeCodigo(nuevo)) {
            System.out.println("Código ya existente.");
        } else {
            libros.get(posicionConCodigo(codigo)).setCodigo(nuevo);
            System.out.println("Código actualizado.");
        }
    }

    private boolean existeCodigo(int codigo) {
        return libros.stream().anyMatch(l -> l.getCodigo() == codigo);
    }

    private int posicionConCodigo(int codigo) {
        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getCodigo() == codigo) return i;
        }
        return -1;
    }

    private int generarCodigoLibro() {
        Random r = new Random();
        int codigo;
        do {
            codigo = r.nextInt(1000) + 1;
        } while (existeCodigo(codigo));
        return codigo;
    }

    private void pintaTitulo(String titulo) {
        System.out.println("\n" + titulo);
        System.out.println("=".repeat(titulo.length()));
    }
}
