package contornos.ud3;

public class MathUtils { 
    public static int factorial(int n) { 
        if (n < 0) { 
            throw new IllegalArgumentException("O número debe ser positivo"); 
        } 
        int resultado = 1; 
        //for (int i = 1; i <= n; i--) {  MAL
        for (int i = 1; i <= n; i++) {  
            resultado *= i; 
        } 
        return resultado; 
    } 
} 

/*
           ((1))--------
            (2)        |
        |--((3))<-     |
        |   (4)--'     |
        '-->(5)        |
            (6)<-------'
 

         V(G) = 3
Camiños independentes:
1, 6
1, 2, 3, 5, 6 (no entrar en el bucle)
1, 2, 3, 4, 3, 5, 6 (entrar una vez en el bucle)

Casos de proba:
n = -1    Salida esperada: Excepción
n = 0     Salida esperada: 1
n = 1     Salida esperada: 1 = 1!  (pero.. bucle infinito!! >> ERRO)   
 */