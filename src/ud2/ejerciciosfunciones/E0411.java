/* Escribir una función que calcule de forma recursiva el máximo común divisor de dos números. Para ello sabemos: 
mcd(a,b) =
mcd(a - b, b) si a >= b
mcd(a, b - a) si b > a
a si b = 0
b si a = 0
*/

package ud2.ejerciciosfunciones;

public class E0411 {

    public static int mcd(int a, int b) {
        int mcd = 0;
        if (a == 0)
            mcd = b;
        else if (b == 0)
            mcd = a;
        else if (a >= b)
            mcd = mcd(a - b, b);
        else
            mcd = mcd(a, b - a);

        return mcd;
    }

    public static void main(String[] args) {
        System.out.println(mcd(12, 30));
        System.out.println(mcd(4, 8));
        System.out.println(mcd(0, 30));
        System.out.println(mcd(12, 0));
    }
}
