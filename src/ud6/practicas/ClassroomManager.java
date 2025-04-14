package ud6.practicas;

import java.util.*;

public class ClassroomManager {

    public void distributeStudents(String[][] classroom, String[][] studentList) {

        int n = studentList.length;
        List<String> students = new ArrayList<>();
        Map<String, List<String>> restrictions = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            String name = studentList[i][0];
            students.add(name);
            List<String> restric = new ArrayList<>();
            if (studentList[i].length > 1 && studentList[i][1] != null) {
                restric.add(studentList[i][1]);
            }
            if (studentList[i].length > 2 && studentList[i][2] != null) {
                restric.add(studentList[i][2]);
            }
            restrictions.put(name, restric);
        }
        
        int rows = classroom.length;
        int cols = classroom[0].length;
        
        // Confirmar que el número de asientos es igual al número de estudiantes.
        if (rows * cols != students.size()) {
            throw new IllegalArgumentException("El número de asientos no coincide con el número de alumnos.");
        }
        
        Random rand = new Random();
        boolean validDistribution = false;
        
        // Intentamos repetir el proceso hasta hallar una distribución válida.
        while (!validDistribution) {
            // Se mezclan aleatoriamente los estudiantes
            Collections.shuffle(students, rand);
            
            // Rellenamos el array classroom fila a fila.
            int index = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    classroom[i][j] = students.get(index++);
                }
            }
            
            // Verificamos la distribución en las filas (solo se debe evaluar a los vecinos inmediatos en la misma fila)
            validDistribution = checkValidDistribution(classroom, restrictions);
        }
    }
    
    // Método auxiliar para verificar que en cada fila, ningún alumno tenga a un vecino (izquierda o derecha)
    // que se encuentre en su lista de restricciones.
    private boolean checkValidDistribution(String[][] classroom, Map<String, List<String>> restrictions) {
        int rows = classroom.length;
        int cols = classroom[0].length;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                String currentStudent = classroom[i][j];
                List<String> restric = restrictions.get(currentStudent);
                // Comprobar vecino izquierdo (si existe)
                if (j - 1 >= 0) {
                    String leftNeighbor = classroom[i][j - 1];
                    if (restric.contains(leftNeighbor)) {
                        return false;
                    }
                }
                // Comprobar vecino derecho (si existe)
                if (j + 1 < cols) {
                    String rightNeighbor = classroom[i][j + 1];
                    if (restric.contains(rightNeighbor)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
    
    // Método para mostrar la distribución del aula en la salida
    public void showClassrom(String[][] classroom) {
        System.out.println("Distribución da aula:");
        for (int i = 0; i < classroom.length; i++) {
            for (int j = 0; j < classroom[i].length; j++) {
                System.out.print(classroom[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    // Método main para probar la solución con algunos casos de ejemplo.
    public static void main(String[] args) {
        ClassroomManager manager = new ClassroomManager();
        
        // Ejemplo de studentList en Java (caso de enunciado)
        String[][] studentList = new String[][] {
            {"Alberto", "Juan", "Pedro"},
            {"Juan", "Alberto", "Pedro"},
            {"Lara", null, null},
            {"Marcos", null, null},
            {"Sonia", "Alex", "Alberto"},
            {"Pedro", "Alberto", "Juan"},
            {"Iago", "Sonia", null},
            {"Alex", "Sonia", null}
        };
        
        // Ejemplo de aula: 2 filas x 4 columnas
        String[][] classroom = new String[2][4];
        
        // Distribuir los alumnos
        manager.distributeStudents(classroom, studentList);
    
        manager.showClassrom(classroom);
    }
}
