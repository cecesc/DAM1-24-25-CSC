package ud6.apuntesgenericos;

import ud3.apuntes.Persona;

class ContenedorG<T> {
private T objeto;
public ContenedorG(){}
void guardar(T nuevo){
    objeto=nuevo;
}

T extraer(){
    T res = objeto;
    objeto = null;
    return res;
}

    public static void main(String[] args) {
    ContenedorG<Integer> c = new ContenedorG<>();
    c.guardar(5);
    Integer n=c.extraer();
    System.out.println(n);
    ContenedorG<Double> c1 = new ContenedorG<>();
    ContenedorG<Persona> c2 = new ContenedorG<>();
    c2.guardar(new Persona());


}
}
