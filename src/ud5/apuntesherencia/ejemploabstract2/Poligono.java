package ud5.apuntesherencia.ejemploabstract2;

public abstract class Poligono {
private int numLados;


public Poligono(){

}
public Poligono(int numLados){
this.numLados= numLados;
}

public int getNumLados(){
    return numLados;
}

public void setNumLados(int numLados){
    this.numLados=numLados;
}

//Declaracion del método  abstracto area()
public abstract double area();
public static void main(String[] args) {
    Triangulo t = new Triangulo();
    System.out.printf("Area del triangulo %.2f %n" , t.area());
    Rectangulo r = new Rectangulo();
    System.out.printf("Area del rectangulo %.2f %n" , r.area());

    Poligono[] poligonos={t,r};
    for (Poligono poligono : poligonos) {
        System.out.println(poligono.area());
        
    }
    Triangulo t2=(Triangulo) poligonos[1];

}
}
