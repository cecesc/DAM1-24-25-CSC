package contornos.ud4;

public class Procesador {
    public void procesarDatos(String datos) {
        // Validar datos
        if (datos == null || datos.isEmpty()) {
            throw new IllegalArgumentException("Datos non válidos");
        }

        // Preprocesar datos
        String datosProcesados = datos.trim().toUpperCase();

        // Realizar operacións sobre os datos
        int result = 0;
        for (int i = 0; i < datosProcesados.length(); i++) {
            result += datosProcesados.charAt(i);
        }

        // Exibir resultado
        System.out.println("Resultado: " + result);
    }
}

/*
Enunciado: Un método con moito código e responsabilidade múltiple, dificultando a súa comprensión.
 
Mal cheiro: Método Longo.

Solución: Dividir o método en varios métodos máis pequenos.
 
 */
