package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MainJacksonAirport {
    public static void main(String[] args) {

        Airport airport = new Airport();
        airport.setAirportName("JohnF.Kennedy International Airport");
        airport.setAirportCode("JFK");
        airport.setCityNameCode("Queens");
        airport.setStateName("Newyork");
        airport.setCountryCode("US");

        try {
            ObjectMapper objectmapper = new ObjectMapper();
            objectmapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectmapper.writeValueAsString(airport);
            System.out.println("Json file created:");
            System.out.println(json);
            objectmapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            Airport deserializedAirport = objectmapper.readValue(json, Airport.class);
            System.out.println("Deserialized Airport:" + deserializedAirport);


        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
    }
}


