//Autor: Celia Sanmartín Chapela

package ud3.cscexamen;

public class JuegoCarreras01 {
    public static void main(String[] args) {
        CocheCarreras Tormenta = new CocheCarreras("Rayo", 90, 400);
        Tormenta.mostrar();
        CocheCarreras Flash = new CocheCarreras("Rayo", 100, 400);
        Flash.mostrar();
        System.out.println("-----------------------");
        //System.out.println( " Tormenta avanza " + CocheCarreras.getDistanciaRecorrida + " metros ( Total recorrido: " + CocheCarreras.distanciaTotal + "metros )");
        //System.out.println( " Flash avanza " + distanciaRecorrida + " metros ( Total recorrido: " + distanciaTotal + "metros )");
        System.out.println( "");
    
    }
}
