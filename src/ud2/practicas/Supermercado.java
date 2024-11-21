package ud2.practicas;

import java.util.Scanner;

public class Supermercado {
    public static double importeTotalProducto(double precio, int ud) {
        return precio * ud;
    }

    public static void metodoPago(int menuPago) {
        switch (menuPago) {
            case 1:
                System.out.println("Pago con tarjeta. Compra finalizada.");
                break;
            case 2:
                System.out.println("Pago con efectivo");
                break;
            default:
                System.out.println("Método de pago introducido incorrectamente");
                break;
        }
    }

    public static void procesarPagoEnEfectivo(double efectivoCliente, double totalCompra) {
        Scanner sc = new Scanner(System.in);
        do {
            if (efectivoCliente < totalCompra) {
                System.out.print("La cantidad entregada no es suficiente. Introduzca otra cantidad: ");
                efectivoCliente = sc.nextDouble();
            }
        } while (efectivoCliente < totalCompra);

        sc.close();

        if (efectivoCliente == totalCompra) {
            System.out.println("Pago exacto. No hay cambio");
        } else {
            System.out.printf("Su cambio es de: %.2f euros \n", efectivoCliente - totalCompra);
        }
    }

    public static void desglosarCambio(double cambio) {
        int billetes50 = (int) (cambio / 50);
        cambio %= 50;
        int billetes20 = (int) (cambio / 20);
        cambio %= 20;
        int billetes10 = (int) cambio / 10;
        cambio %= 10;
        int billetes5 = (int) (cambio / 5);
        cambio %= 5;
        int euros2 = (int) (cambio / 2);
        cambio %= 2;
        int euros1 = (int) (cambio / 1);
        cambio %= 1;

        double centimos = cambio * 10;
        double centimosRedondeados = Math.round(centimos);

        System.out.println("Desglose de cambio:");
        System.out.println();
        System.out.println("Billetes de 50: " + billetes50);
        System.out.println("Billetes de 20: " + billetes20);
        System.out.println("Billetes de 10: " + billetes10);
        System.out.println("Billetes de 5: " + billetes5);
        System.out.println("Euros de 2: " + euros2);
        System.out.println("Euros de 1: " + euros1);
        System.out.println("Céntimos: " + centimosRedondeados);
    }

    private static double calcularPrecioTotal(double precioProducto, int unidades) {
        double precio_total = precioProducto * unidades;
        return precio_total;
    }

    public static void main(String[] args) {
        double precioProducto = 0;
        double precioTotal = 0;
        int udProducto, menuPago;
        boolean continuarCompra;

        Scanner sc = new Scanner(System.in);

        do {
            try {
                System.out.println(
                        "Introduzca el precio del producto y las unidades. Cuando finalice pulse -1.");
                while (precioProducto != -1) {
                    System.out.print("Introduce el precio del producto: ");
                    precioProducto = sc.nextDouble();
                    System.out.print("Introduce las unidades del producto: ");
                    udProducto = sc.nextInt();

                    precioTotal += calcularPrecioTotal(precioProducto, udProducto);
                    System.out.printf("Total artículos: %.2f euros \n", precioTotal);

                    System.out.printf("El total de la compra es de: %.2f euros \n", precioTotal);
                }

                do {
                    System.out.print("Como desea pagar: (Pulse 1 para tarjeta y 2 para efectivo: ");
                    menuPago = sc.nextInt();
                    switch (menuPago) {
                        case 1:
                            System.out.println("Ha seleccionado pago con tarjeta");
                            System.out.println("Gracias por su compra! Hasta pronto!");
                            break;
                        case 2:
                            System.out.println("Ha seleccionado pago con efectivo");
                            System.out.print("Introduce el importe entregado en efectivo: ");
                            double efectivoCliente = sc.nextDouble();

                            while (efectivoCliente < precioTotal) {
                                System.out.print("La cantidad entregada no es suficiente. Introduzca otra cantidad: ");
                                efectivoCliente = sc.nextDouble();
                            }
                            ;

                            desglosarCambio(efectivoCliente - precioTotal);
                            break;
                        default:
                            System.out.println("Introduce 1 o 2");
                            break;
                    }
                } while (menuPago != 1 && menuPago != 2);

            } catch (Exception e) {
                System.out.println("Se ha producido un error: " + e + ". Por favor, inténtelo den nuevo.");
            }
            System.out.print("Desea realizar otra compra? Introduzca '1' para continuar con su compra: ");
            continuarCompra = sc.nextInt() == 1;
        } while (continuarCompra);

        System.out.println("Gracias por su compra. Que tenga un buen día!");
        sc.close();
    }
}