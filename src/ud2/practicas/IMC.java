package ud2.practicas;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

public class IMC {
    public static double imc(double kg, int cm){
        double imc= kg/(Math.pow(cm, 2));
        if (imc < 18.50) {
        System.out.println("Usted esta en bajo peso");
       }
       if (imc == 18.50 && imc >=24.99) {
        System.out.println("Usted esta en un peso normal");
       }
       if (imc >= 25.00) {
        System.out.println("Usted tiene sobrepeso");
       }
       if (imc >= 30) {
        System.out.println("Usted tiene obesidad");
       }
       return imc;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduzca la altura (en cm) (el número debe ser entre 50 y 250): ");
        int cm = sc.nextInt();
        System.out.print("Introduzca la peso (en kg) (el número debe ser entre 20 y 300): ");
        double kg = sc.nextDouble();
        
   
        System.out.println(imc(kg, cm));
     
        
        
    }
    @Test
    void testImc() {
        // Definir casos de prueba y sus resultados esperados

        // Caso 1: Peso 70 kg, Altura 170 cm
        double resultadoCaso1 = imc(70, 170);
        assertEquals(24.22, resultadoCaso1, 0.01);

        // Caso 2: Peso 90 kg, Altura 185 cm
        double resultadoCaso2 = imc(90, 185);
        assertEquals(26.30, resultadoCaso2, 0.01);

        // Caso 3: Peso 60 kg, Altura 160 cm
        double resultadoCaso3 = imc(60, 160);
        assertEquals(23.44, resultadoCaso3, 0.01);

        double resultadoCaso4 = imc(45, 160);
        assertEquals(17.578, resultadoCaso4, 0.01);

        double resultadoCaso5 = imc(65, 165);
        assertEquals(23.875, resultadoCaso5, 0.01);

        double resultadoCaso6 = imc(100, 175);
        assertEquals(32.653, resultadoCaso6, 0.01);

        double resultadoCaso7 = imc(99.98, 200);
        assertEquals(24.995, resultadoCaso7, 0.01);
    }


}
