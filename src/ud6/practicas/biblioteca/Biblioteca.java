package ud6.practicas.biblioteca;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Biblioteca {
    static int contadorBibliotecas = getNumeroBibliotecasEnArchivos();
    private String nombreBiblioteca;
    static Scanner s = new Scanner(System.in);
    private String NOMBRE_FICHERO;
    private ArrayList<Libro> libros = new ArrayList<Libro>();

    public Biblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca;
        this.NOMBRE_FICHERO = "biblioteca" + contadorBibliotecas + ".obj";
        System.out.println("Numero de biblioteca " + contadorBibliotecas);
        guardarLibros();
        contadorBibliotecas++;

    }

    public void iniciarGestionBiblioteca() {

        // RECUPERAMOS LA COLECCION DESDE FICHERO
        cargarLibros();

        // Scanner s = new Scanner(System.in);

        // MENU ///////////////////////////////////////////////////////////////////
        int opcion;
        do {
            opcion = menu();
            if (opcion == 1)
                listarlibros();
            if (opcion == 2)
                nuevoLibro();
            if (opcion == 3)
                eliminarArticulo();
            if (opcion == 4)
                modificarArticulo();
            if (opcion == 5)
                entradaLibros();
            if (opcion == 6)
                salidaMercancia();
            if (opcion == 8)
                guardarLibros();
            if (opcion == 9)
                modificarCodigo();
        } while (opcion != 7);
        guardarLibros();
    }

    private int menu() {
        pintaTitulo("BIBLIOTECA " + this.nombreBiblioteca);
        System.out.println("1. Listado");
        System.out.println("2. Alta");
        System.out.println("3. Baja");
        System.out.println("4. Modificación de articulo (excepto codigo)");
        System.out.println("5. Entrada de mercancía");
        System.out.println("6. Salida de mercancía");
        System.out.println("7. Salir (ojo NO guarda)");
        System.out.println("8. Guardar Todos los libros");
        System.out.println("9. CAMBIO DE CODIGO de articulo");
        System.out.print("Introduzca una opción: ");
        return s.nextInt();
    }

    // LISTADO ////////////////////////////////////////////////////////////
    private void listarlibros() {
        pintaTitulo("LISTADO");

        for (Libro a : libros) {
            System.out.println(a);
        }
        return;

    }

    // ALTA ///////////////////////////////////////////////////////////////
    private void nuevoLibro() {
        String tituloIn, autorIn, editorialIn, refBibliograficaIn;
        Integer codigoIn, añoPublicacion, stock;

        pintaTitulo("NUEVO LIBRO");

        codigoIn = generarCodigoLibro();
        pintaTitulo("DATOS DEL NUEVO ARTICULO");
        System.out.println("Codigo valido: " + codigoIn);
        System.out.print("Titulo: ");
        tituloIn = s.next();
        System.out.print("Autor: ");
        autorIn = s.next();
        System.out.print("Editorial: ");
        editorialIn = s.next();
        System.out.print("Referencia Bibliografica: ");
        refBibliograficaIn = s.next();
        System.out.print("Año Publicacion: ");
        añoPublicacion = s.nextInt();
        System.out.print("Stock: ");
        stock = s.nextInt();

        libros.add(new Libro(codigoIn, tituloIn, autorIn, editorialIn, refBibliograficaIn, añoPublicacion, stock));
        // }
    }

    // BAJA ///////////////////////////////////////////////////////////////
    private void eliminarArticulo() {
        Integer codigoIn;
        pintaTitulo("BAJA");
        System.out.print("Por favor, introduzca el código del artículo: ");
        codigoIn = s.nextInt();
        if (!existeCodigo(codigoIn)) {
            System.out.println("Lo siento, el código introducido no existe.");
        } else {
            // como obtengo uyn objetyo para un codigo determinado
            libros.remove(posicionConCodigo(codigoIn));
            System.out.println("Artículo borrado. Con codigo: " + codigoIn);
        }
        return;
    }

    // MODIFICACIÓN ///////////////////////////////////////////////////////
    private void modificarArticulo() {
        String tituloIn, autorIn, editorialIn, refBibliograficaIn;
        Integer codigoIn, añoPublicacion;
        pintaTitulo("MODIFICACIÓN");
        System.out.print("Por favor, introduzca el código del libro: ");
        codigoIn = s.nextInt();

        if (!existeCodigo(codigoIn)) {
            System.out.println("Lo siento, el código introducido no existe.");
        } else {
            int i = posicionConCodigo(codigoIn);
            Libro prov = libros.get(i);
            System.out.print("Introduzca los nuevos datos del libro");
            System.out.println(" o INTRO para dejarlos igual.");

            // NO DEJO TOCAR EL CODIGO
            System.out.println("Código: " + prov.getCodigo());

            System.out.println("Titulo: " + prov.getTitulo());
            System.out.print("Nuevo titulo: ");
            tituloIn = s.next();
            if (!tituloIn.equals("")) {
                prov.setTitulo(tituloIn);
            }

            System.out.println("Autor: " + prov.getAutor());
            System.out.print("Nuevo autor: ");
            autorIn = s.next();
            if (!autorIn.equals("")) {
                prov.setAutor(autorIn);
            }

            System.out.println("Editorial: " + prov.getEditorial());
            System.out.print("Nueva editorial: ");
            editorialIn = s.next();
            if (!editorialIn.equals("")) {
                prov.setEditorial(editorialIn);
            }

            System.out.println("Referencia bibliografica: " + prov.getRefBibliografica());
            System.out.print("Nueva referencia: ");
            refBibliograficaIn = s.next();
            if (!refBibliograficaIn.equals("")) {
                prov.setRefBibliografica(refBibliograficaIn);
            }

            System.out.println("Año publicacion: " + prov.getAñoPublicacion());
            System.out.print("Nueva referencia: ");
            añoPublicacion = s.nextInt();
            if (!añoPublicacion.equals("")) {
                prov.setAñoPublicacion(añoPublicacion);
            }

            libros.set(i, prov);
        }
        return;
    }

    // ENTRADA DE MERCANCÍA /////////////////////////////////////////////
    private void entradaLibros() {
        String tituloIn, autorIn, editorialIn, refBibliograficaIn;
        Integer codigoIn, añoPublicacion;

        pintaTitulo("ENTRADA DE LIBROS");
        System.out.print("Por favor, introduzca el código del libro: ");
        codigoIn = s.nextInt();

        if (!existeCodigo(codigoIn)) {
            System.out.println("Lo siento, el código introducido no existe.");
        } else {
            int i = posicionConCodigo(codigoIn);
            Libro prov = libros.get(i);

            System.out.println("Entrada de stock del siguiente libro: ");
            System.out.println(prov);
            System.out.print("Introduzca el número de unidades que entran: ");
            String stockIntroducidoString = s.next();
            prov.setStock(Integer.parseInt(stockIntroducidoString) + prov.getStock());// comprobar
            System.out.println("La mercancía ha entrado en el almacén.");
            System.out.println("nuevo stock: " + prov.getStock());

            libros.set(i, prov);
        }
        return;
    }

    // SALIDA DE MERCANCÍA ////////////////////////////////////////////
    private void salidaMercancia() {
        String tituloIn, autorIn, editorialIn, refBibliograficaIn;
        Integer codigoIn, añoPublicacion, stockIn;

        pintaTitulo("SALIDA DE MERCANCÍA");
        System.out.print("Por favor, introduzca el código del libro: ");
        codigoIn = s.nextInt();

        if (!existeCodigo(codigoIn)) {
            System.out.println("Lo siento, el código introducido no existe.");
        } else {
            int i = posicionConCodigo(codigoIn);
            Libro prov = libros.get(i);
            System.out.println("Salida de stock del libro: ");
            System.out.println(prov);
            System.out.print("Introduzca el número de unidades que desea sacar del almacén: ");
            stockIn = Integer.parseInt(s.next());
            if (prov.getStock() - stockIn > 0) {
                prov.setStock(prov.getStock() - stockIn);
                System.out.println("La mercancía ha salido del almacén.");
                System.out.println("nuevo stock: " + prov.getStock());

                libros.set(i, prov);
            } else {
                System.out.println("Lo siento, no se pueden sacar tantas unidades.");
            }
        }
        return;
    }

    private void modificarCodigo() {
        String tituloIn, autorIn, editorialIn, refBibliograficaIn;
        Integer codigoIn, añoPublicacion, stockIn, nuevoCodigo;
        pintaTitulo("MODIFICAR SOLO CODIGO de articulo!");
        System.out.print("Por favor, introduzca el código del artículo: ");
        codigoIn = s.nextInt();
        if (!existeCodigo(codigoIn)) {
            System.out.println("Lo siento, el código introducido no existe.");
        } else {
            System.out.print("Por favor, introduzca el código nuevo para el articulo:\n "
                    + libros.get(posicionConCodigo(codigoIn)));
            System.out.println();
            System.out.print("Codigo nuevo:");
            nuevoCodigo = s.nextInt();
            if (existeCodigo(nuevoCodigo)) {
                System.out.println("Lo siento, ese codigo ya existe en algun articulo");
                return;
            } else {
                libros.get(posicionConCodigo(codigoIn)).setCodigo(nuevoCodigo);
                System.out.println("Codigo nuevo establecido");
            }
        }

        return;
    }

    private void guardarLibros() {
        try {
            FileOutputStream fileOut = new FileOutputStream(NOMBRE_FICHERO);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            // escribimos objetos en el flujo de salida
            objectOut.writeObject(libros);

            objectOut.close();
            fileOut.close();
            System.out.println("libros guardados en archivo correctamente.");
        } catch (IOException kagada) {
            System.out.println("Error al guardar en archivo: " + kagada.getMessage());
        }
    }

    private void cargarLibros() {

        try {
            FileInputStream fileIn = new FileInputStream(NOMBRE_FICHERO);
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            libros = (ArrayList<Libro>) objectIn.readObject();

            objectIn.close();
            fileIn.close();
            System.out.println("libros cargados desde archivo correctamente.");
        } catch (IOException | ClassNotFoundException cagada) {
            System.out.println("Error al cargar desde archivo: " + cagada.getMessage());
        }
    }

    private boolean existeCodigo(int codigo) {
        for (Libro a : libros) {
            if (a.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    private void pintaTitulo(String titulo) {
        System.out.println("\n" + titulo);
        for (int i = 0; i < titulo.length(); i++) {
            System.out.print("=");
        }
        System.out.println();
    }

    private int posicionConCodigo(int codigo) {

        for (int i = 0; i < libros.size(); i++) {
            if (libros.get(i).getCodigo() == codigo) {
                return i;
            }
        }
        return -1;
    }

    private int peticionCodigo() {

        int codigoIn;
        System.out.println("Por favor, introduzca el codigo del artículo.");
        System.out.print("Código: ");
        do {
            codigoIn = s.nextInt();
            if (existeCodigo(codigoIn)) {
                System.out.println("Ese código ya existe en la base de datos.");
                System.out.print("Introduzca otro código: ");
            }
        } while (existeCodigo(codigoIn));
        return codigoIn;
    }

    private int generarCodigoLibro() {
        int codigoIn;
        Random rand = new Random();
        do {
            codigoIn = rand.nextInt(0, 1001);
        } while (existeCodigo(codigoIn));
        return codigoIn;
    }

    private static int getNumeroBibliotecasEnArchivos() {
        try {
            String currentDirectory = System.getProperty("user.dir");
            File folder = new File(currentDirectory);
            File[] files = folder.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.startsWith("biblioteca");
                }
            });
            return files.length;
        } catch (Exception e) {
            return 0;
        }

    }

    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    @Override
    public String toString() {
        return "Biblioteca " + nombreBiblioteca + "\n libros=[" + libros + "]";
    }

}
