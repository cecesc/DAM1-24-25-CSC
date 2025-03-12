package ud5.apuntesinterfaz;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class Socio implements Comparable {
    int id;
    String nombre;
    LocalDate fechaAlta;

    public Socio(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Socio(int id, String nombre, LocalDate fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.fechaAlta = fechaAlta;
    }
    
    @Override 
    public String toString(){
        return id+" "+nombre+ " "+ fechaAlta;
    }
    public static void main(String[] args) {
    Socio s2 = new Socio(2, "Lucas", 10-12-2020)

    ComparaSociosFecha ordenFecha = new ComparaSociosFecha();
    Arrays.sort(socios, ordenFecha);
    System.out.println(Arrays.toString(socios));
    Arrays.sort(socios, ordenFecha.reversed());
    System.out.println(Arrays.toString(socios));

    Arrays.sort(socios, getCompNombre());
    System.out.println(Arrays.toString(socios));

    private static Comparator getCompNombre(){
        return new Comparator<T>() {
            @Override
            public int compare (Object o1, Object o2){
                return ((Socio)o1).id - ((Socio)o2).id;
            }
        };
    }
    }
        @Override 
        public boolean equals (Object o){
            if (o == null || getClass() != o.getClass())
            return false;
            Socio socio = (Socio) o;
            return id == socio.id && Objects.equals(nombre, socio.nombre) && Objects.equals(fechaAlta, socio.fechaAlta, socio);
        }


    @Override 
    public int compareTo(Object o) {  
        Socio socio =(Socio) o ;      
        int res = fechaAlta.compareTo(((Socio) o).fechaAlta); 
        if (res == 0){ 
            res = this.nombre.compareTo(socio.nombre);
            if (res == 0){
                res = this.id - socio.id; 
            }
        } 
        return res; 
    } 



    @Override 
    public int compareTo(Object o) {        
        return id - ((Socio) o).id;  
    } 
}
