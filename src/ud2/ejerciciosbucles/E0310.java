package ud2.ejerciciosbucles;

public class E0310 {
    public static void main(String[] args) {
        int suma = 0;

        for (int i = 1, contador = 0; contador < 10; i += 2, contador++) {
            suma += i;
        }

        System.out.println("La suma de los 10 primeros números impares es: " + suma);
    }
}