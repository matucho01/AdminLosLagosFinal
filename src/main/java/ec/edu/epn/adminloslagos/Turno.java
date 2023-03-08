package ec.edu.epn.adminloslagos;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Clase que contiene las lecturas registradas en un turno
 * @author: Bryan Tapia, Cristopher Pérez, Mateo Díaz
 * @version: 08/03/2023
 */
public class Turno {

    private String fecha;

    private double lecturaInicialSuper;
    private double lecturaInicialExtra;
    private double lecturaInicialDiesel;

    private double lecturaFinalSuper;
    private double lecturaFinalExtra;
    private double lecturaFinalDiesel;

    private int tipoTurno; // 0, 1, 2 -> mañana, tarde, noche
    
    /**
     * Constructor que recibe la fecha, las lecturas y el tipo de turno
     * @param fecha Fecha del turno
     * @param lecturaInicialSuper Lectura de Super al inicio del turno
     * @param lecturaInicialExtra Lectura de Extra al inicio del turno
     * @param lecturaInicialDiesel Lectura de Diesel al inicio del turno
     * @param lecturaFinalSuper Lectura de Super al final del turno
     * @param lecturaFinalExtra Lectura de Extra al final del turno
     * @param lecturaFinalDiesel Lectura de Diesel al final del turno
     * @param tipoTurno Entero entre 0 y 2
     */
    public Turno(String fecha, double lecturaInicialSuper, double lecturaInicialExtra,
            double lecturaInicialDiesel, double lecturaFinalSuper, double lecturaFinalExtra,
            double lecturaFinalDiesel, int tipoTurno) {
        this.fecha = fecha;
        this.lecturaInicialSuper = lecturaInicialSuper;
        this.lecturaInicialExtra = lecturaInicialExtra;
        this.lecturaInicialDiesel = lecturaInicialDiesel;
        this.lecturaFinalSuper = lecturaFinalSuper;
        this.lecturaFinalExtra = lecturaFinalExtra;
        this.lecturaFinalDiesel = lecturaFinalDiesel;
        this.tipoTurno = tipoTurno;
    }
    
    /**
     * Método para calcular las ventas en galones por cada producto: Super, Extra, Diesel
     * @return Lista de los valores vendidos por cada producto en un turno
     */
    public ArrayList<Double> calcularVentasEnGalonesPorProducto() {
        return new ArrayList<>(Arrays.asList((lecturaFinalSuper - lecturaInicialSuper), 
                (lecturaFinalExtra - lecturaInicialExtra),
                (lecturaFinalDiesel - lecturaInicialDiesel)));
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getLecturaInicialSuper() {
        return lecturaInicialSuper;
    }

    public void setLecturaInicialSuper(double lecturaInicialSuper) {
        this.lecturaInicialSuper = lecturaInicialSuper;
    }

    public double getLecturaInicialExtra() {
        return lecturaInicialExtra;
    }

    public void setLecturaInicialExtra(double lecturaInicialExtra) {
        this.lecturaInicialExtra = lecturaInicialExtra;
    }

    public double getLecturaInicialDiesel() {
        return lecturaInicialDiesel;
    }

    public void setLecturaInicialDiesel(double lecturaInicialDiesel) {
        this.lecturaInicialDiesel = lecturaInicialDiesel;
    }

    public double getLecturaFinalSuper() {
        return lecturaFinalSuper;
    }

    public void setLecturaFinalSuper(double lecturaFinalSuper) {
        this.lecturaFinalSuper = lecturaFinalSuper;
    }

    public double getLecturaFinalExtra() {
        return lecturaFinalExtra;
    }

    public void setLecturaFinalExtra(double lecturaFinalExtra) {
        this.lecturaFinalExtra = lecturaFinalExtra;
    }

    public double getLecturaFinalDiesel() {
        return lecturaFinalDiesel;
    }

    public void setLecturaFinalDiesel(double lecturaFinalDiesel) {
        this.lecturaFinalDiesel = lecturaFinalDiesel;
    }

    public int getTipoTurno() {
        return tipoTurno;
    }

    public void setTipoTurno(int tipoTurno) {
        this.tipoTurno = tipoTurno;
    }
    
    @Override
    public String toString() {
        return "Turno:" +
                "fecha: " + fecha + '\'' +
                ", lecturaInicialSuper: " + lecturaInicialSuper +
                ", lecturaInicialExtra: " + lecturaInicialExtra +
                ", lecturaInicialDiesel: " + lecturaInicialDiesel +
                ", lecturaFinalSuper: " + lecturaFinalSuper +
                ", lecturaFinalExtra: " + lecturaFinalExtra +
                ", lecturaFinalDiesel: " + lecturaFinalDiesel +
                ", turno: " + tipoTurno;
    }
}
