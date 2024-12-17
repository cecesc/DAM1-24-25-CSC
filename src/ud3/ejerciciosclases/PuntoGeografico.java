/*PuntoGeografico. Investiga en Internet el funcionamiento del sistema GPS y las coordenadas de latitud y longitud. Puedes utilizar el siguiente prompt en chatGPT:

Prompt. Explícame el funcionamiento de la latitud y longitud en las coordenadas geográficas. 


Implementa la clase PuntoGeografico con las siguientes especificaciones:
Atributos privados para almacenar la latitud y longitud y una cadena de caracteres a modo de nombre o etiqueta.
Un constructor que permita introducir los valores de todos los atributos y que devuelva una excepción si las coordenadas de latitud o longitud no son válidas.
Un constructor por defecto que inicialice el punto al paso del meridiano de Greenwich por el Ecuador.
Un constructor que permita introducir coordenadas de latitud y longitud válidas o que devuelva una excepción si no lo son.
Un método que muestre por pantalla la información del punto en formato de grados decimales.

public void mostrarGradosDecimales();


Un método estático que devuelva un punto geográfico cuya latitud y longitud se generen aleatoriamente.

public PuntoGeografico generarAleatorio();


Un método que devuelve una cadena de caracteres como la siguiente:

https://www.google.es/maps/@42.3716382,-8.6897279,12z  


Donde los valores coloreados se sustituyan por la latitud y longitud del punto.

public String urlGoogleMaps();

Un método que devuelve una cadena de caracteres como la siguiente:

https://www.openstreetmap.org/#map=14/42.3716382/-8.6897279      


Donde los valores coloreados se sustituyan por la latitud y longitud del punto.

public String urlOpenStreetMaps();


Investiga el funcionamiento de la API https://nominatim.org/ basada en OpenStreetMaps.


Añade a la clase los siguientes métodos 

Un método que devuelve una cadena de caracteres como la siguiente:

https://nominatim.openstreetmap.org/reverse?format=xml&lat=42.3716382&lon=-8.6897279&zoom=14  


Donde los valores coloreados se sustituyan por la latitud y longitud del punto.

public String urlNominatimXml();

Un método que devuelve una cadena de caracteres como la siguiente:

https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=42.3716382&lon=-8.6897279 


Donde los valores coloreados se sustituyan por la latitud y longitud del punto.

public String urlNominatimJson();*/

package ud3.ejerciciosclases;

import java.util.Random;

public class PuntoGeografico {
    private double latitud;
    private double longitud;
    private String etiqueta;

    public PuntoGeografico(double latitud, double longitud, String etiqueta) throws IllegalArgumentException {
        if (latitud < -90 || latitud > 90) {
            throw new IllegalArgumentException("La latitud debe estar entre -90 y 90 grados.");
        }
        if (longitud < -180 || longitud > 180) {
            throw new IllegalArgumentException("La longitud debe estar entre -180 y 180 grados.");
        }
        this.latitud = latitud;
        this.longitud = longitud;
        this.etiqueta = etiqueta;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public PuntoGeografico() {
        this(0.0, 0.0, "Ecuador y Meridiano de Greenwich");
    }

    public void mostrarGradosDecimales() {
        System.out.println("Punto: " + etiqueta + " | Latitud: " + latitud + " | Longitud: " + longitud);
    }

    public static PuntoGeografico generarAleatorio() {
        Random random = new Random();
        double latitud = -90 + (90 - (-90)) * random.nextDouble();
        double longitud = -180 + (180 - (-180)) * random.nextDouble();
        return new PuntoGeografico(latitud, longitud, "Punto Aleatorio");
    }

    public String urlGoogleMaps() {
        return "https://www.google.es/maps/@" + latitud + "," + longitud + ",12z";
    }

    public String urlOpenStreetMaps() {
        return "https://www.openstreetmap.org/#map=14/" + latitud + "/" + longitud;
    }

    public String urlNominatimXml() {
        return "https://nominatim.openstreetmap.org/reverse?format=xml&lat=" + latitud + "&lon=" + longitud
                + "&zoom=14";
    }

    public String urlNominatimJson() {
        return "https://nominatim.openstreetmap.org/reverse?format=jsonv2&lat=" + latitud + "&lon=" + longitud;

    }
}
