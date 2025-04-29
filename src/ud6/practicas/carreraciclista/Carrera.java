package ud6.practicas.carreraciclista;


    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.ListIterator;
    import java.util.Scanner;
    
    public class Carrera {
        
        private String nombre;
        private String pais;
        ArrayList<Equipo> listaEquipos; // Atributo que define un ArrayList de equipos que participan en la carrera
        ArrayList<Ciclista> clasificacionGeneral; // ArrayList con la clasificación GENERAL de la competición
    
        public Carrera(String nombreCompeticion, String pais) {
            this.nombre = nombreCompeticion;
            this.pais = pais;
            listaEquipos = new ArrayList<>();
            clasificacionGeneral = new ArrayList<>();
        }
    
        /**
         * Método que añade un etapa al ArrayList de etapas
         */
    //	void añadirEtapa(Etapa etapa) {
    //		listaEtapas.add(etapa); // Se agrega el ciclista al ArrayList de equipos
    //	}
    
        public String getNombre() {
            return nombre;
        }
    
        public void setNombre(String nombre) {
            this.nombre = nombre;
        }
    
        public String getPais() {
            return pais;
        }
    
        public void setPais(String pais) {
            this.pais = pais;
        }
    
        public ArrayList<Equipo> getListaEquipos() {
            return listaEquipos;
        }
    
        public void setListaEquipos(ArrayList<Equipo> listaEquipos) {
            this.listaEquipos = listaEquipos;
        }
    
        public ArrayList<Ciclista> getClasificacionGeneral() {
            return clasificacionGeneral;
        }
    
        public void setClasificacionGeneral(ArrayList<Ciclista> clasificacionGeneral) {
            this.clasificacionGeneral = clasificacionGeneral;
        }
    
        /**
         * Método que añade un equipo al ArrayList de equipos
         */
        public void añadirEquipo(Equipo equipo) {
            listaEquipos.add(equipo); // Se agrega el ciclista al ArrayList de equipos
        }
    
        public void listarEquipo() {
            for (int i = 0; i < listaEquipos.size(); i++) {
                Equipo e = (Equipo) listaEquipos.get(i);
                System.out.println(e.toString());
            }
        }
    
    //	TODO: Está sin terminar
        public void buscarEquipo() {
            boolean estar = false;
            Scanner sc = new Scanner(System.in);
            String nombre = sc.next();
            if (!estar)
                System.out.println("Ningun equipo con ese nombre");
            sc.close();
        }
    
        // Clasificacion equipos
        public void clasificacionEquipos() {
            for (int i = 0; i < listaEquipos.size(); i++) {
                Equipo c = listaEquipos.get(i);
                System.out.println(c.toString());
            }
            // Clasificacion ciclista
    
            ListIterator<Equipo> iter = listaEquipos.listIterator();
            // Mientras haya elementos en la siguiente posicion
            while (iter.hasNext()) {
                // Se obtiene el siguiente metodo y se establece su posicion
                // el nextindex es para pasar a la siguiente posicion
                iter.next().setPosicion(iter.nextIndex());
                // Avanzar al siguiente elemento de la lista
                iter.next();
            }
    
        }
    
        /**
         * Método que imprime la clasificación de la carrera
         */
        public void imprimirClasificacion() {
            ListIterator<Ciclista> iter = clasificacionGeneral.listIterator();
            // Mientras haya siguiente puesto se imprime el equipo
            while (iter.hasNext()) {
                iter.next().imprimirTipo();
            }
        }
    
        /**
         * Método que calcula y muestra los tiempos totales de la carrera ciclista
         */
        public void calculaYMuestraTiemposGenerales() {
            Ciclista c;
    
    //		Calcula general
            for (int i = 0; i < clasificacionGeneral.size(); i++) {
                c = clasificacionGeneral.get(i);
                c.acumulaTiempoTotal();
    //			System.out.println(c.toString());
            }
    
    //		Ordena general
            Collections.sort(clasificacionGeneral,
                    (o1, o2) -> (int) (o1.getTiempoAcumulado()) - (int) (o2.getTiempoAcumulado()));
    
    //		Muestra la clasificación general
            System.out.println("--- CLASIFICACIÓN GENERAL ---");
            for (Ciclista manolin : clasificacionGeneral) {
                System.out.println(manolin);
            }
    
    //		Calcula parcial
            for (int i = 0; i < clasificacionGeneral.size(); i++) {
                c = clasificacionGeneral.get(i);
                c.calculaTiempoParcial();
            }
    
    //		Ordena parcial
            Collections.sort(clasificacionGeneral,
                    (o1, o2) -> (int) (o1.getTiempoAcumulado()) - (int) (o2.getTiempoAcumulado()));
    
    //		Muestra la clasificación parcial
            System.out.println("--- CLASIFICACIÓN PARCIAL ---");
            for (Ciclista manolin : clasificacionGeneral) {
                System.out.println(manolin);
            }
        }
    
    } 
