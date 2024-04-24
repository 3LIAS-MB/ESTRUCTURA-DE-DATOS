import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DeclaracionExcepcion {

    public void leerArchivo() throws FileNotFoundException, IOException {
        File archivo = new File("C:\\Users\\campo\\OneDrive\\prueba");
        FileReader fr = new FileReader(archivo);
        BufferedReader br = new BufferedReader(fr);
        
        String linea;
        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }
        
        br.close();
    }

    public void leerArchivo2() throws IOException {
        leerArchivo();
    }

    public static void main(String[] args) {
        DeclaracionExcepcion asd = new DeclaracionExcepcion();

        try {
            asd.leerArchivo2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
	