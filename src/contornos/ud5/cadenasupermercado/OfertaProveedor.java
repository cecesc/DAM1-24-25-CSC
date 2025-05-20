package contornos.ud5.cadenasupermercado;
public class OfertaProveedor {
    private Proveedor proveedor;
    private Articulo articulo;
    private Supermercado supermercado;
    private Double pvd;
    
    public OfertaProveedor(Proveedor proveedor, Articulo articulo, Supermercado supermercado, Double pvd) {
        this.proveedor = proveedor;
        this.articulo = articulo;
        this.supermercado = supermercado;
        this.pvd = pvd;
    }

    @Override
    public String toString() {
        return "OfertaProveedor [proveedor=" + proveedor + ", articulo=" + articulo + ", supermercado=" + supermercado
                + ", pvd=" + pvd + "]";
    }

    
    
}