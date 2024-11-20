//Autor: Celia Sanmartín Chapela
package ud2.cscexamen;

public class ChiclesRegalo {
    public static int totalChicles(int chiclesComprados, int envoltoriosReunir, int totalChiclesGratis) {

        do {
            if (chiclesComprados < 0 || envoltoriosReunir < 0 || totalChiclesGratis < 0) {
                System.out.println("Error. Numero inválido");
            }
        } while (chiclesComprados < 0 || envoltoriosReunir < 0 || totalChiclesGratis < 0);

        while (chiclesComprados == 5 || chiclesComprados % 5 == 0) {
            totalChiclesGratis++;
        }

        return totalChiclesGratis;
    }

    public static void main(String[] args) {
        System.out.println(totalChicles(0, 0, 0));
    }
}
