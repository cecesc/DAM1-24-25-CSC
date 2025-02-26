package ud5.herenciaejercicios.EP0825A7;

public class Punto3D extends Punto {
    int z;

    public Punto3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }


    double distancia(Punto3D otroPunto){
       
       if (otroPunto == null) {
        return -1;
       }else 
        return Math.sqrt(Math.pow(x-otroPunto.x,2)+(Math.pow(y-otroPunto.y,2))+(Math.pow(z-otroPunto.z,2)));
    }




    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Punto3D other = (Punto3D) obj;
        if (z != other.z)
            return false;
        return true;
    }

}
