package ud5.rol;
import java.util.Random;
public class Personaje2 {
    

    class Personaje {
        private String nombre;
        private int experiencia;
        private byte nivel;
        private int fuerza;
        private int agilidad;
        private int constitucion;
        private int puntosVida;
        private boolean vivo;
        private static final Random random = new Random();
    
        public Personaje(String nombre, int fuerza, int agilidad, int constitucion) {
            this.nombre = nombre;
            this.experiencia = 0;
            this.nivel = 1;
            this.fuerza = fuerza;
            this.agilidad = agilidad;
            this.constitucion = constitucion;
            this.puntosVida = constitucion + 50;
            this.vivo = true;
        }
    
        public byte sumarExperiencia(int puntos) {
            experiencia += puntos;
            byte nivelesSubidos = 0;
            while (experiencia / 1000 > nivel - 1) {
                subirNivel();
                nivelesSubidos++;
            }
            return nivelesSubidos;
        }
    
        private void subirNivel() {
            nivel++;
            fuerza *= 1.05;
            agilidad *= 1.05;
            constitucion *= 1.05;
        }
    
        public void curar() {
            int maxVida = constitucion + 50;
            if (puntosVida < maxVida) {
                puntosVida = maxVida;
            }
        }
    
        public boolean perderVida(int puntos) {
            puntosVida -= puntos;
            if (puntosVida <= 0) {
                vivo = false;
                puntosVida = 0;
            }
            return !vivo;
        }
    
        public boolean estaVivo() {
            return vivo;
        }
    
        public int atacar(Personaje enemigo) {
            int ataque = fuerza + random.nextInt(100) + 1;
            int defensa = enemigo.agilidad + random.nextInt(100) + 1;
            int daño = Math.max(0, Math.min(ataque - defensa, enemigo.puntosVida));
            enemigo.perderVida(daño);
            this.sumarExperiencia(daño);
            enemigo.sumarExperiencia(daño);
            return daño;
        }
    
        public String getNombre() {
            return nombre;
        }
    
        public int getPuntosVida() {
            return puntosVida;
        }
    
        @Override
        public String toString() {
            return String.format("%s [Nivel: %d, Exp: %d, Fuerza: %d, Agilidad: %d, Constitución: %d, Vida: %d]", 
                                 nombre, nivel, experiencia, fuerza, agilidad, constitucion, puntosVida);
        }
    }
    
    public class AppCombateSingular {
        public static void main(String[] args) {
            Personaje p1 = new Personaje("Guerrero", 120, 80, 150);
            Personaje p2 = new Personaje("Asesino", 100, 120, 100);
            
            System.out.println("Antes del combate:");
            System.out.println(p1);
            System.out.println(p2);
            
            Personaje atacante = (p1.getPuntosVida() > p2.getPuntosVida()) ? p1 : p2;
            Personaje defensor = (atacante == p1) ? p2 : p1;
            
            while (p1.estaVivo() && p2.estaVivo()) {
                System.out.printf("%s(%d) ataca a %s(%d)\n", atacante.getNombre(), atacante.getPuntosVida(), defensor.getNombre(), defensor.getPuntosVida());
                int daño = atacante.atacar(defensor);
                if (daño > 0) {
                    System.out.printf("El ataque tiene éxito! %s pierde %d puntos de vida.\n", defensor.getNombre(), daño);
                } else {
                    System.out.printf("%s esquiva el ataque!\n", defensor.getNombre());
                }
                if (!defensor.estaVivo()) {
                    System.out.printf("%s ha muerto! Fin del combate.\n", defensor.getNombre());
                    break;
                }
                Personaje temp = atacante;
                atacante = defensor;
                defensor = temp;
            }
            
            System.out.println("Después del combate:");
            System.out.println(p1);
            System.out.println(p2);
        }
    }
    
}
