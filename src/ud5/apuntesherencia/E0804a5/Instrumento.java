package ud5.apuntesherencia.E0804a5;

import java.util.Arrays;

public abstract class Instrumento {
enum Nota {DO, RE, MI, FA, SOL, LA, SI}
Nota[] melodia;

public  Instrumento(){
    this.melodia= new Nota[0] ;
}

public void add(Nota nota){
    melodia = Arrays.copyOf(instrumento.melodia, instrumento.melodia.length+1);
    melodia[melodia.length - 1] = nota;
}

public void copiarMelodia(Instrumento instrumento){}


public abstract void interpretar();

public static void main(String[] args) {
    Instrumento piano = new Piano();
    piano.add(Nota.DO);
    piano.add(Nota.SOL);
    piano.add(Nota.LA);
    piano.interpretar();


    Instrumento guitarra = new Guitarra();
    guitarra.add(Nota.DO);
    guitarra.add(Nota.FA);
    guitarra.add(Nota.LA);
    guitarra.interpretar();



    Instrumento trompeta = new Trompeta();
    trompeta.copiarMelodia(piano);;
    trompeta.interpretar();


    System.out.println("ORQUESTA");
    Instrumento[] orquesta = {piano, guitarra, trompeta};
    for (Instrumento instrumento : orquesta) {
        instrumento.interpretar();
    }
}

}
