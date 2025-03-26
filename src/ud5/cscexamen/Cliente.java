package ud5.cscexamen;

//Autor:Celia Sanmartín Chapela
import java.util.Arrays;
import java.util.Comparator;


public class Cliente extends Host implements Comparator<Cliente> {
    enum SO {
        WINDOWS, LINUX, MAC, ANDROID, IOS
    }

    SO so;
    String resolucion;

    // Tu código aquí

    public Cliente(String nombre,String ip , String mac, SO so, String resolucion) {
        super(nombre, ip,mac);
        this.so = so;
        this.resolucion = resolucion;
    }

    public static boolean ResolucionisValid(String resolucion) {
        String[] parts = resolucion.split("x");
        if (parts.length != 2 || parts[0].isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nombre + " (" + so + " " + resolucion + ")";
    }
 
    @Override
    public int compare(Cliente o1, Cliente o2) {
        System.out.println("");
        return o1.nombre.compareTo(o2.nombre);
    }

   public static Comparator getCompNombre() {
        return new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                return ((Cliente) a).so.compareTo(((Cliente) b).so);
            }
        };
    }

    public static Comparator getCompResolu() {
        return new Comparator() {
            @Override
            public int compare(Object a, Object b) {
                return ((Cliente) a).resolucion.compareTo(((Cliente) b).resolucion);
            }
        };
    }

    
    public static void main(String[] args) {
        System.out.println("\nClase Cliente");
        System.out.println("=============\n");
        Cliente cWin1 = new Cliente("Cliente1", "192.168.1.2", "02:1A:2B:3C:4D:5E", SO.WINDOWS, "1920x1080");
        Cliente cLin2 = new Cliente("Cliente2", "192.168.1.3", "01:1A:2B:3C:4D:5F", SO.LINUX, "1366x768");
        Cliente cMac3 = new Cliente("Cliente3", "192.168.1.4", "04:1A:2B:3C:4D:60", SO.MAC, "2560x1440");
        Cliente cAnd4 = new Cliente("Cliente4", "192.168.1.5", "03:1A:2B:3C:4D:61", SO.ANDROID, "1080x2340");
        Cliente cIos5 = new Cliente("Cliente5", "192.168.1.6", "05:1A:2B:3C:4D:62", SO.IOS, "1170x2532");

        Cliente[] clientes = { cWin1, cLin2, cMac3, cAnd4, cIos5 };
        Arrays.sort(clientes);
        for (Cliente c : clientes) {
            System.out.println(c);
        }

        System.out.println("\nClientes ordenados por SO:");
        System.out.println("============================");
        Arrays.sort(clientes, getCompNombre().reversed());
        for (Cliente t : clientes) {
            System.out.println(t);
        }
        
        System.out.println("\nClientes ordenados por Resolución:");
        System.out.println("====================================");
        Arrays.sort(clientes, getCompResolu());
        for (Cliente c : clientes) {
            System.out.println(c);
        }

    }

   
   

}
