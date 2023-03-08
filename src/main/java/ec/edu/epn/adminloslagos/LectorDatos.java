package ec.edu.epn.adminloslagos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class LectorDatos {

    /**
     * 
     * @param path Path del archivo de lecturas de turnos
     * @return Array List de lecturas separado por turnos
     */
    public ArrayList obtenerLecturasPorTurno(String path) {
        ArrayList turnos = new ArrayList<Turno>();
        String line = "";
        String splitBy = ",";
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(splitBy);
                turnos.add(new Turno(datos[0], parseDouble(datos[1]), parseDouble(datos[2]), parseDouble(datos[3]),
                        parseDouble(datos[4]), parseDouble(datos[5]), parseDouble(datos[6]), parseInt(datos[7])));
            }
        } catch (IOException e) {
            System.out.println("No se encuentra el archivo de lecturas: " + e);
        }
        return turnos;
    }

    /**
     * 
     * @param dato String del número double
     * @return El número como tipo de dato double
     */
    public double parseDouble(String dato) {
        return Double.parseDouble(dato);
    }
    /**
     * 
     * @param dato String del número entero
     * @return El número como tipo de dato int
     */
    public int parseInt(String dato) {
        return Integer.parseInt(dato);
    }
}
