package ud5.clasesejercicios.E0710.maquinista;

import ud5.clasesejercicios.E0710.personal.Maquinista;

public class Tren {
    static final byte MAX_VAGONES = 5;
    Locomotora locomotora;
    Vagon[] vagones;
    Maquinista maquinista;


    public Tren(Locomotora locomotora,  Maquinista maquinista) {
        this(locomotora, maquinista,0);
    }

    //Otra forma
    public Tren(Locomotora locomotora,  Maquinista maquinista int numVagones) {
        if (numVagones > MAX_VAGONES){
            throw 
        }
        this.locomotora = locomotora;
        this.maquinista = maquinista;
        vagones = new Vagon[numvagones];
        for (int i = 0; i < numVagones; i++) {
            vagones[i] = new Vagon(i);
            
        }
    }
    

}
