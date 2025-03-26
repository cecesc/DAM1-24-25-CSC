package ud5.apuntesclasesinternas;

class A {
    int i = 1; // variable miembro de objeto
    static int is = -1; // variable miembro de clase


    public A(int i) {
        this.i = i;
    } // constructor
      // a los métodos de la clase contenedora hay que pasarles referencias
      // a los objetos de la clase interna static


    public void printA(Bs unBs) {
        System.out.println("i=" + i + " unBs.j=" + unBs.j);
    }


    // definición de una clase interna static
    static class Bs {
        int j = 2;


        public Bs(int j) {
            this.j = j;
        } // constructor
          // los métodos de la clase interna static no pueden acceder a la i
          // pues es una variable de objeto. Sí pueden acceder a is


        public void printBs() {
            System.out.println(" j=" + j + " is=" + is);
        }
    } // fin clase Bs


    public static void main(String[] arg) {
        A a1 = new A(11), a2 = new A(12);
        System.out.println("a1.i=" + a1.i + " a2.i=" + a2.i);
        // dos formas de crear objetos de la clase interna static
        A.Bs b1 = new A.Bs(-10); // necesario poner A.Bs
        Bs b2 = new Bs(-11); // b2 es independiente de a1


        // referencia directa a los objetos b1 y b2
        System.out.println("b1.j=" + b1.j + " b2.j=" + b2.j);// los métodos de la clase interna acceden directamente a
                                                             // las
        // variables
        // de la clase contenedora sólo si son static
        b1.printBs(); // escribe: j=-10 is=-1
        b2.printBs(); // escribe: j=-20 is=-1
        // a los métodos de la clase contenedora hay que pasarles referencias
        // a los objetos de la clase interna, pera que puedan identificarlos
        a1.printA(b1); // escribe: i=11 unBs.j=-10
        a1.printA(b2); // escribe: i=11 unBs.j=-11
    } // fin de main()


} // fin clase contenedora Aclass ClasesIntStatic {
