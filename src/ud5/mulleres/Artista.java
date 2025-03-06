package ud5.mulleres;

public class Artista extends MullerTraballadora {
    private String estilo;

    public Artista(String nome, String apelidos, int anoNacemento, String estilo) {
        super(nome, apelidos, anoNacemento);
        this.estilo = estilo;
    }

    @Override
    public String descricionContribucion() {
        return getNomeCompleto() + " destacou na arte co estilo: " + estilo;
    }
}
