package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MainJacksonAirline {
    public static void main(String[] args) {

        Airline airline = new Airline();
        airline.setAirlineName("Qatar Airlines");
        airline.setAirlineCode("QAR");

        try {
            ObjectMapper objectmapper = new ObjectMapper();
            objectmapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectmapper.writeValueAsString(airline);
            System.out.println("Json file created:");
            System.out.println(json);
            objectmapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            Airline deserialAirline = objectmapper.readValue(json, Airline.class);
            System.out.println("Deserialized Airline:" + deserialAirline);


        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
    }
}
