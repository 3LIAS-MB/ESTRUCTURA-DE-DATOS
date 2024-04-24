package Datos;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import LogNegocio.Lote;
import LogNegocio.Producto;

public class PersistenciaDatos {

    private static final String ARCHIVO_PRODUCTOS = "productos.ser";
    private static final String ARCHIVO_LOTES = "lotes.ser";

    public static void guardarProductos(List<Producto> productos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PRODUCTOS))) {
            oos.writeObject(productos);
            //System.out.println("Cambios en productos guardados en la persistencia.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static List<Producto> cargarProductos() {
        File archivo = new File(ARCHIVO_PRODUCTOS);
        if (!archivo.exists()) {
            return new ArrayList<>(); // Si el archivo no existe, retorna una lista vacía
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_PRODUCTOS))) {
            return (List<Producto>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void guardarLotes(List<Lote> lotes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_LOTES))) {
            oos.writeObject(lotes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Lote> cargarLotes() {
        File archivo = new File(ARCHIVO_LOTES);
        if (!archivo.exists()) {
            return new ArrayList<>(); // Si el archivo no existe, retorna una lista vacía
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_LOTES))) {
            return (ArrayList<Lote>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }
    
    /**/
    
    /*public static List<Lote> descerializar(ArrayList<Lote> abc){
    	 try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("lotes.ser"))) {
             // Lee la lista de lotes desde el archivo "lotes.ser" y realiza la deserialización
             return abc = (ArrayList<Lote>) ois.readObject();
         } catch (Exception e) {
             e.printStackTrace();
             return abc = new ArrayList<>(); // Si hay un error, inicializa la lista vacía
         }
    }*/
    
    public static void serializarLotes(ArrayList<Lote> lotes) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVO_PRODUCTOS))) {
            oos.writeObject(lotes);
            System.out.println("Serialización completa.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para deserializar la lista de lotes desde un archivo
    public static ArrayList<Lote> deserializarLotes() {
        ArrayList<Lote> lotes;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO_PRODUCTOS))) {
            lotes = (ArrayList<Lote>) ois.readObject();
            System.out.println("Deserialización completa.");
        } catch (Exception e) {
            e.printStackTrace();
            lotes = new ArrayList<>(); // Si hay un error, inicializa la lista vacía
        }

        return lotes;
    }
    	     
}

