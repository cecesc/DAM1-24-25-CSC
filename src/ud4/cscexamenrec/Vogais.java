//Autor:Celia Sanmartín Chapela
package ud4.cscexamenrec;

public class Vogais {

    static String cambiaVogais(String str, char vogal) {
        String copia = str;
        int nuevoLugar;
        String[] cambioVogal = { "aeiou",
                                 "áéíóú",
                                 "AEIOU",
                                 "ÁÉÍÓÚ",
                                 "ü",
                                 "Ü" };

        nuevoLugar = cambioVogal[0].indexOf(vogal);

        for (int i = 0; i < cambioVogal.length; i++) {
            for (int j = 0; j < cambioVogal[i].length(); j++){
                if (j != nuevoLugar){
                    copia = copia.replace(cambioVogal[i].charAt(j), cambioVogal[i].charAt(nuevoLugar));
                }       
            }
        }
        return copia;
    }
}
