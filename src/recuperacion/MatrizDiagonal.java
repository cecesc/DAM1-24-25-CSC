package recuperacion;
/*Una matriz diagonal es una matriz cuadrada cuyos elementos fuera de la diagonal principal son todos cero. 
Ejemplo de una matriz de tamaño 3×3:

Crea una función que determine si una matriz dada es una matriz diagonal. La función devolverá true si la matriz de números enteros que se le pasa como parámetro es una matriz diagonal, y false en cualquier otro caso. Utiliza el siguiente prototipo para implementar la función:

boolean esDiagonal(int[][] t);

 */
public class MatrizDiagonal {

    

public static boolean esDiagonal(int[][] t) {
    if (t == null || t.length == 0) {
        return false;
    }
    int n = t.length;
    // Comprobar que es cuadrada
    for (int i = 0; i < n; i++) {
        if (t[i] == null || t[i].length != n) {
            return false;
        }
    }
    // Comprobar que fuera de la diagonal principal todo es 0
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (i != j && t[i][j] != 0) {
                return false;
            }
        }
    }
    return true;
}
}