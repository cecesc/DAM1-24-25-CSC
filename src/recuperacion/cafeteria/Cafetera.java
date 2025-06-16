package recuperacion.cafeteria;
/*Desarrolla una clase Cafetera con los siguientes atributos privados:
capacidad (la cantidad máxima de café que puede contener la cafetera)
cantidadActual (la cantidad actual de café que hay en la cafetera). 

Implementa los siguientes métodos:
Constructor predeterminado: establece la capacidad máxima en 1000 (c.c.) y la actual en cero (cafetera vacía).
Constructor con la capacidad máxima de la cafetera como parámetro; inicializa la cantidad actual de café igual a la capacidad máxima.
Constructor con la capacidad máxima y la cantidad actual como parámetros. Si la cantidad actual es mayor que la capacidad máxima de la cafetera, la ajustará al máximo.
Setter para cantidadActual y getters para los dos atributos.
llenarCafetera(): hace que la cantidad actual sea igual a la capacidad.
servirTaza(int capacidadTaza): simula la acción de servir una taza con la capacidad indicada. Si la cantidad actual de café “no alcanza” para llenar la taza, se sirve lo que quede. 
vaciarCafetera(): pone la cantidad de café actual en cero.
agregarCafe(int cantidad): añade a la cafetera la cantidad de café indicada. Sólo se añadirá café hasta alcanzar la capacidad máxima de la cafetera, el café “sobrante” no se añadirá.
mostrar(): imprime la capacidad máxima de la cafetera y la cantidad actual de café.
toString(): devuelve un String con la capacidad máxima de la cafetera.

Extras:
Tanto los constructores como los setters no permitirán que los atributos tengan valores negativos ni que el valor del atributo cantidadActual sea mayor que el de capacidad. 
Define las constantes de clase CAPACIDAD_MINIMA = 50 y CAPACIDAD_MAXIMA = 1000 y utilízalas en los constructores para asegurarte de que el atributo capacidad de los objetos que se creen esté entre estos límites. 
Si se intenta establecer una cantidadActual de café negativa se establecerá un valor de 0.
Modifica los métodos servirTaza() y agregarCafe() para que descarten valores negativos de los parámetros de entrada.
Modifica el método servirTaza() para que devuelva true si se ha conseguido llenar la taza de café y false en caso contrario. 
Modifica el método agregarCafe() para que devuelva la cantidad de café “sobrante” o cero en caso contrario si se ha podido agregar todo. 
Implementa el método toString();
 */
public class Cafetera {
    // Constantes
    public static final int CAPACIDAD_MINIMA = 50;
    public static final int CAPACIDAD_MAXIMA = 1000;

    // Atributos privados
    private int capacidad;
    private int cantidadActual;

    // Constructor por defecto
    public Cafetera() {
        this.capacidad = CAPACIDAD_MAXIMA;
        this.cantidadActual = 0;
    }

    // Constructor con capacidad
    public Cafetera(int capacidad) {
        this.capacidad = ajustarCapacidad(capacidad);
        this.cantidadActual = this.capacidad;
    }

    // Constructor con capacidad y cantidadActual
    public Cafetera(int capacidad, int cantidadActual) {
        this.capacidad = ajustarCapacidad(capacidad);
        this.cantidadActual = ajustarCantidad(cantidadActual);
    }

    // Método auxiliar para ajustar capacidad dentro de los límites
    private int ajustarCapacidad(int capacidad) {
        if (capacidad < CAPACIDAD_MINIMA) {
            return CAPACIDAD_MINIMA;
        } else if (capacidad > CAPACIDAD_MAXIMA) {
            return CAPACIDAD_MAXIMA;
        } else {
            return capacidad;
        }
    }

    // Método auxiliar para ajustar cantidadActual sin pasarse de capacidad ni ser
    // negativa
    private int ajustarCantidad(int cantidad) {
        if (cantidad < 0) {
            return 0;
        } else if (cantidad > this.capacidad) {
            return this.capacidad;
        } else {
            return cantidad;
        }
    }

    // Getter y Setter
    public int getCapacidad() {
        return capacidad;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = ajustarCantidad(cantidadActual);
    }

    // llenarCafetera
    public void llenarCafetera() {
        this.cantidadActual = this.capacidad;
    }

    // servirTaza
    public boolean servirTaza(int capacidadTaza) {
        if (capacidadTaza <= 0)
            return false;

        if (cantidadActual >= capacidadTaza) {
            cantidadActual -= capacidadTaza;
            return true;
        } else {
            cantidadActual = 0;
            return false;
        }
    }

    // vaciarCafetera
    public void vaciarCafetera() {
        this.cantidadActual = 0;
    }

    // agregarCafe
    public int agregarCafe(int cantidad) {
        if (cantidad <= 0)
            return 0;

        int espacioLibre = capacidad - cantidadActual;
        if (cantidad <= espacioLibre) {
            cantidadActual += cantidad;
            return 0;
        } else {
            cantidadActual = capacidad;
            return cantidad - espacioLibre;
        }
    }

    // mostrar
    public void mostrar() {
        System.out.println("Cafetera: " + cantidadActual + "/" + capacidad + "cc.");
    }

    // toString
    @Override
    public String toString() {
        return "Cafetera con capacidad máxima de " + capacidad + " cc.";
    }
}
