public class Chicles {

    public static int totalChicles(int chiclesComprados, int envoltoriosNecesarios, int chiclesGratis) {
        // Comprobamos si alguno de los parámetros es negativo
        if (chiclesComprados < 0 || envoltoriosNecesarios < 0 || chiclesGratis < 0) {
            return -1;
        }

        // Si no hay oferta
        if (envoltoriosNecesarios == 0) {
            return chiclesComprados;
        }

        // Comprobamos si los chicles gratis son mayores que los envoltorios necesarios
        if (chiclesGratis >= envoltoriosNecesarios) {
            return -1;
        }

        int totalChicles = chiclesComprados;
        int envoltorios = chiclesComprados;

        // Mientras tengamos suficientes envoltorios para canjear por chicles gratis
        while (envoltorios >= envoltoriosNecesarios) {
            // Calculamos cuántos chicles gratis podemos obtener
            int chiclesObtenidos = (envoltorios / envoltoriosNecesarios) * chiclesGratis;
            totalChicles += chiclesObtenidos;

            // Actualizamos la cantidad de envoltorios: los que ya teníamos menos los usados, más los nuevos
            envoltorios = envoltorios % envoltoriosNecesarios + chiclesObtenidos;
        }

        return totalChicles;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        System.out.println(totalChicles(25, 5, 1));  // Debería devolver 31
        System.out.println(totalChicles(10, 3, 1));  // Debería devolver 13
        System.out.println(totalChicles(0, 5, 1));   // Debería devolver 0
        System.out.println(totalChicles(25, 0, 1));  // Debería devolver 25
        System.out.println(totalChicles(10, 3, 5));  // Debería devolver -1
    }
}
