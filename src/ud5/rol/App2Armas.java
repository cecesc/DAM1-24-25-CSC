package ud5.rol;

import ud5.rol.Personaje.raza;

public class App2Armas {
    public static void main(String[] args) {
        System.out.println("2. Armas y Armaduras");
        System.out.println("====================");

        PersonajeEx valkiria = new PersonajeEx("Valkiria", raza.HUMANO);
        PersonajeEx arturo = new PersonajeEx("Arturo", raza.HUMANO);

        Armadura yelmoHierro = new Armadura("Yelmo de hierro", 1.5, 50, Armadura.Tipo.YELMO);
        yelmoHierro.setDefensa(5);

        Armadura cotaMalla = new Armadura("Cota de Malla", 10.0, 2000, Armadura.Tipo.ARMADURA);
        cotaMalla.setDefensa(20);

        Arma espadaLarga = new Arma("Espada larga", 3.0, 10000, 60, false);
        Armadura escudoMadera = new Armadura("Escudo de madera", 2.0, 50, Armadura.Tipo.ESCUDO);
        escudoMadera.setDefensa(10);

        Armadura yelmoPlata = new Armadura("Yelmo de plata", 1.0, 100, Armadura.Tipo.YELMO);
        yelmoPlata.setDefensa(5);

        Armadura coraza = new Armadura("Coraza", 12.0, 3000, Armadura.Tipo.ARMADURA);
        coraza.setDefensa(30);

        Arma espadon = new Arma("Espadón a dos manos", 5.0, 1000, 50, true);

        valkiria.equipar(yelmoHierro);
        valkiria.equipar(cotaMalla);
        valkiria.equipar(espadaLarga);
        valkiria.equipar(escudoMadera);

        arturo.equipar(yelmoPlata);
        arturo.equipar(coraza);
        arturo.equipar(espadon);

        System.out.println("Equipo de combate de Valkiria:");
        valkiria.mostrarEquipo();
        System.out.println();

        System.out.println("Equipo de combate de Arturo:");
        arturo.mostrarEquipo();
        System.out.println();
    }
}
