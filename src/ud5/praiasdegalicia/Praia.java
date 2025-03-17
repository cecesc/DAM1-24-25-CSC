package ud5.praiasdegalicia;

import java.util.Arrays;


public class Praia implements Comparable{
    private int id;
    private String nome;
    private String concello;
    private String provincia;
    private double lat;
    private double lon;

    public Praia() {
    }

    public Praia(int id) {
        this.id = id;
    }

    public Praia(int id, String nome, String concello, String provincia) {
        this.id = id;
        this.nome = nome;
        this.concello = concello;
        this.provincia = provincia;
    }

    public Praia(int id, String nome, String concello, String provincia, double lat, double lon) {
        this.id = id;
        this.nome = nome;
        this.concello = concello;
        this.provincia = provincia;
        this.lat = lat;
        this.lon = lon;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getConcello() {
        return concello;
    }

    public void setConcello(String concello) {
        this.concello = concello;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return id+ " - " + nome + " - " + concello + " - " + provincia + " - ("
                + lat + ", " + lon + ")";
    }

    @Override
    public int compareTo(Object o) {
        if (o instanceof Praia) {
            Praia other = (Praia) o; 
            return Integer.compare(this.id, other.id);
        }
        throw new ClassCastException("El objeto no es una Praia");
    }
    

    public void mostrarDetalles() {
        System.out.println( toString());
    }

    public static void imprimirLista(Praia[] praias) {
        for (Praia praia : praias) {
            System.out.println(praia);
        }
    }
    
    public static Praia[] sortLatitudNorteSur(Praia[] p) {
        Praia[] sorted = Arrays.copyOf(p, p.length);
        Arrays.sort(sorted, (a, b) -> Double.compare(b.lat, a.lat)); // Ordenar de norte a sur
        return sorted;
    }

    public static Praia[] sortProvinciaConcelloNome(Praia[] p) {
        Praia[] sorted = Arrays.copyOf(p, p.length);
        Arrays.sort(sorted, (a, b) -> {
            int cmp = a.provincia.compareTo(b.provincia);
            if (cmp != 0) return cmp;
            cmp = a.concello.compareTo(b.concello);
            if (cmp != 0) return cmp;
            return a.nome.compareTo(b.nome);
        });
        return sorted;
    }

    
}
