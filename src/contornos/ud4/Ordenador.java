package contornos.ud4;

public class Ordenador {
    public double calcularDesconto(double prezo) {
        if (prezo > 100) {
            return prezo * 0.1;
        } else if (prezo > 50) {
            return prezo * 0.05;
        } else {
            return 0;
        }
    }
}

class Compra {
    public double calcularDesconto(double prezo) {
        if (prezo > 100) {
            return prezo * 0.1;
        } else if (prezo > 50) {
            return prezo * 0.05;
        } else {
            return 0;
        }
    }
}

/*
Enunciado: O código presenta duplicación en varias partes da aplicación,
o que fai que a mantención sexa difícil e propensa a erros.

Mal cheiro: Código Duplicado.

Solución: Extraer a funcionalidade común nun único método.

*/