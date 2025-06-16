package recuperacion.embarque;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GestionEmbarque {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Transbordador transbordador = new Transbordador();
        boolean salir = false;

        while (!salir) {
            System.out.println("1. Embarca vehículo");
            System.out.println("2. Informe vehículos embarcados");
            System.out.println("3. Reseteo embarque");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            try {
                switch (opcion) {
                    case 1:
                        System.out.print("Tipo (turismo/camion/autobus): ");
                        String tipo = sc.nextLine().toLowerCase();
                        System.out.print("Matrícula: ");
                        String matricula = sc.nextLine();
                        System.out.print("Pasajeros: ");
                        int pasajeros = sc.nextInt();
                        Vehiculo v = null;
                        if (tipo.equals("turismo")) {
                            v = new Turismo(matricula, pasajeros);
                        } else {
                            System.out.print("Peso del vehículo: ");
                            int peso = sc.nextInt();
                            if (tipo.equals("camion")) {
                                v = new Camion(matricula, pasajeros, peso);
                            } else if (tipo.equals("autobus")) {
                                v = new Autobus(matricula, pasajeros, peso);
                            } else {
                                System.out.println("Tipo no válido");
                                continue;
                            }
                        }
                        transbordador.embarcarVehiculo(v);
                        System.out.println("Vehículo embarcado correctamente.");
                        break;
                    case 2:
                        transbordador.informe();
                        break;
                    case 3:
                        transbordador.resetear();
                        System.out.println("Transbordador reseteado.");
                        break;
                    case 4:
                        salir = true;
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            } catch (Vehiculo.MatriculaRepetidaException | Vehiculo.SuperadoPesoMaximoException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida.");
                sc.nextLine();
            }
        }
        sc.close();
    }
}