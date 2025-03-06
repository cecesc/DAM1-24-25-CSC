package ud5.herenciaejercicios;

    import java.math.BigDecimal;

    public class EP0829 {
    
        public static void main(String[] args) {
            BigDecimal dos = new BigDecimal("2");
    
            // Queremos 100 cifras significativas => 100 decimales después de la coma
            BigDecimal raiz2 = calcularRaizCuadrada(dos, 100);
    
            System.out.println("Raíz cuadrada de 2 con 100 cifras significativas:");
            System.out.println(raiz2);
        }
    
        public static BigDecimal calcularRaizCuadrada(BigDecimal numero, int cifrasDecimales) {
            BigDecimal precision = BigDecimal.ONE.movePointLeft(cifrasDecimales + 5); // Un extra de margen
            BigDecimal x = BigDecimal.valueOf(1); // Inicialización de x (puede ser 1 o el propio número/2)
            BigDecimal dos = new BigDecimal("2");
    
            // Método de Newton-Raphson
            BigDecimal error;
            do {
                BigDecimal xAnterior = x;
                x = x.add(numero.divide(x, cifrasDecimales + 5, BigDecimal.ROUND_HALF_UP)).divide(dos, cifrasDecimales + 5, BigDecimal.ROUND_HALF_UP);
                error = x.subtract(xAnterior).abs();
            } while (error.compareTo(precision) > 0);
    
            // Redondear a exactamente 100 decimales
            return x.setScale(cifrasDecimales, BigDecimal.ROUND_HALF_UP);
        }
    }

