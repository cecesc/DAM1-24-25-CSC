package ud4.apuntes;

public class EjemplosOrdenar {
    public static void burbuja(int[] A) {
        int i, j, aux;
        for (i=0;i< A.length -1 ; i++){
            for(j=0; j < A.length -i -1; j++){
                if (A[j+1] < A[j]) {
                    aux = A[j+1];
                    A[j+1] = A[j];
                    A[j] = aux;
                }
            }
        }
    }

    public static void main(String[] args) {
       
            int[] t = { 1, 4, 3, 8, 5, 6 };
            burbuja(t);
            System.out.print("Array desordenado: " + java.util.Arrays.toString(t));
        
    }
}
