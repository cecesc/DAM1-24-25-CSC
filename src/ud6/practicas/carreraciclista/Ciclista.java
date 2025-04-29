package ud6.practicas.carreraciclista;

public abstract class Ciclista {
    
    private int identificador; /* Atributo que define el identificador de un ciclista */
	private String nombre; // Atributo que define el nombre del ciclista
	private double tiempoAcumulado = 0; /* Atributo que define el tiempo acumulado de un ciclista */
	private int posicionGeneral;

	public Ciclista(int identificador, String nombre) {
		this.identificador = identificador;
		this.nombre = nombre;
	}
    

	abstract String imprimirTipo();

	protected int getIdentificador() {
		return identificador;
	}

	protected void setIdentificador() {
		this.identificador = identificador;
	}

	protected String getNombre() {
		return nombre;
	}

	protected void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * Método que devuelve el puesto que ocupa un ciclista en la posición general de
	 * la competencia
	 * 
	 * @return El puesto del ciclista en la posición general
	 */

	protected int getPosicionGeneral(int posicionGeneral) {
		return posicionGeneral;
	}

	/**
	 * Método que establece el puesto que ocupa un ciclista en la posición general
	 * 
	 * @param Parámetro que especifica el puesto que ocupa un ciclista en la
	 *                  posición general
	 */
	protected void setPosicionGeneral(int posicionGeneral) {
		posicionGeneral = posicionGeneral;
	}

	/**
	 * Método que devuelve el tiempo acumulado de un ciclista en una competencia
	 * 
	 * @return El tiempo acumulado de un ciclista en una competencia
	 */
	protected double getTiempoAcumulado() {
		return tiempoAcumulado;
	}

	/**
	 * Método que establece el tiempo acumulado por un ciclista
	 * 
	 * @param Parámetro que especifica el tiempo acumulado por un ciclista
	 */
	protected double setTiempoAcumulado(double tiempoAcumulado) {
		return this.tiempoAcumulado = tiempoAcumulado;
	}

	/**
	 * Método muestra en pantalla los datos de un ciclista
	 */
	protected void imprimir() {
		System.out.println("Identificador = " + identificador);
		System.out.println("Nombre = " + nombre);
		System.out.println("Tiempo Acumulado = " + tiempoAcumulado);
		System.out.println("Posicion = "+ posicionGeneral);
	}


    protected abstract void calculaTiempoParcial();


    protected abstract void acumulaTiempoTotal();
}