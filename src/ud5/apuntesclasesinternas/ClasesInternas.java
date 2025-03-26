package ud5.apuntesclasesinternas;

// fichero ClasesInternas.java
// clase contenedora
class A {
    int i = 1; // variable miembro

    public A(int i) {
        this.i = i;
    } // constructor
    // los métoodos de la clase contenedora necesitan una
    // referencia a los objetos de la clase interna

    public void printA(B unB) {
        System.out.println("i=" + i + " unB.j=" + unB.j); // sí acepta unB.j
    }


    // la clase interna puede tener cualquier visibilidad. Con private da error
    // porque main() no puede acceder a la clase interna
    protected class B {
        int j = 2;

        public B(int j) {
            this.j = j;
        } // constructor


        public void printB() {
            System.out.println("i=" + i + " j=" + j); // sí sabe qué es j
        }
    } // fin clase B
} // fin clase contenedora A


class ClasesInternas {
    public static void main(String[] arg) {
        A a1 = new A(11);
        A a2 = new A(12);
        println("a1.i=" + a1.i + " a2.i=" + a2.i);
        // forma de crear objetos de la clase interna
        // asociados a un objeto de la clase contenedora
        A.B b1 = a1.new B(-10), b2 = a1.new B(-20);
        // referencia directa a los objetos b1 y b2 (sin cualificar).
        println("b1.j=" + b1.j + " b2.j=" + b2.j);
        // los métodos de la clase interna pueden acceder directamente a
        // las variables miembro del objeto de la clase contenedora
        b1.printB(); // escribe: i=11 j=-10
        b2.printB(); // escribe: i=11 j=-20
        // los métodos de la clase contenedora deben recibir referencias
        // a los objetos de la clase interna, pera que puedan identificarlos
        a1.printA(b1);
        a1.printA(b2);
        A a3 = new A(13);
        A.B b3 = a3.new B(-30);
        println("b3.j=" + b3.j);
        a3 = null; // se destruye la referencia al objeto de la clase contenedora
        b3.printB(); // escribe: i=13 j=-30
        a3 = new A(14); // se crea un nuevo objeto asociado a la referencia a3
        // b3 sigue asociado an anterior objeto de la clase contenedora
        b3.printB(); // escribe: i=13 j=-30
    } // fin de main()


    public static void println(String str) {
        System.out.println(str);
    }
} // fin clase ClasesInternas
