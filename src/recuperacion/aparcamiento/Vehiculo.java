package recuperacion.aparcamiento;
/*Desarrolla una clase Aparcamiento con los siguientes atributos privados:
capacidadMaxima (la cantidad máxima de plazas de aparcamiento en el aparcamiento)
plazas (un array que representa las plazas de aparcamiento y que contendrá objetos de tipo Vehiculo si la plaza está ocupada, o null si la plaza está libre)

Crea la clase Vehículo que tendrá al menos un atribut, matricula, de tipo String.

Implementa los siguientes métodos:
Constructor predeterminado: establece la capacidad máxima en 100 y crea un array de plazas vacías.
Constructor con la capacidad máxima del aparcamiento como parámetro; inicializa el array de plazas con la capacidad máxima y marca todas las plazas como vacías.
Getter para capacidadMaxima.
aparcarVehiculo(Vehiculo vehiculo): simula la acción de aparcar un vehículo en el aparcamiento. Recibe como parámetro un objeto de la clase Vehiculo que representa el vehículo a aparcar. Busca la primera plaza vacía en el array de plazas y la marca como ocupada por el vehículo. Si no hay plazas vacías, devuelve un valor booleano false.
Y si el vehículo ya está en el aparcamiento?? Entonces no se añade y se devuelve false
sacarVehiculo(Vehiculo vehiculo): simula la acción de sacar un vehículo del aparcamiento. Recibe como parámetro un objeto de la clase Vehiculo que representa el vehículo a sacar. Busca la plaza ocupada por el vehículo en el array de plazas y la marca como vacía. Si el vehículo no está en el aparcamiento, devuelve un valor booleano false.
int numPlazasLibres(): Cuenta el número de plazas libres.
void mostrarEstado(): imprime el estado actual del aparcamiento, mostrando las plazas ocupadas y vacías.
void mostrarEstadoDetallado(): imprime el listado detallado de las plazas ocupadas, indicando número de plaza y matrícula de vehículo en forma de tabla.

Vehiculo consultarPlaza(int numeroPlaza): consulta el estado de una plaza específica del aparcamiento, indicada por su número de plaza y devuelve el vehículo que se encuentra en ella o null si está vacía.
int consultarPlazaVehiculo(Vehiculo vehiculo): devuelve el número de plaza en la que se encuentra un vehículo o -1 si no se encuentra en el aparcamiento.
int[] plazasLibres(): devuelve un array con los números de plaza en las que no hay aparcadas ningún vehículo.
int[] plazasOcupadas(): devuelve un array con los números de plaza en las que hay aparcado algún vehículo.
int numPlazasOcupadas(): Cuenta el número de plazas ocupadas.

Para representar los vehículos, puedes utilizar una clase separada llamada Vehiculo con los atributos que consideres necesarios (por ejemplo, matrícula, marca, modelo). Puedes considerar que dos vehículos son iguales si tienen la misma matrícula.
En el enunciado se utilizan los métodos "aparcarVehiculo" y "sacarVehiculo" para interactuar con el aparcamiento y la clase Vehiculo se utiliza como parámetro para indicar qué vehículo se desea aparcar o sacar del aparcamiento."

aparcarGrupoVehiculos(List<Vehiculo> vehiculos): Este método simula la acción de aparcar un grupo de vehículos al mismo tiempo. Recibe como parámetro una lista de vehículos que se desean aparcar. Suponemos que en la lista no hay vehículos repetidos.

Verifica si algún vehículo de la lista ya se encuentra en el aparcamiento.
Si es así no aparca ningún vehículo y devuelve false.

Verifica si hay suficiente capacidad en el aparcamiento para aparcar el grupo completo. 
Si es así los aparca y devuelve true. Si no hay suficiente capacidad, no aparca ninguno y devuelve false.



sacarGrupoVehiculos(List<Vehiculo> vehiculos): Este método simula la acción de sacar un grupo de vehículos del aparcamiento al mismo tiempo. Recibe como parámetro la lista de vehículos que se desean sacar. Suponemos que en la lista no hay vehículos repetidos.

Verifica si todos los vehículos de la lista están realmente aparcados. 
Si es así los saca y devuelve true.
Si no están todos, saca los que pueda pero devuelve false

Un método que obtenga la lista de vehículos aparcados ordenados por matrícula (orden natural). Si no hay vehículos aparcados devuielve null.
List<Vehiculo> vehiculosAparcados()
Un método que obtenga un mapa de los vehículos aparcados en un aparcamiento indicando como clave el número de plaza y como valor el vehículo. Si no hay vehículos aparcados devuielve null.
Map<Integer, Vehiculo> plazasVehiculos()
Un método que obtenga un mapa de los vehículos aparcados en un aparcamiento indicando como clave el vehículo y como valor el número de plaza. Si no hay vehículos aparcados devuielve null.
Map<Vehiculo, Integer> vehiculosPlazas()

Con esta clase, podrías modelar un sistema de gestión de un aparcamiento, donde se pueden estacionar y sacar vehículos, y se puede conocer la ocupación actual del aparcamiento.

Más tareas…
Extender la clase vehículo para modelar la clase VechículoPesado que incluya los atributos de peso y altura. 
Añadir al aparcamiento el atributo privado alturaMáxima y controlar en los métodos que sea necesario que no se aparquen vehículos que superen esta altura.
 */
import java.util.Objects;

public class Vehiculo implements Comparable<Vehiculo> {
    private String matricula;

    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehiculo)) return false;
        Vehiculo vehiculo = (Vehiculo) o;
        return Objects.equals(matricula, vehiculo.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }

    @Override
    public String toString() {
        return "Vehiculo{" + "matricula='" + matricula + '\'' + '}';
    }

    @Override
    public int compareTo(Vehiculo otro) {
        return this.matricula.compareTo(otro.matricula);
    }
}

