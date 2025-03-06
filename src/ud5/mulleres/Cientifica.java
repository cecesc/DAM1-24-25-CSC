package ud5.mulleres;

public class Cientifica extends MullerTraballadora implements IPioneira {
    private String descubrimento;

    public Cientifica(String nome, String apelidos, int anoNacemento, String descubrimento) {
        super(nome, apelidos, anoNacemento);
        this.descubrimento = descubrimento;
    }

    @Override
    public String descricionContribucion() {
        return getNomeCompleto() + " foi unha científica pioneira que descubriu: " + descubrimento;
    }

    @Override
    public String getDescubrimentoOuAporte() {
        return descubrimento;
    }
}