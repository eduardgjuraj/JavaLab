package exJSONtesting;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class main {

    static void scriere(List<PerecheNumere> lista){
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writeValue(new File("perechi.json"), lista);
        } catch(IOException e){
            e.printStackTrace();
        }
    }

    static List<PerecheNumere> citire(){
        try{
            ObjectMapper mapper = new ObjectMapper();
            File file = new File("perechi.json");
            List<PerecheNumere> persoane = mapper.readValue(file, new TypeReference<List<PerecheNumere>>() {});
                    return persoane;
        } catch(IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        List<PerecheNumere> perecheNumere = new ArrayList<>();
        perecheNumere.add(new PerecheNumere(1,1 ));
        perecheNumere.add(new PerecheNumere(9,11 ));
        perecheNumere.add(new PerecheNumere(5,7 ));
        for(PerecheNumere p : perecheNumere)
            System.out.println(p.sumCifreEgale(p.getA(),p.getB()));

    }
}
