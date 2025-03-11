package ud5.rol;

public class Armadura extends Item {
    public enum Tipo { YELMO, ARMADURA, ESCUDO }

    private int defensa;
    private Tipo tipo;

    public Armadura(String nombre, double peso, int precio, Tipo tipo) {
        super(nombre, peso, precio);
        this.tipo = tipo;
    }

    public void setDefensa(int defensa) {
    this.defensa = defensa;
    }


    public int getDefensa() {
        return defensa;
    }

    public Tipo getTipo() {
        return tipo;
    }
}
