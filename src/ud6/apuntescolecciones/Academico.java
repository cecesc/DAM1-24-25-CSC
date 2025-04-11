package ud6.apuntescolecciones;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;;

public class Academico implements Comparable<Academico> {
    public static void main(String[] args) {
    

        
    Map<Character, Academico> academia = new TreeMap<>();

        String fichero = readFileToString("Academicos.txt");
        String [] lineas = fichero.split("\\n");
        for (int i = 0; i < lineas.length; i++) {
            Character letra = lineas[i].charAt(6);
            String nombre = lineas[i].substring(7,lineas[i].length()-6);
            int año =Integer.parseInt(lineas[i].substring(lineas[i].length()-5, lineas[i].length() -1));
            nuevoAcademico(academia, new Academico(nombre, año),letra);
        }
                
        
        
        
        
                System.out.println("ORDENADOS POR NOMBRE:");
                List<Academico> lista = new ArrayList<>(academia.values());
                Collections.sort(lista);
                for (Academico a : lista) {
                    System.out.println(a);
                }
               
        
               
        
                System.out.println("ORDENADOS POR AÑO DE INGRESO:");
                lista.sort(new Comparator<>(){
                   @Override
                    public int compare(Academico o1, Academico o2) {
                        int res = o1.añoIngreso.compareTo(o2.añoIngreso);
                        if(res==0)
                        res=o1.nombre.compareTo(o2.nombre)
                        return ;
                    }
                });
                
                for (Academico a : lista) {
                    System.out.println(a);
                }
        

        
                System.out.println("ORDENADOS POR LETRA DE SILLÓN:");
                Set<Character> letras = academia.entrySet();
                for (Character letra : letras)
                    System.out.println(" - " + e);
        
            }
        

                public static String readFileToString(String fichero) {
                    StringBuilder fileContent = new StringBuilder();
                    try {
                        // Creamos un objeto FileReader que nos permitirá leer el fichero
                        FileReader reader = new FileReader(fichero);
            
                        // Creamos un buffer para leer el fichero de forma más eficiente
                        BufferedReader buffer = new BufferedReader(reader);
            
                        // Leemos el fichero línea a línea
                        String line;
                        while ((line = buffer.readLine()) != null) {
                            // Vamos añadiendo cada línea al StringBuilder
                            fileContent.append(line);
                            // Añadimos un salto de línea al final de cada línea
                            fileContent.append("\n");
                        }
            
                        // Cerramos el buffer y el fichero
                        buffer.close();
                        reader.close();
                    } catch (IOException e) {
                        System.out.println("No existe el fichero.");
                        // e.printStackTrace();
                    }
            
                    // Devolvemos el contenido del fichero como un String
                    return fileContent.toString();
                }
            


    static boolean nuevoAcademico(Map<Character, Academico> academia, Academico nuevo, Character letra) {
        boolean result = true;
        if (Character.isLetter(letra)) {
            academia.put(letra, nuevo);
        } 

        return result;
    }

    @Override
    public int compareTo(Academico o) {
        return nombre.compareTo(o.nombre);
    }


    @Override
    public String toString() {
        return "Academico []";
    }

}