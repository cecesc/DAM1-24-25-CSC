package ud7.limpieza;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

public class Util {
    public static List<Praia> cargarPlayas(String rutaFichero) {
        List<Praia> playas = new ArrayList<>();
        try (FileReader reader = new FileReader(rutaFichero)) {
            Gson gson = new Gson();
            Type tipoLista = new TypeToken<List<Praia>>(){}.getType();
            playas = gson.fromJson(reader, tipoLista);
            System.out.println("Playas cargadas: " + playas.size());
        } catch (Exception e) {
            System.out.println("Error cargando praias.json: " + e.getMessage());
        }
        return playas;
    }
}
