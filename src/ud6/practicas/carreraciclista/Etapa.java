package ud6.practicas.carreraciclista;

import java.util.ArrayList;
import java.util.Collections;

public class Etapa extends Carrera {

////	Tiempo total de un equipo concreto en una etapa específica
////	(este atributo podría acumularse en la clase Equipo)
	private int numEtapa;
	private int distancia; // en kms
	private String tipoEtapa; // llana, contrarreloj o individual (debería ser un enumerado)
	ArrayList<Ciclista> clasificacionParcial; // ArrayList con la clasificación PARCIAL de la competición
//
public Etapa(String nombreCompeticion, int numEtapa, int distancia, String tipoEtapa) {
	super(nombreCompeticion, tipoEtapa);
		this.numEtapa = numEtapa;
		this.distancia = distancia;
		this.tipoEtapa = tipoEtapa;
	}

	public int getNumEtapa() {
		return numEtapa;
	}

	public void setNumEtapa(int numEtapa) {
		this.numEtapa = numEtapa;
	}

	public int getDistancia() {
		return distancia;
	}

	public void setDistancia(int distancia) {
		this.distancia = distancia;
	}

	public String getTipoEtapa() {
		return tipoEtapa;
	}

	public void setTipoEtapa(String tipoEtapa) {
		this.tipoEtapa = tipoEtapa;
	}

	public void calculaYMuestraTiemposParciales() {
		for (Ciclista c : clasificacionParcial) {
			c.calculaTiempoParcial();
			c.acumulaTiempoTotal();
			System.out.println(c.toString());
		}
		Collections.sort(clasificacionParcial,
				(o1, o2) -> (int) (o1.getTiempoAcumulado()) - (int) (o2.getTiempoAcumulado()));
	}

} // clase

