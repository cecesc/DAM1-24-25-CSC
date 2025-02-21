package ud5.apuntesherencia.elemploabstract;

abstract class A {
    int x = 1;

    void metodo1(){
        System.out.println("metodo1 definido en A");
    }

    abstract void metodo2();

    public static void main(String[] args) {
        B b = new B();
        C c = new C();

        System.out.println("Valor de x en la clase B:" + b.x);

        b.metodo1();
        b.metodo2();
        
    }
    
}
