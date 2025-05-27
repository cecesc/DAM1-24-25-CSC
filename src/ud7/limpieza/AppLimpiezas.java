package ud7.limpieza;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class AppLimpiezas {
    static List<Limpieza> listaLimpiezas = new ArrayList<>();
    static List<Praia> listaPlayas = new ArrayList<>();

    public static void main(String[] args) {
        // Cargar playas desde JSON
        listaPlayas = Util.cargarPlayas("praias.json");

        // Cargar limpiezas desde fichero binario
        listaLimpiezas = UtilFicheros.<Limpieza>leerFichero("limpiezas.dat");

        Scanner sc = new Scanner(System.in);
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(sc.nextLine());
            switch (opcion) {
                case 1 -> registrarLimpieza(sc);
                case 2 -> listarPorEquipo(sc);
                case 3 -> listarPorPlaya(sc);
                case 4 -> listarUltimas10();
                case 5 -> playasMasSucias();
                case 6 -> equiposConMasLimpiezas();
                case 7 -> equiposConMasKilos();
                case 0 -> guardarYSalir();
            }
        } while (opcion != 0);
    }

    private static void mostrarMenu() {
        System.out.println("""
            1. Añadir limpieza
            2. Listado por equipo
            3. Listado por playa
            4. Últimas 10 limpiezas
            5. 10 playas con más kilos recogidos
            6. 10 equipos con más limpiezas
            7. 10 equipos con más kilos
            0. Salir
        """);
    }

    private static void registrarLimpieza(Scanner sc) {
        System.out.print("Fecha (YYYY-MM-DD): ");
        LocalDate fecha = LocalDate.parse(sc.nextLine());
        System.out.print("Nombre del equipo: ");
        String equipo = sc.nextLine();
        System.out.print("Nombre de la playa: ");
        String playa = sc.nextLine();
        System.out.print("Kilos recogidos: ");
        double kilos = Double.parseDouble(sc.nextLine());

        Limpieza limpieza = new Limpieza(fecha, equipo, playa, kilos);
        listaLimpiezas.add(limpieza);
        System.out.println("✅ Limpieza registrada.");
    }

    private static void listarPorEquipo(Scanner sc) {
        System.out.print("Nombre del equipo: ");
        String equipo = sc.nextLine();
        listaLimpiezas.stream()
            .filter(l -> l.getEquipo().equalsIgnoreCase(equipo))
            .sorted(Comparator.comparing(Limpieza::getFecha))
            .forEach(System.out::println);
    }

    private static void listarPorPlaya(Scanner sc) {
        System.out.print("Nombre de la playa: ");
        String playa = sc.nextLine();
        listaLimpiezas.stream()
            .filter(l -> l.getPlaya().equalsIgnoreCase(playa))
            .sorted(Comparator.comparing(Limpieza::getFecha).reversed())
            .forEach(System.out::println);
    }

    private static void listarUltimas10() {
        listaLimpiezas.stream()
            .sorted(Comparator.comparing(Limpieza::getFecha).reversed())
            .limit(10)
            .forEach(System.out::println);
    }

    private static void playasMasSucias() {
        listaLimpiezas.stream()
            .collect(Collectors.groupingBy(Limpieza::getPlaya, Collectors.summingDouble(Limpieza::getKilos)))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(10)
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " kg"));
    }

    private static void equiposConMasLimpiezas() {
        listaLimpiezas.stream()
            .collect(Collectors.groupingBy(Limpieza::getEquipo, Collectors.counting()))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
            .limit(10)
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " limpiezas"));
    }

    private static void equiposConMasKilos() {
        listaLimpiezas.stream()
            .collect(Collectors.groupingBy(Limpieza::getEquipo, Collectors.summingDouble(Limpieza::getKilos)))
            .entrySet().stream()
            .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
            .limit(10)
            .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " kg"));
    }

    private static void guardarYSalir() {
        UtilFicheros.<Limpieza>escribirFichero("limpiezas.dat", listaLimpiezas);
        System.out.println("Datos guardados. Hasta pronto.");
    }
}
