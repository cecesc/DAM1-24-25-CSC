//Autor:Celia Sanmartín Chapela
package ud5.cscexamen;

import java.util.Arrays;

public class Servidor extends Host {
    Servidor[] listServicios; 
    String nombreServicio;
    int puerto;
    String protocolo;
    Object obj;

    public Servidor(String nombre, String mac, String ip) {
        super(nombre, mac, ip);
    }

    boolean addServicio(String nombreServicio, int puerto, String protocolo) {
        Servidor other = (Servidor) obj;
        if (other == null)
            return false;
        if (nombreServicio.equals(other.nombreServicio))
            return false;
        if (puerto != other.puerto)
            return true;
        if (protocolo != null) {
            if (other.protocolo != null)
                return false;
        } else if (!protocolo.equals(other.protocolo))
            return false;
        return true;
        }
    



@Override
    public String toString() {
        return nombre+" ( "+ip+ ")\n * "+ nombreServicio + " ( " +  puerto + "/" + protocolo+ ")";
    }

    public static void main(String[] args) {
        System.out.println("\nClase Servidor");
        System.out.println("==============\n");
        Servidor s1 = new Servidor("dam1", "192.168.0.117", "CC-11-22-33-44-AA");
        s1.addServicio("MySQL", 3306, "TCP");
        Servidor s2 = new Servidor("seixo", "192.168.0.11", "BB:11:22:33:44:55");
        s2.addServicio("HTTP", 80, "TCP");
        s2.addServicio("Proxy", 3128, "TCP");
        Servidor s3 = new Servidor("lapaman", "192.168.0.9", "AA:11:22:33:44:55");
        s3.addServicio("HTTP", 80, "TCP");
        s3.addServicio("Web", 80, "TCP");
        s3.addServicio("DNS", 53, "UDP");
        s3.addServicio("FTP", 21, "TCP");
        s3.addServicio("SSH", 22, "TCP");

        Servidor[] servidores = { s1, s2, s3 };
        for (Servidor s : servidores) {
            System.out.println(s);
        }

        // Tu código aquí

    }

    
}
