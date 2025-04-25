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
 */

package ud6.practicas.festivalmeigas;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Festival {

     // Meigas que comparten un ingrediente nun feitizo favorito
    public static Map<String, Set<Meiga>> meigasPorIngrediente(Collection<Meiga> meigas) {
        Map<String, Set<Meiga>> mapa = new HashMap<>();
        for (Meiga meiga : meigas) {
            for (Feitizo f : meiga.getFeitizos()) {
                for (String ingrediente : f.getIngredientes()) {
                    mapa.putIfAbsent(ingrediente, new HashSet<>());
                    mapa.get(ingrediente).add(meiga);
                }
            }
        }
        return mapa;
    }

    // Recomendar un feitizo novo que use un ingrediente dado
    public static Map<Meiga, List<Feitizo>> recomendarFeitizosPorIngrediente(Collection<Meiga> meigas, Collection<Feitizo> feitizos, String ingrediente) {
        Map<Meiga, List<Feitizo>> recomendacion = new HashMap<>();
        for (Meiga meiga : meigas) {
            List<Feitizo> candidatos = new ArrayList<>();
            for (Feitizo f : feitizos) {
                if (f.getIngredientes().contains(ingrediente) && !meiga.getFeitizos().contains(f)) {
                    candidatos.add(f);
                }
            }
            if (!candidatos.isEmpty()) {
                recomendacion.put(meiga, candidatos);
            }
        }
        return recomendacion;
    }

    // Feitizos que comparten ingredientes
    public static Map<String, List<Feitizo>> feitizosPorIngrediente(Collection<Feitizo> feitizos) {
        Map<String, List<Feitizo>> mapa = new HashMap<>();
        for (Feitizo f : feitizos) {
            for (String ingrediente : f.getIngredientes()) {
                mapa.putIfAbsent(ingrediente, new ArrayList<>());
                mapa.get(ingrediente).add(f);
            }
        }
        return mapa;
    }

    // Recomendar feitizos segundo ingredientes favoritos
    public static List<Feitizo> recomendarPorPreferencias(Meiga meiga, Collection<Feitizo> todosFeitizos) {
        Set<String> ingredientesFavoritos = new HashSet<>();
        for (Feitizo f : meiga.getFeitizos()) {
            ingredientesFavoritos.addAll(f.getIngredientes());
        }

        List<Feitizo> recomendados = new ArrayList<>();
        for (Feitizo f : todosFeitizos) {
            if (!meiga.getFeitizos().contains(f)) {
                for (String ing : f.getIngredientes()) {
                    if (ingredientesFavoritos.contains(ing)) {
                        recomendados.add(f);
                        break;
                    }
                }
            }
        }
        return recomendados;
    }

    // Ingrediente máis usado
    public static String ingredienteMaisUsado(Collection<Feitizo> feitizos) {
        Map<String, Integer> conta = Feitizo.ingredientesVecesUsados(feitizos);
        String maxIng = null;
        int max = 0;
        for (Map.Entry<String, Integer> entry : conta.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                maxIng = entry.getKey();
            }
        }
        return maxIng;
    }
}

