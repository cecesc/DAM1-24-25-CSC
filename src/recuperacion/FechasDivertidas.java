package recuperacion;
/*Escribir la fecha del último día del año 2023 no genera ningún tipo de hecho curioso: 31−12−23 no deja de ser una fecha más.

Pero si se escribe con el formato habitual en los países anglosajones, donde escriben primero el mes, luego el día y finalmente el año, la situación cambia: 12−31−23. Ahora ¡aparece el 123 dos veces seguidas! Es verdad que su forma de escribir las fechas no tiene ningún sentido, porque está desordenada… la "unidad" más pequeña, los días, va en medio, por delante tiene los meses, que es la "unidad" intermedia, y detrás los años, la "unidad" más grande. Pero ¡oye! En este caso este formato da un poco de gracia a una fecha que de otro modo sería insulsa.

Crea un método fechaDivertida() que reciba una cadena con una fecha en formato dd-mm-aa y devuelva:
true si si hay una forma de ordenar los tres números de modo que formen dos bloques de 3 dígitos iguales
false en otro caso.
 */
public class FechasDivertidas {
    public static void main(String[] args) {
        String[] entradas = {
                "31-12-23", // true → 123123
                "01-02-03", // false
                "90-09-99", // Exception: Fecha no válida
                "29-02-20", // true (año bisiesto simplificado)
                "31-04-23", // Exception: Fecha no válida (abril tiene 30 días)
                "a2-02-22", // Exception: formato incorrecto
                "32-01-25", // Exception: día inválido
                "12-13-25", // Exception: mes inválido
                null, // Exception: null
                "" // Exception: vacía
        };

        for (String entrada : entradas) {
            try {
                boolean resultado = FechasDivertidas.fechaDivertida(entrada);
                System.out.println("Entrada: " + entrada + " → " + resultado);
            } catch (IllegalArgumentException e) {
                System.out.println("Entrada: " + entrada + " → Exception: " + e.getMessage());
            }
        }
    }

    public static boolean fechaDivertida(String fecha) {
        if (fecha == null || fecha.isEmpty()) {
            throw new IllegalArgumentException("Fecha no válida");
        }

        String[] partes = fecha.trim().split("-");
        if (partes.length != 3) {
            throw new IllegalArgumentException("Fecha no válida");
        }

        int dia, mes, anio;

        try {
            dia = Integer.parseInt(partes[0]);
            mes = Integer.parseInt(partes[1]);
            anio = Integer.parseInt(partes[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Fecha no válida");
        }

        if (!esFechaValida(dia, mes, anio)) {
            throw new IllegalArgumentException("Fecha no válida");
        }

        // Generamos las 6 permutaciones posibles de los 3 componentes
        String d = String.format("%02d", dia);
        String m = String.format("%02d", mes);
        String a = String.format("%02d", anio);

        String[] combinaciones = {
                m + d + a,
                m + a + d,
                d + m + a,
                d + a + m,
                a + m + d,
                a + d + m
        };

        for (String comb : combinaciones) {
            if (comb.length() == 6 && comb.substring(0, 3).equals(comb.substring(3))) {
                return true;
            }
        }

        return false;
    }

    private static boolean esFechaValida(int d, int m, int a) {
        if (m < 1 || m > 12 || d < 1 || a < 0 || a > 99)
            return false;

        int[] diasMes = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

        if (m == 2 && a % 4 == 0) {
            diasMes[1] = 29; // Año bisiesto simplificado (no comprobamos siglos porque son solo dos cifras)
        }

        return d <= diasMes[m - 1];
    }
}
