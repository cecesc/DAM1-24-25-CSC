package ud5.mulleres;

public class Deportista extends MullerTraballadora implements IPioneira {
    private String fitoHistorico;

    public Deportista(String nome, String apelidos, int anoNacemento, String fitoHistorico) {
        super(nome, apelidos, anoNacemento);
        this.fitoHistorico = fitoHistorico;
    }

    @Override
    public String descricionContribucion() {
        return getNomeCompleto() + " foi unha deportista pioneira cun fito histórico: " + fitoHistorico;
    }

    @Override
    public String getDescubrimentoOuAporte() {
        return fitoHistorico;
    }
}