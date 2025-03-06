package ud5.clasesejercicios;


public class ColaDoble extends Cola {

    public void encolarPrincipio(Integer e) {
        insertarInicio(e);  // Lo insertamos al principio
    }

    public Integer desencolarFinal() {
        return eliminarEn(length() - 1);  // Eliminamos el último
    }
}
