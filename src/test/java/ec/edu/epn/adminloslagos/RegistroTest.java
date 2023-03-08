package ec.edu.epn.adminloslagos;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class RegistroTest {
    Registro registro;
    LectorDatos lectorDatos;
    ArrayList<Turno> turnos;
    
    public RegistroTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        registro = new Registro();
        lectorDatos = new LectorDatos();
        turnos = lectorDatos.obtenerLecturasPorTurno("src/main/java/documents/lecturas_octubre_turnos.csv");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void given_a_date_and_turns_when_totalizing_consumptions_then_ok() {
        registro.totalizarConsumosSemanales("24-10-22", turnos);
        ArrayList<Float> expectedSuper = new ArrayList(Arrays.asList(0.2F, 0.2F, 0.2F));
        ArrayList<Float> expectedExtra = new ArrayList(Arrays.asList(6.6F, 6.4F, 6.5F));
        ArrayList<Float> expectedDiesel = new ArrayList(Arrays.asList(3.3F, 3.9F, 4.5F));
        
        assertEquals(expectedSuper.toString(), registro.getConsumoSuper().toString());
        assertEquals(expectedExtra.toString(), registro.getConsumoExtra().toString());
        assertEquals(expectedDiesel.toString(), registro.getConsumoDiesel().toString());
    }
    
    @Test
    public void given_a_date_and_turns_and_inventory_when_projecting_sales_then_ok(){
        ArrayList actual = registro.proyectarVentas("24-10-22", turnos, 400.23f, 1200.23f, 704.35f);
        ArrayList expected = new ArrayList(Arrays.asList(0.0f, 5.0f, 4.0f));
        
        assertEquals(expected.toString(), actual.toString());
    }
    
    @Test
    public void given_3_lists_of_fuel_consumption_when_comparing_then_ok(){
        registro.totalizarConsumosSemanales("24-10-22", turnos);
        ArrayList<Float> expected = new ArrayList(Arrays.asList(0.5F, 6.6F, 4.5F));
        for(int i = 0; i < expected.size(); ++i) {
            assertEquals(expected.get(i), registro.obtenerMayor().get(i), 0.5f);
        }
    }
    
}
