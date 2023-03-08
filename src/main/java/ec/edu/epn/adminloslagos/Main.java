package ec.edu.epn.adminloslagos;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author mate_
 */
public class Main {

    public static void main(String[] args) {
        
        LectorDatos lectorDatos = new LectorDatos();
        
        // Inventario
        Inventario inventario = new Inventario();
        inventario.setGalonesSuper(400.23f);
        inventario.setGalonesExtra(1200.23f);
        inventario.setGalonesDiesel(704.35f);
        
        // Turnos
        ArrayList<Turno> turnos = lectorDatos.obtenerLecturasPorTurno("src/main/java/documents/lecturas_octubre_turnos.csv");
        
        // Registro para el pedido
        Registro registro = new Registro();
        ArrayList<Float> totalGalonesPedido = registro.proyectarVentas("24-10-22", 
                turnos,inventario.getGalonesSuper(), inventario.getGalonesExtra(), 
                inventario.getGalonesDiesel());
        
        System.out.println(totalGalonesPedido.toString());
    }
}
