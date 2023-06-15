package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MainJacksonFlight {
    public static void main(String[] args) {

        Flight flight = new Flight();
        flight.FlightNo(300);
        flight.setFlightName("Alaskan Airlines");
        flight.setDepTime("2023-06-12 13:00:00");
        flight.setArrivalTime("2023-06-12 14:00:00");
        flight.setSource("Los Angeles");
        flight.setDestination("Oregon");
        flight.setSeat(330);

        try {
            ObjectMapper objectmapper = new ObjectMapper();
            objectmapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectmapper.writeValueAsString(flight);
            System.out.println("Json file created:");
            System.out.println(json);
            objectmapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);

            Flight deserializedFlight = objectmapper.readValue(json, Flight.class);
            System.out.println("Deserialized Flight:" + deserializedFlight);


        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
    }
}

