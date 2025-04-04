package ud6.coleccionesejercicios;

public class E1213 {
    public static void main(String[] args) {
        System.out.println("SORTEO DE LA PRIMITIVA (Integer)");
        Sorteo<Integer> primitiva = new Sorteo<>();

        // Añade al "bombo" los números del 1 al 49
        for (int i = 1; i < 50; i++){
            primitiva.add(i);
        }
    
        System.out.println("Premiados: " + primitiva.premiados(6));        


        
    
    }
}

