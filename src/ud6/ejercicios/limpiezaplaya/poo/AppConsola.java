package ud6.ejercicios.limpiezaplaya.poo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import ud6.ejercicios.limpiezaplaya.UtilFicheros;

public class AppConsola {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Praia> praias = Util.cargarPraias(); // Carga de praias.json
        List<LimpezaPraia> limpiezas = UtilFicheros.leerFichero("limpiezas.dat");

        if (limpiezas == null) limpiezas = new ArrayList<>();

        boolean salir = false;
        while (!salir) {
            System.out.println("\n--- MENU LIMPIEZA DE PLAYAS ---");
            System.out.println("1. Añadir limpieza");
            System.out.println("2. Listado por equipo");
            System.out.println("3. Listado por playa");
            System.out.println("4. Últimas 10 limpiezas");
            System.out.println("5. Top 10 playas por kilos");
            System.out.println("6. Top 10 equipos por nº limpiezas");
            System.out.println("7. Top 10 equipos por kilos");
            System.out.println("0. Salir");
            System.out.print("Elige una opción: ");
            String opcion = sc.nextLine();

            switch (opcion) {
                case "1":
                    añadirLimpieza(sc, limpiezas, praias);
                    break;
                case "2":
                    listadoPorEquipo(sc, limpiezas);
                    break;
                case "3":
                    listadoPorPlaya(sc, limpiezas);
                    break;
                case "4":
                    ultimasLimpiezas(limpiezas);
                    break;
                case "5":
                    topPlayasPorKilos(limpiezas);
                    break;
                case "6":
                    topEquiposPorCantidad(limpiezas);
                    break;
                case "7":
                    topEquiposPorKilos(limpiezas);
                    break;
                case "0":
                    UtilFicheros.escribirFichero("limpiezas.dat", limpiezas);
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }

        System.out.println("Aplicación finalizada.");
    }

    // === FUNCIONES ===

    static void añadirLimpieza(Scanner sc, List<LimpezaPraia> limpiezas, List<Praia> praias) {
        try {
            System.out.print("Fecha (yyyy-mm-dd): ");
            LocalDate fecha = LocalDate.parse(sc.nextLine());

            System.out.print("Nombre del equipo: ");
            String equipo = sc.nextLine();

            System.out.print("Nombre de la playa: ");
            String nombrePlaya = sc.nextLine();
            Optional<Praia> playaOpt = praias.stream()
                    .filter(p -> p.getNome().equalsIgnoreCase(nombrePlaya))
                    .findFirst();

            if (playaOpt.isEmpty()) {
                System.out.println("Playa no encontrada.");
                return;
            }

            System.out.print("Kilos recogidos: ");
            double kilos = Double.parseDouble(sc.nextLine());

            limpiezas.add(new LimpezaPraia(fecha, equipo, playaOpt.get(), kilos));
            System.out.println("Limpieza añadida correctamente.");

        } catch (Exception e) {
            System.out.println("Error en la entrada. Limpieza no añadida.");
        }
    }

    static void listadoPorEquipo(Scanner sc, List<LimpezaPraia> limpiezas) {
        System.out.print("Nombre del equipo: ");
        String equipo = sc.nextLine();

        limpiezas.stream()
                .filter(l -> l.getNomeEquipo().equalsIgnoreCase(equipo))
                .sorted(Comparator.comparing(LimpezaPraia::getData))
                .forEach(System.out::println);
    }

    static void listadoPorPlaya(Scanner sc, List<LimpezaPraia> limpiezas) {
        System.out.print("Nombre de la playa: ");
        String playa = sc.nextLine();

        limpiezas.stream()
                .filter(l -> l.getPraia().getNome().equalsIgnoreCase(playa))
                .sorted(Comparator.comparing(LimpezaPraia::getData).reversed())
                .forEach(System.out::println);
    }

    static void ultimasLimpiezas(List<LimpezaPraia> limpiezas) {
        limpiezas.stream()
                .sorted(Comparator.comparing(LimpezaPraia::getData).reversed())
                .limit(10)
                .forEach(System.out::println);
    }

    static void topPlayasPorKilos(List<LimpezaPraia> limpiezas) {
    Map<String, Double> acumulado = new HashMap<>();

    for (LimpezaPraia l : limpiezas) {
        String nombre = l.getPraia().getNome();
        double kilos = acumulado.getOrDefault(nombre, 0.0);
        acumulado.put(nombre, kilos + l.getKilos());
    }

    List<Map.Entry<String, Double>> lista = new ArrayList<>(acumulado.entrySet());
    lista.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

    for (int i = 0; i < Math.min(10, lista.size()); i++) {
        Map.Entry<String, Double> entry = lista.get(i);
        System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue() + " kg");
    }
}


 static void topEquiposPorCantidad(List<LimpezaPraia> limpiezas) {
    Map<String, Integer> conteo = new HashMap<>();

    for (LimpezaPraia l : limpiezas) {
        String equipo = l.getNomeEquipo();
        conteo.put(equipo, conteo.getOrDefault(equipo, 0) + 1);
    }

    List<Map.Entry<String, Integer>> lista = new ArrayList<>(conteo.entrySet());
    lista.sort((a, b) -> Integer.compare(b.getValue(), a.getValue()));

    for (int i = 0; i < Math.min(10, lista.size()); i++) {
        Map.Entry<String, Integer> entry = lista.get(i);
        System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue() + " limpiezas");
    }
    
}
static void topEquiposPorKilos(List<LimpezaPraia> limpiezas) {
    Map<String, Double> kilosPorEquipo = new HashMap<>();

    for (LimpezaPraia l : limpiezas) {
        String equipo = l.getNomeEquipo();
        kilosPorEquipo.put(equipo, kilosPorEquipo.getOrDefault(equipo, 0.0) + l.getKilos());
    }

    List<Map.Entry<String, Double>> lista = new ArrayList<>(kilosPorEquipo.entrySet());
    lista.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

    for (int i = 0; i < Math.min(10, lista.size()); i++) {
        Map.Entry<String, Double> entry = lista.get(i);
        System.out.println((i + 1) + ". " + entry.getKey() + ": " + entry.getValue() + " kg");
    }
}
}

