package ud6.practicas.geografia;

import java.util.ArrayList;
import java.util.Collections;

public class Departamento {

    private String nombre;
    private ArrayList<Municipio> municipios;

    public Departamento(String nombre, ArrayList<Municipio> municipios) {
        this.nombre = nombre;
        this.municipios = municipios;
        Collections.sort(this.municipios);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Municipio> getMunicipio() {
        return municipios;
    }

    public void setMunicipio(ArrayList<Municipio> municipios) {
        this.municipios = municipios;
    }

    // metodos de la clase Departamento

    // metodo agrega municipio
    public void agregarMunicipio(Municipio municipio) {
        if (!municipios.contains(municipio)) {
            municipios.add(municipio);
            Collections.sort(this.municipios);
        } else {
            System.out.println("El municipio " + municipio.getNombre() + " ya existe.");
        }
    }

    // metodo para buscar el municipio
    public Municipio buscarMunicipio(String nombre) {
        for (Municipio municipio : municipios) {
            if (municipio.getNombre().equalsIgnoreCase(nombre)) {
                return municipio;
            }
        }
        return null;
    }

    // metodo para eliminar un municipio
    public void eliminarMunicipio(String nombre) {
        Municipio municipio = buscarMunicipio(nombre);
        if (municipio != null) {
            municipios.remove(municipio);
        } else {
            System.out.println("El municipio " + nombre + " no se encuentra.");
        }
    }

    public void buscarMunicipioConPoblacionMayor(int poblacion) {
        for (Municipio municipio : municipios) {
            if (municipio.getPoblacion() >= poblacion) {
                System.out.println(municipio);
            }
        }
    }

    // metodo de calculo de censo de poblacion del departamento
    public int calcularCensoPoblacionDepartamento() {
        int cen = 0;
        for (Municipio municipio : municipios) {
            cen += municipio.getPoblacion();
        }
        return cen;
    }

    public void listarMunicipios() {
        System.out.println("-------------------");
        for (Municipio municipio : municipios) {
            System.out.println(municipio);
        }
        System.out.println("Listado de los municipios");
        for (int i = 0; i < municipios.size(); i++) {
            System.out.println(municipios.get(i));
        }
    }
}