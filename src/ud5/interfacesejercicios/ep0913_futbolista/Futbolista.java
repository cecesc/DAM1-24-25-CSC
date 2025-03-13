/* Diseñar la clase Futbolista con los siguientes atributos: dni, 
nombre, edad y número de goles. Implementar: 
 
●  Un constructor y los métodos toString() y equals() (este último basado en el 
DNI).  
●  La interfaz Comparable con un criterio de ordenación basado también en el DNI. 
●  Un comparador para hacer ordenaciones basadas en el nombre y otro basado en la 
edad. 
 
Crear una tabla con 5 futbolistas y mostrarlos ordenados por DNI, por nombre y por edad. 
 
Añade un comparador que ordene los futbolistas por edades y, para aquellos que tienen la 
misma edad, por nombres.  */

package ud5.interfacesejercicios.ep0913_futbolista;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import ud5.apuntesinterfaces.Socio;

public class Futbolista implements Comparable {
    String dni;
    String nombre;
    int edad;
    int numGoles;

    public Futbolista(String dni, String nombre, int edad, int numGoles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.numGoles = numGoles;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    @Override
    public String toString() {
        return "El futbolista " + nombre + " con dni: " + dni + " y la edad de " + edad + " años, ha conseguido meter "
                + numGoles + " goles";
    }

    @Override
    public int compareTo(Object o) {
        Futbolista futb =(Futbolista) o;
        int resultado= dni.compareTo(futb.dni);
        return resultado;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Futbolista otro = (Futbolista) obj;
        return dni.equals(otro.dni);
    }

    

    public static Comparator getCompNombre() {
        return new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                return ((Futbolista) a).nombre.compareTo(((Futbolista) b).nombre);
            }
        };
    }

    public static Comparator getCompEdad() {
        return new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                return ((Futbolista) a).edad - ((Futbolista) b).edad;
            }
        };
    }

    public static Comparator getCompEdadNombre() {
        return new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                Futbolista f1 = (Futbolista) a;
                Futbolista f2 = (Futbolista) b;
                int res = f1.edad - f2.edad;
                return (res != 0) ? res : f1.nombre.compareTo(f2.nombre);
            }
        };
    }

    public static void main(String[] args) {
        List futbolistas = new ArrayList();
        futbolistas.add(new Futbolista("23574799T", "Pepe", 20, 68));
        futbolistas.add(new Futbolista("97198799T", "Juan", 28, 10));
        futbolistas.add(new Futbolista("13574531T", "Federico", 40, 20));
        futbolistas.add(new Futbolista("27613579T", "Alfredo", 30, 19));
        futbolistas.add(new Futbolista("23568799T", "IDK", 42, 9));

        System.out.println("Ordenados por DNI:");
        Collections.sort(futbolistas);
        for (Object f : futbolistas) System.out.println(f);

        System.out.println("\nOrdenados por Nombre:");
        Collections.sort(futbolistas, getCompNombre());
        for (Object f : futbolistas) System.out.println(f);

        System.out.println("\nOrdenados por Edad:");
        Collections.sort(futbolistas, getCompEdad());
        for (Object f : futbolistas) System.out.println(f);

        System.out.println("\nOrdenados por Edad y Nombre:");
        Collections.sort(futbolistas, getCompEdadNombre());
        for (Object f : futbolistas) System.out.println(f);
    }
}
