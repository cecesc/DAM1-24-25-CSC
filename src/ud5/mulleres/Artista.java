package ud5.mulleres;

public class Artista extends MullerTraballadora{
String estilo;

public Artista (String nome, String
apelidos, int anoNacemento, String estilo) {
        super(nome, apelidos, anoNacemento);
        this.estilo = estilo;
    }


}