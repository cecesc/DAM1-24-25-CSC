package ud5.mulleres;

abstract class MullerTraballadora {
    private String nome;
    private String apelidos;
    private int anoNacemento;

    public MullerTraballadora(String nome, String apelidos, int anoNacemento) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.anoNacemento = anoNacemento;
    }

    public abstract String descricionContribucion();

    public int getIdade(int anoActual) {
        return anoActual - anoNacemento;
    }

    public String getNomeCompleto() {
        return nome + " " + apelidos;
    }


    public static void main(String[] args) {
        Cientifica marieCurie = new Cientifica("Marie", "Curie", 1867, "Descubriu o radio e o polonio");
        Artista fridaKahlo = new Artista("Frida", "Kahlo", 1907, "Surrealismo e pintura autobiográfica");
        Politica rosaParks = new Politica("Rosa", "Parks", 1913, "Loita polos dereitos civís e contra a segregación racial");
        Cientifica adaLovelace = new Cientifica("Ada", "Lovelace", 1815, "Primeira programadora da historia");
        Escritora virginiaWoolf = new Escritora("Virginia", "Woolf", 1882, "Orlando e Un cuarto de seu");
        Deportista serenaWilliams = new Deportista("Serena", "Williams", 1981, "Ser a tenista con máis títulos de Grand Slam na era aberta");
        Sindicalista claraCampoamor = new Sindicalista("Clara", "Campoamor", 1888, "Conseguíu o sufragio feminino en España en 1931");

        
        MullerTraballadora[] mulleres = {marieCurie, fridaKahlo, rosaParks, adaLovelace, virginiaWoolf, serenaWilliams, claraCampoamor};

    
        System.out.println("=== Mulleres Traballadoras Destacadas ===");
        for (MullerTraballadora muller : mulleres) {
            System.out.println(muller.descricionContribucion());
        }

        System.out.println("\n=== Detalles Específicos ===");
        for (MullerTraballadora muller : mulleres) {
            if (muller instanceof IPioneira) {
                System.out.println(muller.getNomeCompleto() + " foi pioneira en: " + ((IPioneira) muller).getDescubrimentoOuAporte());
            }
            if (muller instanceof IActivista) {
                System.out.println(muller.getNomeCompleto() + " defendeu a causa: " + ((IActivista) muller).getCausaDefendida());
            }
        }
    }
}