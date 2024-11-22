package ud2.practicas;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class Radar {
    public static int excesoVelocidade(double distancia, int tiempo, int limite) {
        double mediaVelocidad = distancia * 3600 / tiempo;
        double excesoVelocidad = mediaVelocidad - limite;
        if (mediaVelocidad > limite) {
            System.out.println("Ha superado el límite de velocidad.");
            System.out.printf("Iba a %.2f en una vía limitada a %d km/h\n", mediaVelocidad, limite);
            return (int) excesoVelocidad;
        } else {
            System.out.println("Circula a una velocidad correcta por la vía.");
            return 0;
        }
    }

    public static int multaInfraccion(int limite, double excesoVelocidad) {
        if (limite <= 50) {
            if (excesoVelocidad <= 20) {
                return 100;
            } else if (excesoVelocidad > 20 && excesoVelocidad <= 30) {
                return 300;
            } else if (excesoVelocidad > 30 && excesoVelocidad <= 40) {
                return 400;
            } else if (excesoVelocidad > 40 && excesoVelocidad <= 50) {
                return 500;
            } else {
                return 600;
            }
        } else {
            if (excesoVelocidad <= 30) {
                return 100;
            } else if (excesoVelocidad > 30 & excesoVelocidad <= 50) {
                return 300;
            } else if (excesoVelocidad > 50 & excesoVelocidad <= 60) {
                return 400;
            } else if (excesoVelocidad > 60 & excesoVelocidad <= 70) {
                return 500;
            } else {
                return 600;
            }
        }

    }

    public static void main(String[] args) {
        final int KM_TRAMO_RADAR = 10;
        int LIMITE_VELOCIDAD_TRAMO = 120;

        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce el tiempo en segundos en recorrer " + KM_TRAMO_RADAR
                + "km a la velocidad límite de " + LIMITE_VELOCIDAD_TRAMO + "km/h: ");
        int segundos = sc.nextInt();
        sc.close();

        int excesoVelocidad = excesoVelocidade(KM_TRAMO_RADAR, segundos, LIMITE_VELOCIDAD_TRAMO);

        if (excesoVelocidad != 0) {
            System.out.println("Tiene una multa por exceso de velocidad de "
                    + multaInfraccion(LIMITE_VELOCIDAD_TRAMO, excesoVelocidad) + " euros.");

        }
    }

    @Test
    void testRadar() {
        assert excesoVelocidade(10, 600, 60) == 0;
        assert excesoVelocidade(10, 600, 50) == 10;
        assert excesoVelocidade(10, 600, 30) == 30;
        assert excesoVelocidade(15, 300, 120) == 60;
        assert excesoVelocidade(15, 300, 90) == 90;
        assert excesoVelocidade(10, 300, 120) == 0;
        assert excesoVelocidade(10, 300, 90) == 30;

        assert multaInfraccion(20, 15) == 100;
        assert multaInfraccion(30, 21) == 300;
        assert multaInfraccion(40, 31) == 400;
        assert multaInfraccion(50, 50) == 500;

        assert multaInfraccion(70, 30) == 100;
        assert multaInfraccion(80, 31) == 300;
        assert multaInfraccion(90, 51) == 400;
        assert multaInfraccion(100, 61) == 500;
        assert multaInfraccion(110, 71) == 600;
        assert multaInfraccion(120, 1) == 100;
    }

}