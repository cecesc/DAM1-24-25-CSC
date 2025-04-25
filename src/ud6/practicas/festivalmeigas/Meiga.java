package ud6.practicas.festivalmeigas;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class Meiga implements Comparable<Meiga> {
    // ATRIBUTOS
    protected String nome;
    protected String alcume;
    protected Set<Feitizo> feitizos;
    protected String[] inventario;
    protected String[] meigas;

    // CONSTRUCTORES
    public Meiga(String nome, String alcume) {
        this.nome = nome;
        this.alcume = alcume;
        this.feitizos = new HashSet<>();
    }

    public Meiga(String nome, String alcume, Set<Feitizo> feitizos, String[] inventario) {
        this.nome = nome;
        this.alcume = alcume;
        this.feitizos = feitizos;
        this.inventario = inventario;
    }

    // GETERS Y SETTERS
    public String getNome() {
        return nome;
    }

    public String getAlcume() {
        return alcume;
    }

    public Set<Feitizo> getFeitizos() {
        return feitizos;
    }

    public boolean engadirFeitizoFavorito(Feitizo f) {
        return feitizos.add(f);
    }

    public boolean eliminarFeitizoFavorito(Feitizo f) {
        return feitizos.remove(f);
    }

    @Override
    public String toString() {
        return "Meiga [nome=" + nome + ", alcume=" + alcume + "]";
    }

    @Override
    public int compareTo(Meiga outra) {
        return this.nome.compareTo(outra.nome);
    }

    public static Meiga[] crearMeigasExemplo(Feitizo[] feitizosDisponibles) {
        Random rnd = new Random();

        String[] nomes = { "Uxía", "Lúa", "Iria", "Noa" };
        String[] alcumes = { "A das Fraguiñas", "Sombra do Vento", "Luz do Bosque", "Meiga da Brétema" };

        Meiga[] meigas = new Meiga[nomes.length];

        // Obtén todos os feitozos de exemplo e todos os seus ingredientes únicos
        Collection<Feitizo> feitizosExemplo = List.of(Feitizo.crearFeitizosExemplo());
        Collection<String> ingredientesExemplo = Feitizo.ingredientesUnicos(feitizosExemplo);

        for (int i = 0; i < nomes.length; i++) {
            String nome = nomes[i];
            String alcume = alcumes[i];
            // Xera unha colección cunha selección aleatoria de feitizos de exemplo para
            // asignar á meiga
            Collection<Feitizo> feitizos = getFeitizosRnd(feitizosExemplo);
            // Xera un mapa cunha selección aleatoria de ingredientes e cantidades de cada
            // un de exemplo para asignar á meiga
            Map<String, Integer> inventario = getIngredientesRnd(ingredientesExemplo, 3);

            // Crea a meiga e a engade ao array
            meigas[i] = new Meiga(nome, alcume, feitizos, inventario);
        }

        return meigas;

    }

    private static Collection<Feitizo> getFeitizosRnd(Collection<Feitizo> feitizosExemplo) {
        Random rnd= new Random();
       return feitizosExemplo.contains(rnd);

    }

    private static Map<String, Integer> getIngredientesRnd(Collection<String> ingredientesExemplo, int i) {
        throw new UnsupportedOperationException("Unimplemented method 'getIngredientesRnd'");
    }

    public static  lanzarFeitizo(Feitizo){

        return null;
    }
}
