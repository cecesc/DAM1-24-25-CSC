package ud5.mulleres;

public class Politica extends MullerTraballadora{
    String causa;

    public Politica (String nome, String
apelidos, int anoNacemento, String causa) {
        super(nome, apelidos, anoNacemento);
        this.causa = causa;
    }
}