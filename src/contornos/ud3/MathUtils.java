package contornos.ud3;

public class MathUtils { 
    public static int factorial(int n) { 
        if (n < 0) { 
            throw new IllegalArgumentException("O número debe ser positivo"); 
        } 
        int resultado = 1; 
        //for (int i = 1; i <= n; i--) {  
        for (int i = 1; i <= n; i++) {  
            resultado *= i; 
        } 
        return resultado; 
    } 
} 

// Corregir: i++

