package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class MainJacksonPassenger {

    public static void main(String[] args) {

        Passenger passenger = new Passenger();
        passenger.PassengerID(100);
        passenger.PassengerName("Steve");
        passenger.MobileNum("7897896543");
        passenger.setDob("1989-07-22");
        passenger.Age(35);
        passenger.setAddress("167 Park Street");
        passenger.setCity("Santa Ana");
        passenger.setState("California");
        passenger.setCountryCode("US");

        try {
            ObjectMapper objectmapper = new ObjectMapper();
            objectmapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
            String json = objectmapper.writeValueAsString(passenger);
            System.out.println("Json file created:");
            System.out.println(json);
            objectmapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
            Passenger deserialPassenger = objectmapper.readValue(json, Passenger.class);
            System.out.println("Deserialized Passenger:" + deserialPassenger);


        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
    }
}
