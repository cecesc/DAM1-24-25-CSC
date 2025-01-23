package ud4.apuntes.apuntesarrays;

public class ValidarDNI {
    public static boolean esValidoDNI(int numero, char letra){
        char[] letras = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};

        return letras[numero % 23] == letra;
    }

    public static void main(String[] args) {
        System.out.println(esValidoDNI(53613577,'R'));
    }
}
