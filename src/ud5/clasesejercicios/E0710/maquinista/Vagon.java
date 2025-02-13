package ud5.clasesejercicios.E0710.maquinista;

class Vagon {
    int id;
    int cargaMaxima;
    int cargaActual;
    String tipoMercancia;

    public Vagon(int id, int cargaMaxima, int cargaActual, String tipoMercancia) {
        this.id = id;
        this.cargaMaxima = cargaMaxima;
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
    }

    public Vagon(int id) {
        this(id, 1000, 0, "Variada");
    }

}
