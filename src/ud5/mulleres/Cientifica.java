package ud5.mulleres;

public class Cientifica extends MullerTraballadora{
String descubrimiento;

public Cientifica (String nome, String
apelidos, int anoNacemento, String descubrimiento) {
        super(nome, apelidos, anoNacemento);
        this.descubrimiento = descubrimiento;
    }


@Override
    public String toString() {
        return nome + "  foi unha científica pioneira que descubriu: " + descubrimiento;
    }

}