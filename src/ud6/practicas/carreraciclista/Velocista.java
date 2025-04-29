package ud6.practicas.carreraciclista;

public class Velocista extends Ciclista{
	
	private double potenciaPromedio; // en vatios
	private double velocidadPromedio; // en km/h

	public Velocista(int identificador, String nombre, double potenciaPromedio, double velocidadPromedio) {
		super(identificador, nombre);
		this.potenciaPromedio = potenciaPromedio;
		this.velocidadPromedio = velocidadPromedio;
	}

	public double getPotenciaPromedio() {
		return potenciaPromedio;
	}

	public void setPotenciaPromedio(double potenciaPromedio) {
		this.potenciaPromedio = potenciaPromedio;
	}

	public double getVelocidadPromedio() {
		return velocidadPromedio;
	}

	public void setVelocidadPromedio(double velocidadPromedio) {
		this.velocidadPromedio = velocidadPromedio;
	}

	/**
	 * Método muestra en pantalla la clase a la que pertenece el objeto.
	 * @return El tipo de la clase.
	 */
	@Override
	public String imprimirTipo() {
		String tipo = "Es un " + this.getClass().getSimpleName();
		return tipo;
	}

	@Override
	public void imprimir() {
		super.imprimir();
		System.out.println("Potencia promedio = " + potenciaPromedio);
		System.out.println("Velocidad promedio = " + velocidadPromedio);
	}

	@Override
	protected void calculaTiempoParcial() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'calculaTiempoParcial'");
	}

	@Override
	protected void acumulaTiempoTotal() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'acumulaTiempoTotal'");
	}

} // clase
