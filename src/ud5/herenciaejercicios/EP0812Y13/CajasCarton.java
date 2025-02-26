package ud5.herenciaejercicios.EP0812Y13;

public class CajasCarton extends Caja {

  

    public CajasCarton(int ancho, int alto, int fondo, Unidad unidad) {
            super(ancho, alto, fondo, unidad);
            
        }
    
        public static void main(String[] args) {
        Caja caja= new Caja(5, 5, 5, Unidad.m);
        System.out.println(caja);
        caja.getVolumen();
        System.out.printf("El volumen de la caja para los repartidores: %.2f %s" + caja.getVolumen() *0.80, Unidad.m);
    }

}

