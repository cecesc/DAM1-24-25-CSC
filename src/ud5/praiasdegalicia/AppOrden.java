package ud5.praiasdegalicia;

public class AppOrden {
    public static void main(String[] args) {
        Praia[] praias = Util.importarPraias("praias.json");

        Praia[] praiasOrdenadasPorLatitud = Praia.sortLatitudNorteSur(praias);
        System.out.println("PRAIAS ORDENADAS POR LATITUD (de norte a sur)");
        System.out.println("=============================================");
        for (int i = 0; i < 10 && i < praiasOrdenadasPorLatitud.length; i++) {
            Praia praia = praiasOrdenadasPorLatitud[i];
            System.out.println((i + 1) + ". " + praia.getNome() + " (Norte) - " + praia.getLat() + " - " + praia.getConcello());
        }

        // 2. Todas las playas ordenadas por Provincia, Concello y Nombre
        Praia[] praiasOrdenadasPorProvincia = Praia.sortProvinciaConcelloNome(praias);
        System.out.println("\nPRAIAS ORDENADAS POR PROVINCIA, CONCELLO E NOME");
        System.out.println("=================================================");
        for (int i = 0; i < praiasOrdenadasPorProvincia.length; i++) {
            Praia praia = praiasOrdenadasPorProvincia[i];
            System.out.println((i + 1) + " - " + praia.getProvincia() + " - " + praia.getConcello() + " - " + praia.getNome());
        }
    }
}
