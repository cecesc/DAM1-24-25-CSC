package ud5.praiasdegalicia;

public class AppOrden {
    public static void main(String[] args) {
        Praia[] praias = Util.importarPraias("praias.json");

        Praia[] praiasNorte = Praia.sortLatitudNorteSur(praias);
        System.out.println("Las 10 playas más al norte:");
        Praia.imprimirLista(praiasNorte, 10);
        System.out.println();

        Praia[] praiasOrdenadas = Praia.sortProvinciaConcelloNome(praias);
        System.out.println("\nTodas las playas ordenadas por Provincia, Concello y Nombre:");
        Praia.imprimirLista(praiasOrdenadas, praiasOrdenadas.length);
    }
}
