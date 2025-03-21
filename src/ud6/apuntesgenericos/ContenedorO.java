package ud6.apuntesgenericos;

public class ContenedorO {
private Object objecto;
public ContenedorO(){}

void guardar(Object nuevo){
objecto=nuevo;
}
Object extraer(){
    Object res = objecto;
    objecto= null;
    return res;
}
public static void main(String[] args) {
    
}
}
