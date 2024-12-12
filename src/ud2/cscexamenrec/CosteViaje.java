package ud2.cscexamenrec;

public class CosteViaje {
    public static void main(String[] args) {
        double km = 100; 
        byte combustible = 2; 
        double consumoMedio = 15.0;

        double coste = costeViaje(km, combustible, consumoMedio);
        System.out.println("El coste del viaje es: " + coste + " euros.");
    }


    public static double costeViaje(double km, byte tipoCombustible, double consumoMedio) {
        final double PRECIO_LITRO_GASOLINA = 1.521;
        final double PRECIO_LITRO_DIESEL = 1.435;
        final double PRECIO_KWH = 0.16591;

        double costeTotal = 0.0;

        switch (tipoCombustible) {
            case 0: // Gasolina
                costeTotal = (km / 100.0) * consumoMedio * PRECIO_LITRO_GASOLINA;
                break;
            case 1: // Diesel
                costeTotal = (km / 100.0) * consumoMedio * PRECIO_LITRO_DIESEL;
                break;
            case 2: // Electricidad
                costeTotal = (km / 100.0) * consumoMedio * PRECIO_KWH;
                break;
            default:
                System.out.println("Tipo de combustible no válido.");
        }

        return costeTotal;
    }  
}
