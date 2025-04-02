package contornos.ud4;

public class Pedido2 {
    public void realizarPedido(String nomeCliente, String endereco, String telefone, String produto, int cantidade) {
        System.out.println("Pedido realizado para " + nomeCliente + " de " + produto);
    }
}

class Factura {
    public void xerarFactura(String nomeCliente, String endereco, String telefone, String produto, int cantidade) {
        System.out.println("Factura xerada para " + nomeCliente + " de " + produto);
    }
}


/*

Enunciado: Varias partes del programa repiten los mismos conjuntos de datos en varios métodos o clases, cando deberían estar agrupados en una única entidad. 

Mal Cheiro: Grupo de Datos.

Solución: Crear una clase “Cliente” para agrupar los datos relacionados con el cliente.

 */