package ud2;

import java.util.Scanner;

public class Util {

    //Función es Par o Impar
    public static boolean esPar(int n) {
        return n % 2 == 0;
    }

    //Función es Bisiesto o No
    public static boolean esBisiesto(int anho) {
        return anho % 400 == 0 || (anho % 4 == 0 && anho % 100 != 0);
    }

    // Función si el Número es cero o no 
    public static boolean esCasiCero(double n) {
        return n > -1 && n < 0 || n > 0 && n < 1;
    }

    // Función que número es mayor
    public static int mayor(int a, int b) {
        return a > b ? a : b;
    }

    //Función para imprimir un Triángulo Rectángulo
    public static void imprimirTrianguloRectangulo(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        } 
    }

    //Función para imprimir un Triángulo Rectángulo Inverso
    public static void imprimirTrianguloRectanguloInverso(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i; j++) {
                System.out.print("* ");
            }
            System.out.println("");
        } 
    }

    //Función para dar las notas en texto (si la nota no lleva decimales) 
    public static String notaEnTexto(int nota) {
        String notaEnTexto = "";
        switch (nota) {
            case 0, 1, 2, 3, 4:
                notaEnTexto = "insuficiente";
                break;
            case 5:
                notaEnTexto = "suficiente";
                break;
            case 6:
                notaEnTexto = "bien";
                break;
            case 7, 8:
                notaEnTexto = "notable";
                break;
            case 9, 10:
                notaEnTexto = "sobresaliente";
                break;
        }
        return notaEnTexto;
    }

    //Función para dar las notas en texto (si la nota lleva decimales) 
    public static String notaEnTexto(double nota) {
        String notaEnTexto = "";
        if (nota >= 0 && nota < 5) {
            notaEnTexto = "insuficiente";
        } else if (nota >= 5 && nota < 6) {
            notaEnTexto = "suficiente";
        } else if (nota >= 6 && nota < 7) {
            notaEnTexto = "bien";
        } else if (nota >= 7 && nota < 9) {
            notaEnTexto = "notable";
        } else if (nota >= 9 && nota <= 10) {
            notaEnTexto = "sobresaliente";
        }
        return notaEnTexto;
    }

    //Función para imprimir un texto con un caracter a cada lado
    public static void cajaTexto(String str, String caracter) {
        int n = str.length(); // longitud del String

        imprimirlinea(n, caracter);
        System.out.println(caracter + " " + str + " " + caracter); // cadena con un borde en cada lado
        imprimirlinea(n, caracter);
    }

    //Función para imprimir un texto con un caracter por encima y por debajo del texto (Va con la de función de arriba)
    public static void imprimirlinea(int n, String caracter) {
        for (int i = 1; i <= n + 4; i++) { // borde de arriba
            System.out.print(caracter);
        }
        System.out.println();
    }

    public static String numCifras (int numero){
        String cifra = "";
        if (numero >= 0 && numero <= 9) {
            System.out.println("El número tiene 1 cifra.");
        } else if (numero <= 99) {
            System.out.println("El número tiene 2 cifras.");
        } else if (numero <= 999) {
            System.out.println("El número tiene 3 cifras.");
        } else if (numero <= 9999) {
            System.out.println("El número tiene 4 cifras.");
        } else {
            System.out.println("El número tiene 5 cifras.");
        }
        return cifra;
    }

    //Función que reciba un número comprendido entre 1 y 7, correspondiente a un día de la semana y que devuelva el día en texto.
    public static String diaSemana(int numero){
        String dia = "";
        switch (numero) {
            case 1:
                System.out.println("El numero" + numero +"equivale al Lunes");
                break;
                case 2:
                System.out.println("El numero " + numero +" equivale al Martes");
                break;    
                case 3:
                System.out.println("El numero" + numero +"equivale al Miércoles");
                break;
                case 4:
                System.out.println("El numero" + numero +"equivale al Jueves");
                break;
                case 5:
                System.out.println("El numero" + numero +"equivale al Viernes");
                break;
                case 6:
                System.out.println("El numero" + numero +"equivale al Sábado");
                break;
                case 7:
                System.out.println("El numero" + numero +"equivale al Domingo");
                break;
        }
        return dia;
    }
    
    public static void main(String[] args) {
            imprimirTrianguloRectangulo(6);
    
            imprimirTrianguloRectanguloInverso(8);
    
            double notaDouble = 6.7;
            System.out.println(notaEnTexto((int) notaDouble));
            int notaInt = 8;
            System.out.println(notaEnTexto(notaInt));
    
            Scanner sc = new Scanner(System.in);
            System.out.print("Número / Anho: ");
            int n = sc.nextInt();
            sc.close();
    
            if (esPar(n))
                System.out.println("Es Par");
            else
                System.out.println("Es Impar");
    
            if (esBisiesto(n))
                System.out.println("Es Bisiesto");
            else
                System.out.println("NO es bisiesto");
    
            System.out.println(mayor(4, 17));
            System.out.println(mayor(8, 1));
    }
}
