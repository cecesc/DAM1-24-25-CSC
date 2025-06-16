package recuperacion.inmobiliaria;
/*Crea las clases necesarias (Inmueble, Piso y Casa) para ejecutar el código anterior produciendo una salida por consola como la siguiente:

Inmueble en Calle Curtidoira (100 m2, 3 hab)
Inmueble en Carretera de Marín (250 m2, 4 hab)

Piso en Calle Curtidoira.
100 m2, 3 hab, 2 baños, 5ª planta.
Precio de Alquiler: 500 €
Precio de Venta: 200000 €


Piso en Praza Maior.
80 m2, 2 hab, 2 baños, 3ª planta.
Precio de Alquiler: 400 €


Casa en Lapaman.
150 m2, 3 hab, 2 baños, con terreno de 1000 m2.
Precio de Venta: 400000 €


Reúne los atributos y comportamientos comunes a las clases Piso y Casa en la superclase Inmueble de la que heredan. 
Define la clase Inmueble como abstracta y declara en ella el método abstracto String detalle() que se implementará en cada una de las clases hijas.
Reutiliza todo el código posible y evita duplicidades.
Evita incluir código innecesario que no vayas a utilizar.
Utiliza identificadores adecuados.
Utiliza modificadores de acceso adecuados para los miembros de las clases. Por defecto, ningún atributo de las clases será accesible directamente desde otros paquetes.
3.2. Inmobiliaria - Comparar y ordenar colecciones de inmuebles
Modifica la clase Inmueble para hacer que dos inmuebles se consideren iguales si coincide la misma dirección. Define como método de ordenación natural el orden alfabético de dirección.
Amplía el programa principal del apartado anterior para añadir los inmuebles de ejemplo a una nueva colección y mostrarlos ordenados por el método de ordenación natural.
Muestra a continuación la lista de inmuebles ordenados primero por número de habitaciones descendentemente y en caso de empate por metros cuadrados, también descendentemente.
 */

    import java.util.Objects;

public abstract class Inmueble implements Comparable<Inmueble> {
    protected String direccion;
    protected int metros;
    protected int habitaciones;
    protected int banos;
    protected Integer precioAlquiler = null;
    protected Integer precioVenta = null;

    public Inmueble(String direccion, int metros, int habitaciones, int banos) {
        this.direccion = direccion;
        this.metros = metros;
        this.habitaciones = habitaciones;
        this.banos = banos;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getMetros() {
        return metros;
    }

    public int getHabitaciones() {
        return habitaciones;
    }

    public int getBanos() {
        return banos;
    }

    public void setPrecioAlquiler(int precioAlquiler) {
        this.precioAlquiler = precioAlquiler;
    }

    public void setPrecioVenta(int precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getPrecioAlquiler() {
        return precioAlquiler;
    }

    public Integer getPrecioVenta() {
        return precioVenta;
    }

    @Override
    public String toString() {
        return "Inmueble en " + direccion + " (" + metros + " m2, " + habitaciones + " hab)";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Inmueble)) return false;
        Inmueble that = (Inmueble) o;
        return direccion.equalsIgnoreCase(that.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion.toLowerCase());
    }

    @Override
    public int compareTo(Inmueble otro) {
        return this.direccion.compareToIgnoreCase(otro.direccion);
    }

    public abstract String detalle();
}

