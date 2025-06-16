package recuperacion.inmobiliaria;


import java.util.*;

public class Inmobiliaria {
    public static void main(String[] args) {
        Inmueble piso1 = new Piso("Calle Curtidoira", 100, 3, 2, 5);
        piso1.setPrecioAlquiler(500);
        piso1.setPrecioVenta(200000);

        Inmueble piso2 = new Piso("Praza Maior", 80, 2, 2, 3);
        piso2.setPrecioAlquiler(400);
        Inmueble piso3 = new Piso("Calle Rosalía de Castro", 140, 4, 2, 2);
        piso3.setPrecioVenta(250000);

        Inmueble casa1 = new Casa("Carretera de Marín", 250, 4, 3, 3000);
        casa1.setPrecioAlquiler(800);
        casa1.setPrecioVenta(350000);

        Inmueble casa2 = new Casa("Lapaman", 150, 3, 2, 1000);
        casa2.setPrecioVenta(400000);

        System.out.println(piso1);
        System.out.println(casa1);
        System.out.println();

        System.out.println(piso1.detalle());
        System.out.println();
        System.out.println(piso2.detalle());
        System.out.println();
        System.out.println(casa2.detalle());

        List<Inmueble> lista = new ArrayList<>();
        lista.add(piso1);
        lista.add(piso2);
        lista.add(piso3);
        lista.add(casa1);
        lista.add(casa2);

        System.out.println("\nOrdenados por dirección (natural):");
        Collections.sort(lista);
        for (Inmueble i : lista) {
            System.out.println(i.direccion);
        }

        System.out.println("\nOrdenados por nº habitaciones y m2 (descendente):");
        lista.sort(Comparator.comparingInt(Inmueble::getHabitaciones).reversed()
            .thenComparing(Comparator.comparingInt(Inmueble::getMetros).reversed()));
        for (Inmueble i : lista) {
            System.out.println(i.direccion + " - " + i.getHabitaciones() + " hab, " + i.getMetros() + " m2");
        }
    }
}