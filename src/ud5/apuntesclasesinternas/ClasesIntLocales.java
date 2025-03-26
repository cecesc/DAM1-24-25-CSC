package ud5.apuntesclasesinternas;

// fichero ClasesIntLocales.java
// Este fichero demuestra cómo se crean clases locales
class A {
    int i = -1; // variable miembro
    // constructor

    public A(int i) {
        this.i = i;
    }

    // definición de un método de la clase A
    public void getAi(final long k) { // argumento final
        final double f = 3.14; // variable local final
        // definición de una clase interna local
        class BL {
            int j = 2;


            public BL(int j) {
                this.j = j;
            } // constructor


            public void printBL() {
                System.out.println(" j=" + j + " i=" + i + " f=" + f + " k=" + k);
            }
        } // fin clase BL
          // se crea un objeto de BL
        BL bl = new BL(2 * i);
        // se imprimen los datos de ese objeto
        bl.printBL();
    } // fin getAi
} // fin clase contenedora A


class ClasesIntLocales {
    public static void main(String[] arg) {
        // se crea dos objetos de la clase contenedora
        A a1 = new A(-10);
        A a2 = new A(-11);
        a1.getAi(1000); // se crea y accede a un objeto de la clase local
        a2.getAi(2000);
    } // fin de main()


    public static void println(String str) {
        System.out.println(str);
    }
} // fin clase ClasesIntLocales


