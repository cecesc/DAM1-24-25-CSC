package ud5.herenciaejercicios.EP0812Y13;

public class Caja {
    int ancho;
    int alto;
    int fondo;
    String etiqueta;
    public enum Unidad {cm , m}
    public Unidad unidad;
    final int MAX_ETIQUETA=30;
    public static double volumen=0;



    public Caja(int ancho, int alto, int fondo, Unidad unidad) {
        this.ancho = ancho;
        this.alto = alto;
        this.fondo = fondo;
        this.unidad = unidad;
    }

    public double getVolumen(){
         volumen = ancho*alto*fondo;
        return volumen;
    }

    public void setEtiqueta(String etiqueta){
        
    }

    @Override
    public String toString() {
        return "Caja [ancho=" + ancho + ", alto=" + alto + ", fondo=" + fondo + "]";
    }


   
}
