package ud5.herenciaejercicios.EP0825A7;

public class Punto {
    int x, y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    double distancia(Punto otroPunto) {
        if (otroPunto == null)
            return -1;
        else
            return Math.sqrt(Math.pow(x - otroPunto.x, 2)
                    + (Math.pow(y - otroPunto.y, 2)));

    }
}