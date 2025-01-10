import java.util.Scanner;

public class EP0515 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] notas = new int[5][3]; // 5 alumnos, 3 trimestres
        double[] medias = new double[3];

        for (int i = 0; i < 5; i++) {
            System.out.println("Introduce las notas del alumno " + (i + 1) + ":");
            for (int j = 0; j <  3; j++) {
                System.out.print("Trimestre " + (j + 1) + ": ");
                notas[i][j] = scanner.nextInt();
                medias[j] += notas[i][j];
            }
        }

        for (int j = 0; j < 3; j++) {
            medias[j] /= 5; // Calcular la media
            System.out.println("Media del trimestre " + (j + 1) + ": " + medias[j]);
        }

        System.out.print("Introduce la posición del alumno para calcular su media: ");
        int posicion = scanner.nextInt() - 1; // Ajustar a índice 0
        if (posicion >= 0 && posicion < 5) {
            double mediaAlumno = (notas[posicion][0] + notas[posicion][1] + notas[posicion][2]) / 3.0;
            System.out.println("Media del alumno en la posición " + (posicion + 1) + ": " + mediaAlumno);
        } else {
            System.out.println("Posición inválida.");
        }
    }
}