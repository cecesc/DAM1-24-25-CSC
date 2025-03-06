package ud5.mulleres;

abstract class MullerTraballadora{
String nome;
String apelidos;
int anoNacemento;
final int anoActual = 2025;

public MullerTraballadora(String nome, String
apelidos, int anoNacemento) {
        this.nome = nome;
        this.apelidos = apelidos;
        this.anoNacemento = anoNacemento;
    }

public abstract String descricionContribucion();

public int getIdade(int anoActual){
    int idade = anoActual - anoNacemento;
    return idade;
    }

public static void main(String[] args){
    //Instanciacion de mulleres destacadas
    Cientifica marieCurie = new Cientifica("Marie","Curie", 1867, "Descubriu o radio e
o polonio");
 Artista fridaKahlo = new Artista("Frida", "Kahlo", 1907, "Surrealismo e pintura
autobiográfica");
 Politica rosaParks = new Politica("Rosa", "Parks", 1913, "Loita polos dereitos civís
e contra a segregación racial");
 Cientifica adaLovelace = new Cientifica("Ada", "Lovelace", 1815, "Primeira
programadora da historia");
 // Array de Mulleres Traballadoras Destacadas
 MullerTraballadora[] mulleres = {marieCurie, fridaKahlo, rosaParks, adaLovelace};
}


}