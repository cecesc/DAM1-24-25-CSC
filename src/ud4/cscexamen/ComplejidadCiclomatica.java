//Autora:Celia Sanmartín Chapela
package ud4.cscexamen;

public class ComplejidadCiclomatica {
    public static void main(String[] args) {

        System.out.println();
        System.out.println(complejidadCiclomatica(null));

    }

    static int complejidadCiclomatica(int[][] grafo) {
        int[][] grafo1 = {
                { 1 },
                { 3, 5 },
                { 1 },
                { 2, 4 },
                { 6 },
                { 6 },
                {}
        };

        int[][] grafo2 = {
                { 1, 6 },
                { 2, 5 },
                { 3, 4 },
                { 4 },
                { 1 },
                { 0 },
                {}
        };

        int aristas1, aristas2, Nodo1 = 0, Nodo2 = 0, nodosPredicado = 0, contador = 0;

        Nodo1 = grafo1.length;
        Nodo2 = grafo2.length;
        for (int i = 0; i < grafo2.length; i++) {
            contador++;

        }
        aristas1 = grafo1.length + 1;
        aristas2 = grafo2.length - 1;
        int operacion1 = aristas1 + Nodo1 - 2;
        int operacion2 = aristas2 + Nodo2 - 2;

        System.out.println("GRAFO 1");
        System.out.println(" 1 V(G)= " + grafo1.length);
        System.out.println("V(G)= A - N + 2");
        System.out.println("V(G)= " + operacion1);

        System.out.println("GRAFO 2");
        System.out.println("1 V(G)= " + grafo2.length);
        System.out.println("V(G)= A - N + 2");
        System.out.println("V(G)= " + operacion2);

        return operacion1;
    }
}
