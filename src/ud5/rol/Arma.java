package ud5.rol;

public class Arma extends Item {
    private int ataque;
    private boolean dosManos;

    public Arma(String nombre, double peso, int precio, int ataque, boolean dosManos) {
        super(nombre, peso, precio);
        this.ataque = ataque;
        this.dosManos = dosManos;
    }

    public int getAtaque() {
        return ataque;
    }

    public boolean isDosManos() {
        return dosManos;
    }
}
