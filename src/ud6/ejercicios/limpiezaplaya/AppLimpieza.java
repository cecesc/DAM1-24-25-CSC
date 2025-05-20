package ud6.ejercicios.limpiezaplaya;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.time.LocalDate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class AppLimpieza {

    private static final String FICH_PRAIAS = "praias.json";
    private static final String FICH_LIMPIEZAS = "limpiezas.dat";
    private static List<Playa> playa = new ArrayList<>();
    private static List<Limpieza> limpiezas = new ArrayList<>();

    public static void main(String[] args) {
        cargarPraias();
        cargarLimpiezas();

        // Ejemplo: registrar limpieza
        registrarLimpieza(LocalDate.now(), "Equipo Verde", "Praia das Catedrais", 50);
        registrarLimpieza(LocalDate.now(), "Equipo Azul", "Praia de Riazor", 30);
        registrarLimpieza(LocalDate.of(2024,5,1), "Equipo Verde", "Praia de Riazor", 40);
        registrarLimpieza(LocalDate.of(2024,4,25), "Equipo Vermello", "Praia de Samil", 20);
        registrarLimpieza(LocalDate.of(2024,4,30), "Equipo Azul", "Praia de Samil", 70);

        // Muestra ejemplos
        listarPorEquipo("Equipo Verde");
        listarPorPraia("Praia de Riazor");
        ultimasLimpiezas();
        praiasMaisContaminadas();
        equiposMaisActivos();
        equiposMaisEficientes();

        guardarLimpiezas();
    }

    private static void cargarPraias() {
        try {
            String json = Files.readString(Paths.get(FICH_PRAIAS));
            playa = new Gson().fromJson(json, new TypeToken<List<Playa>>(){}.getType());
        } catch (Exception e) {
            System.out.println("Erro cargando praias: " + e.getMessage());
        }
    }

    private static void cargarLimpiezas() {
        File f = new File(FICH_LIMPIEZAS);
        if (f.exists()) {
            List<Limpieza> cargadas = UtilFicheros.lerFicheiro(FICH_LIMPIEZAS);
            if (cargadas != null) limpiezas = cargadas;
        }
    }

    private static void guardarLimpiezas() {
        UtilFicheros.escribirFichero(FICH_LIMPIEZAS, limpiezas);
    }

    private static void registrarLimpieza(LocalDate data, String equipo, String praia, int kilos) {
        limpiezas.add(new Limpieza(data, equipo, praia, kilos));
    }

    private static void listarPorEquipo(String equipo) {
        System.out.println("\nLimpiezas del equipo " + equipo);
        limpiezas.stream()
                .filter(l -> l.getEquipo().equalsIgnoreCase(equipo))
                .sorted(Comparator.comparing(Limpieza::getData))
                .forEach(System.out::println);
    }

    private static void listarPorPraia(String praia) {
        System.out.println("\nLimpiezas en la praia " + praia);
        limpiezas.stream()
                .filter(l -> l.getPraia().equalsIgnoreCase(praia))
                .sorted(Comparator.comparing(Limpieza::getData).reversed())
                .forEach(System.out::println);
    }

    private static void ultimasLimpiezas() {
        System.out.println("\nÚltimas 10 limpiezas:");
        limpiezas.stream()
                .sorted(Comparator.comparing(Limpieza::getData).reversed())
                .limit(10)
                .forEach(System.out::println);
    }

    private static void praiasMaisContaminadas() {
        System.out.println("\n10 praias con máis kilos recollidos:");
        limpiezas.stream()
                .collect(Collectors.groupingBy(Limpieza::getPraia, Collectors.summingInt(Limpieza::getKilos)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + "kg"));
    }

    private static void equiposMaisActivos() {
        System.out.println("\n10 equipos con máis limpiezas:");
        limpiezas.stream()
                .collect(Collectors.groupingBy(Limpieza::getEquipo, Collectors.counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + " limpiezas"));
    }

    private static void equiposMaisEficientes() {
        System.out.println("\n10 equipos con máis kilos recollidos:");
        limpiezas.stream()
                .collect(Collectors.groupingBy(Limpieza::getEquipo, Collectors.summingInt(Limpieza::getKilos)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .limit(10)
                .forEach(e -> System.out.println(e.getKey() + ": " + e.getValue() + "kg"));
    }
    
}
