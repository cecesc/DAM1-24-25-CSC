/*Festival das Meigas
A vila imaxinaria de San Comadro, en pleno corazón da Galiza máxica, celebra cada ano o
seu tradicional Festival das Meigas, onde se organizan concursos de feitizos, se
intercambian ingredientes máxicos e se premia ás meigas máis creativas.

Funcionalidades obrigatorias:
1. Rexistro de Meigas:
Cada meiga ten un nome, un alcume máxico, e unha lista de feitizos favoritos.
Os feitizos non se poderán repetir. As meigas poderanse amosar ordenadas por
diferentes criterios.
2. Base de datos de Feitizos:
Cada feitizo ten un nome, unha lista de ingredientes, e un nivel de dificultade.
a. A partir de todos os feitizos rexistrados queremos obter unha colección de
todos os ingredientes únicos empregados no festival.
b. Xera un listado dos feitizos que se poden facer cunha lista de ingredientes
dados.
c. Permite listar os 3 ingredientes máis usados en total (pista: podes usar un
Map<String, Integer> para contar).
3. Funcionalidades extra:
a. Xerar unha lista de meigas que comparten un mesmo ingrediente nun dos
seus feitizos favoritos.
b. Implementa un sistema de recomendación: dado un ingrediente, suxerir ás
meigas un novo feitizo que o use e que non teñan nos seus favoritos.

Esto esto es el prototipo que no puede cambiarse:
package ud6.practicas.festivalmeigas;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Feitizo {

    // Atributos
    private String nomeFeitizo;
    List<String> ingredientes;
    private Integer dificultade;

    // Constructores
    public Feitizo(String nomeFeitizo, String[] ingredientes, Integer dificultade) {
        this.nomeFeitizo = nomeFeitizo;
        this.ingredientes = List.of(ingredientes);
        this.dificultade = dificultade;
    }

    // Otros métodos
    public static void main(String[] args) {
        Feitizo[] feitizos = crearFeitizosExemplo();
        System.out.println(ingredientesUnicos(List.of(feitizos)));
    }

    public static Feitizo[] crearFeitizosExemplo() {
        String[] ingredientes1 = { "auga de río encantada", "pétalos de rosa silvestre", "fume de lareira" };
        String[] ingredientes2 = { "auga do mar", "salicornia", "berberechos místicos" };
        String[] ingredientes3 = { "raíz de toxo", "auga bendita", "po de estrela fugaz" };
        String[] ingredientes4 = { "auga de río encantada", "raíz de toxo", "pel de serpe" };
        String[] ingredientes5 = { "auga do mar", "po de estrela fugaz", "cinza de bidueiro" };
        String[] ingredientes6 = { "auga bendita", "pétalos de rosa silvestre", "brétema das fragas" };

        Feitizo f1 = new Feitizo("Encantamento da Chuvia Mansa", ingredientes1, 3);
        Feitizo f2 = new Feitizo("Invocación Mariña", ingredientes2, 4);
        Feitizo f3 = new Feitizo("Luz do Luar", ingredientes3, 2);
        Feitizo f4 = new Feitizo("Garda da Fraga", ingredientes4, 3);
        Feitizo f5 = new Feitizo("Respiro Oceánico", ingredientes5, 4);
        Feitizo f6 = new Feitizo("Bendición Floral", ingredientes6, 2);

        return new Feitizo[] { f1, f2, f3, f4, f5, f6 };
    }

    public static Collection<String> ingredientesUnicos(Collection<Feitizo> feitizos) {
        Set<String> ingredientesUnicos = new TreeSet<>();
        for (Feitizo feitizo : feitizos) {
          for (String i : feitizo.ingredientes) {
            ingredientesUnicos.add(i);
          }  
        }
        return ingredientesUnicos;
    }

    public static List<Feitizo> feitizosPosibles(Set<String> ingredientes) {
        return null;
    }

    public static Map<String, Integer> ingredientesVecesUsados(Collection<Feitizo> feitizos) {
        return null;
    }
}


    */

package ud6.practicas.festivalmeigas;

public class Festival {
    public static void main(String[] args) {
        
    }package ud6.practicas.festivalmeigas;

import java.util.*;

public class FestivalDasMeigasUtils {

    // a. Meigas que comparten un ingrediente nos seus feitizos favoritos
    public static Map<String, Set<Meiga>> meigasPorIngredienteFavorito(Collection<Meiga> meigas) {
        Map<String, Set<Meiga>> mapa = new HashMap<>();

        for (Meiga meiga : meigas) {
            for (Feitizo feitizo : meiga.getFeitizosFavoritos()) {
                for (String ingrediente : feitizo.ingredientes) {
                    mapa.putIfAbsent(ingrediente, new HashSet<>());
                    mapa.get(ingrediente).add(meiga);
                }
            }
        }

        return mapa;
    }
}

}
