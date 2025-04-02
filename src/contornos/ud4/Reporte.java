package contornos.ud4;

public class Reporte {

    public void exportarPDF(String datos) {
        System.out.println("Exportando a PDF: " + datos);
    }

    public void exportarExcel(String datos) {
        System.out.println("Exportando a Excel: " + datos);
    }

    public void exportarCSV(String datos) {
        System.out.println("Exportando a CSV: " + datos);
    }
}

/*
 Enunciado: Cada vez que tenemos que hacer un cambio en un sistema, 
 debemos modificar demasiadas cosas dentro de una misma clase.
 
Mal Cheiro: Código Diverxente.

Solución: Usar o principio de aberto/pechado, movendo a lóxica de 
exportación a clases separadas.

 */