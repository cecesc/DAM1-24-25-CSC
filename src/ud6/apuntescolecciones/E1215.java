package ud6.apuntescolecciones;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E1215 {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        Map<Producto, Integer> stock = new HashMap<>();
        do {

            opcion = opcionMenu();

            switch (opcion) {
                case 1:
                System.out.println("\nNUEVO PRODUCTO:");
                System.out.println("=================");
                System.out.println("código: ");
                String codigo = sc.nextLine();
                System.out.println("Nombre: ");
                String nombre = sc.nextLine();
                System.out.println("Unidades: ");
                Integer unidades = sc.nextInt();
                Producto p= new Producto(codigo, nombre);
                stock.put(p, unidades);       
                
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }

        } while (opcion != 0);
    }

    private static int opcionMenu() {
        int opcion;
        System.out.println("\nSTOCK  REPUESTOS AUTOMÓVIL");
        System.out.println("=============================");
        System.out.println("1- Dar de alta");
        System.out.println("2- Dar de baja");
        System.out.println("3- actualizar número de unidades");
        System.out.println("Opción: ");
        opcion = sc.nextInt();
        return opcion;
    }
}
