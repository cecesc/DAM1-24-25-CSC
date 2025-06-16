package recuperacion;
/*El fichero calificacion_alumnos.csv contiene las notas finales obtenidas por el alumnado del ciclo DAM en el siguiente formato:
Los datos se presentan en filas con la información separada por punto y coma (;)
La primera fila contiene las cabeceras de la información
Las siguientes filas representan la nota de un alumno/a en un módulo.

Elabora un programa que lea el fichero y muestre:
el nombre y la nota media de cada alumno/a ordenados descendentemente por media
el nombre y el número de suspensos de cada módulo ordenados ascendentemente por número de suspensos.
Genera un fichero de texto de salida de nombre "InformeDAM1.txt" que contengo un informe con el siguiente contenido:
 */
import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class NotasMediasDAM {

    public static void main(String[] args) {
        String inputFile = "calificacion_alumnos.csv";
        String outputFile = "InformeDAM1.txt";

        Map<String, List<Double>> notasAlumnos = new HashMap<>();
        Map<String, Integer> suspensosPorAlumno = new HashMap<>();
        Map<String, Integer> suspensosPorModulo = new HashMap<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(inputFile))) {
            String line = br.readLine(); // Leer cabecera y descartarla
            if (line == null) {
                System.out.println("Fichero vacío.");
                return;
            }

            while ((line = br.readLine()) != null) {
                String[] partes = line.split(";");
                if (partes.length != 3) continue;

                String alumno = partes[0].trim();
                String notaStr = partes[1].trim();
                String modulo = partes[2].trim();

                double nota;
                try {
                    nota = Double.parseDouble(notaStr);
                } catch (NumberFormatException e) {
                    continue;
                }

                // Añadir nota alumno
                notasAlumnos.computeIfAbsent(alumno, k -> new ArrayList<>()).add(nota);

                // Contar suspensos alumno
                if (nota < 5.0) {
                    suspensosPorAlumno.put(alumno, suspensosPorAlumno.getOrDefault(alumno, 0) + 1);
                    suspensosPorModulo.put(modulo, suspensosPorModulo.getOrDefault(modulo, 0) + 1);
                } else {
                    // Asegurar que aparecen con 0 suspensos si no existen aún
                    suspensosPorAlumno.putIfAbsent(alumno, suspensosPorAlumno.getOrDefault(alumno, 0));
                    suspensosPorModulo.putIfAbsent(modulo, suspensosPorModulo.getOrDefault(modulo, 0));
                }
            }

            // Calcular medias
            Map<String, Double> mediasAlumnos = new HashMap<>();
            for (Map.Entry<String, List<Double>> e : notasAlumnos.entrySet()) {
                double suma = 0;
                for (double n : e.getValue()) suma += n;
                mediasAlumnos.put(e.getKey(), suma / e.getValue().size());
            }

            // Ordenar alumnos desc por media
            List<Map.Entry<String, Double>> listaMediasOrdenada = mediasAlumnos.entrySet()
                    .stream()
                    .sorted((a, b) -> Double.compare(b.getValue(), a.getValue()))
                    .collect(Collectors.toList());

            // Ordenar módulos asc por suspensos
            List<Map.Entry<String, Integer>> listaModulosOrdenada = suspensosPorModulo.entrySet()
                    .stream()
                    .sorted(Comparator.comparingInt(Map.Entry::getValue))
                    .collect(Collectors.toList());

            // Mostrar por consola
            System.out.println("Alumnos y nota media (orden descendente):");
            for (var e : listaMediasOrdenada) {
                System.out.printf("%s: %.2f%n", e.getKey(), e.getValue());
            }
            System.out.println();

            System.out.println("Módulos y número de suspensos (orden ascendente):");
            for (var e : listaModulosOrdenada) {
                System.out.printf("%s: %d%n", e.getKey(), e.getValue());
            }

            // Contar alumnado según suspensos
            int todoAprobado = 0, uno = 0, dos = 0, tres = 0, masDeTres = 0;
            for (String alumno : notasAlumnos.keySet()) {
                int susp = suspensosPorAlumno.getOrDefault(alumno, 0);
                if (susp == 0) todoAprobado++;
                else if (susp == 1) uno++;
                else if (susp == 2) dos++;
                else if (susp == 3) tres++;
                else masDeTres++;
            }

            // Generar informe
            try (PrintWriter pw = new PrintWriter(Files.newBufferedWriter(Paths.get(outputFile)))) {
                pw.println("Informe Avaliación DAM1");
                pw.println("=======================");
                pw.println("Total Alumnado = " + notasAlumnos.size());
                pw.println();
                pw.println("Alumnado con…:");
                pw.println("- Todo aprobado: " + todoAprobado);
                pw.println("- 1 módulo suspenso: " + uno);
                pw.println("- 2 módulos suspensos: " + dos);
                pw.println("- 3 módulos suspensos: " + tres);
                pw.println("- Máis de 3 módulos suspensos: " + masDeTres);
                pw.println();
                pw.println("Listado de alumnos con nota media:");
                for (var e : listaMediasOrdenada) {
                    pw.printf("%s: %.2f%n", e.getKey(), e.getValue());
                }
                pw.println();
                pw.println("Listado de módulos con número de suspensos:");
                for (var e : listaModulosOrdenada) {
                    pw.printf("%s: %d%n", e.getKey(), e.getValue());
                }
            }
            System.out.println("\nInforme generado en " + outputFile);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
