package ud6.ejercicios.examentest;

import java.util.Arrays;

public class App1Examen {
    public static void main(String[] args) {
        System.out.println("EXÁMENES TIPO TEST");
        System.out.println("==================");

        Examen examen = new Examen("EXAMEN TEST - POO básica en Java: Clases y Objetos");

        examen.addPregunta(new Pregunta(
                "Dos clases se consideran vecinas siempre y cuando:",
                Arrays.asList("Sean visibles.", "Ambas dispongan del mismo número de constructores.",
                        "Pertenezcan al mismo paquete.",
                        "Todo lo anterior ha de cumplirse para que dos clases sean vecinas."),
                2));

        examen.addPregunta(new Pregunta(
                "La ocultación de atributos puede definirse como:",
                Arrays.asList("El proceso en el que un atributo pasa de ser público a privado.",
                        "El proceso en el que se define una variable local (en un método) con el mismo identificador que un atributo.",
                        "El proceso en el que un atributo estático deja de serlo.",
                        "Todas las respuestas anteriores son correctas."),
                1));

        examen.addPregunta(new Pregunta(
                "Un miembro cuyo modificador de acceso es private será visible desde:",
                Arrays.asList("Todas las clases vecinas.", "Todas las clases externas.",
                        "Es indistinto el paquete, pero será visible siempre que se importe la clase que lo contiene.",
                        "Ninguna de las respuestas anteriores."),
                3));

        examen.addPregunta(new Pregunta(
                "Si desde un constructor queremos invocar a otro constructor de la misma clase, tendremos que usar:",
                Arrays.asList("set().", "get().", "this().", "this."),
                2));

        System.out.println(examen);
    }
}
