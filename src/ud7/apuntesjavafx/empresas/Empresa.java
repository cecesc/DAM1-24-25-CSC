package ud7.apuntesjavafx.empresas;

public class Empresa {
    private int id;
    private String nombre;
    private String web;


    public Empresa(int id, String nombre, String web) {
        this.id = id;
        this.nombre = nombre;
        this.web = web;
    }


    public Empresa(int id) {
        this.id = id;
    }


    @Override
    public String toString() {
//        return id + " - " + nombre + " (" + web + ")";
        return id + " - " + nombre;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((web == null) ? 0 : web.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Empresa other = (Empresa) obj;
        if (id != other.id)
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (web == null) {
            if (other.web != null)
                return false;
        } else if (!web.equals(other.web))
            return false;
        return true;
    }
    

    
}
