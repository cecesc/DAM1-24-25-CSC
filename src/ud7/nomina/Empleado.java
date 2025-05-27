package ud7.nomina;

import java.io.Serializable;

public class Empleado implements Serializable{

            public enum TipoCargo{
                DIRECTIVO, ESTRATEGICO, OPERATIVO
            }
        
            public enum TipoGenero{
                MASCULINO, FEMENINO    
            }
            
            private String nombre;
            private String apellidos;
            private double salarioDía;
            private double otrosIngresos;
            private double pagosSalud;
            private double aportePensiones;
            private int díasTrabajados;
            private TipoCargo cargo;
            private TipoGenero genero;
        
            public Empleado(String nombre, String apellidos, TipoCargo cargo,
                            TipoGenero genero, double salarioDía, int díasTrabajados,
                            double otrosIngresos, double pagosSalud,
                            double aportePensiones) {
                this.nombre = nombre;
                this.apellidos = apellidos;
                this.cargo = cargo;
                this.genero = genero;
                this.salarioDía = salarioDía;
                this.díasTrabajados = díasTrabajados;
                this.otrosIngresos = otrosIngresos;
                this.pagosSalud = pagosSalud;
                this.aportePensiones = aportePensiones;
            }
        
            public String getNombre() {
                return nombre;
            }
        
            public String getApellidos() {
                return apellidos;
            }
        
            public TipoCargo getCargo() {
                return cargo;
            }
        
            public TipoGenero getGénero() {
                return genero;
            }
        
            public double getSalarioDía() {
                return salarioDía;
            }
        
            public int getDíasTrabajados() {
                return díasTrabajados;
            }
        
            public double getOtrosIngresos() {
                return otrosIngresos;
            }
        
            public double getPagosSalud() {
                return pagosSalud;
            }
        
            public double getAportePensiones() {
                return aportePensiones;
            }
        
            public double calcularNómina() {
                return ((salarioDía * díasTrabajados) + otrosIngresos - pagosSalud - aportePensiones);
            }
        }