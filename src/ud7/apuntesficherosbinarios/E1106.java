/*E1106. Recuperar la estrofa del archivo cancionPirata.dat de la actividad E1102 y
mostrar la por consola. */

package ud7.apuntesficherosbinarios;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;

public class E1106 implements Serializable {
    static final String PATH = "src/ud7/apuntesficherosbinarios/";

    public static void main(String[] args) {
        // Lee las estrofas de un fichero binario
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream(PATH + "cancionPirata.dat"))) {
            String[] t = null;
            t = (String[]) in.readObject();

            System.out.println(Arrays.toString(t));
        } catch (EOFException ex) {
            System.out.println("Leyendo... Excepción fin de fichero");
        } catch (FileNotFoundException ex) {
            System.out.println("Leyendo... Error No se encuentra el fichero");
        } catch (IOException ex) {
            System.out.println("Leyendo... Error Entrada/Salida");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
