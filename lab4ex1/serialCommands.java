package lab4ex1;

import java.io.*;
import java.util.List;

public class serialCommands {
    public static void serializeToFile(List<Echipament> lista, String fileName){
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(fileName))){
            outputStream.writeObject(lista);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    public static List<Echipament> deserializeFromFile(String fileName){
        List<Echipament> lista = null;
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(fileName))) {
            lista = (List<Echipament>) inputStream.readObject();
        }catch(IOException | ClassNotFoundException e){
            e.printStackTrace();
        }
        return lista;
    }
}
