/* Diseñar una función que calcule a n , donde a es real y n es entero no negativo.
Realizar una versión iterativa y otra recursiva.*/
package ud2.ejerciciosfunciones;

public class E0410 {

    //versión iterativa
    public static double potenciaIterativa(double a, int n) {
        double resultado = 1.0;
        for (int i = 0; i < n; i++) {
            resultado *= a;
        }
           return resultado;
    }

        //versión recursiva
     public static double potenciaRecursiva(double a, int n) {
        if (n == 0) {
            return 1.0;
        } else {
            return a * potenciaRecursiva(a, n - 1);
        }
    }
    
    public static void main(String[] args) {
        double a = 2.0;
        int n = 3;
        
        //versión iterativa
        double resultadoIterativo = potenciaIterativa(a, n);
        System.out.println(a + "^" + n + " = " + resultadoIterativo);
            
        

        //versión recursiva      
        double resultadoRecursivo = potenciaRecursiva(a, n);
        System.out.println(a + "^" + n + " = " + resultadoRecursivo);
           
        
    }
}
