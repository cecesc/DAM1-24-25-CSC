package ud5.clasesejercicios.E0710;

import java.time.LocalDate;

import ud5.clasesejercicios.E0710.maquinista.Locomotora;
import ud5.clasesejercicios.E0710.maquinista.Tren;
import ud5.clasesejercicios.E0710.personal.JefeEstacion;
import ud5.clasesejercicios.E0710.personal.Maquinista;
import ud5.clasesejercicios.E0710.personal.Mecanico;

public class App {
public static void main(String[] args) {
    Maquinista maquinista= new Maquinista("Maria", "555555555J", 10000, "A");
    System.out.println(maquinista);

    Mecanico mecanico= new Mecanico("Pepe", "999999999", Mecanico.Especialidad.MOTOR);
       System.out.println(mecanico);


    JefeEstacion jefe = new JefeEstacion("Vanesa", "555555555J", LocalDate.of(2020, 2, 20));
        System.out.println(jefe);

    //Vagón solo es visible para clases vecinas

    Locomotora locomotora = new Locomotora("8448JFM", 50000, 2002, mecanico);
    System.out.println(locomotora);

    Tren tren = new Tren(locomotora, null, maquinista);
        System.out.println(tren);

}
}
