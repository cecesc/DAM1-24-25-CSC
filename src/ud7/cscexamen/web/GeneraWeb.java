//Autor: Celia Sanmartín Chapela
package ud7.cscexamen.web;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class GeneraWeb {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String PATH = "src/ud7/";

        System.out.println("Introduzca el nombre que desea ponerle al fichero: ");
        String nombreFichero = sc.nextLine();
        System.out.println("Introduzca el titulo: ");
        String titulo = sc.nextLine();
        System.out.println("Introduzca la descripción: ");
        String descripcion = sc.nextLine();
        System.out.println("Introduzca el texto del enlace: ");
        String textEnlace = sc.nextLine();
        System.out.println("Introduzca la url: ");
        String url = sc.nextLine();
        sc.close();

        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(PATH + nombreFichero + ".txt"))) {

            escritor.write("<html>");
            escritor.newLine();
            escritor.write("<head>");
            escritor.newLine();
            escritor.write("<title> " + titulo + " </title>");
            escritor.newLine();
            escritor.write("<meta charset='utf-8'>");
            escritor.newLine();
            escritor.write("</head>");
            escritor.newLine();
            escritor.newLine();
            escritor.write("<body>");
            escritor.newLine();
            escritor.write("<h1> " + titulo + " </h1>");
            escritor.newLine();
            escritor.newLine();
            escritor.write("<p> " + descripcion + ". <br>");
            escritor.newLine();
            escritor.write("<a href='" + url + " '> " + textEnlace + " </a>");
            escritor.newLine();
            escritor.write("</p>");
            escritor.newLine();
            escritor.newLine();
            escritor.write("</body>");
            escritor.newLine();
            escritor.write("</html>");

        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.getMessage());
        }
    }
}
