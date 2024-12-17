/*EP0711. Escribe la clase MarcaPagina, que ayuda a llevar el control de la lectura de un libro. Deberá disponer de métodos para incrementar la página leída, para obtener información de la última página que se ha leído y para comenzar desde el principio una nueva lectura del mismo libro.*/

package ud3.ejerciciosclases;

public class MarcaPagina {
    int paginaLeida;
    int totalPaginas;

    public MarcaPagina(int totalPaginas) {
        this.totalPaginas = totalPaginas;
        this.paginaLeida = 0;
    }

    public void incrementarPagina() {
        if (paginaLeida < totalPaginas) {
            paginaLeida++;
        } else {
            System.out.println("Ya has leído todas las páginas del libro.");
        }
    }

    public int obtenerPaginaLeida() {
        return paginaLeida;
    }

    public void reiniciarLectura() {
        paginaLeida = 0;
    }

    public static void main(String[] args) {
        MarcaPagina mp = new MarcaPagina(100);
        mp.incrementarPagina();
        mp.incrementarPagina();
        System.out.println("Página leída: " + mp.obtenerPaginaLeida());
        mp.reiniciarLectura();
        System.out.println("Lectura reiniciada. Página leída: " + mp.obtenerPaginaLeida());
    }
}

// OPCIÓN PROFESOR
/*
 * int pagina;
 * //String libro;
 * 
 * public void incrementarPagina() {
 * pagina++;
 * }
 * 
 * 
 * public void reiniciarLibro() {
 * pagina = 0;
 * }
 * 
 * // GETTERS Y SETTERS
 * public int getPagina() {
 * return pagina;
 * }
 * 
 * public void setPagina(int pagina) {
 * if (pagina >= 0)
 * this.pagina = pagina;
 * }
 * 
 * 
 * 
 * public static void main(String[] args) {
 * // Crea marcapáginas
 * MarcaPagina mp = new MarcaPagina();
 * MarcaPagina mp2 = new MarcaPagina();
 * 
 * // Imprime la página actual (página inicial)
 * System.out.println(mp.getPagina());
 * 
 * // Incrementamos la página
 * mp.incrementarPagina();
 * mp.incrementarPagina();
 * 
 * System.out.println(mp.getPagina());
 * 
 * // Reiniciar libro
 * mp.reiniciarLibro();
 * 
 * System.out.println(mp.getPagina());
 * 
 * }
 * }
 */