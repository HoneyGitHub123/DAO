package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;


public class MainJacksonCountry {
    public static void main(String[] args) {

        Country country = new Country();
        Map<String, String> countries = country.getCountries();
        countries.put("countrycode", "CA");
        countries.put("countryname", "Canada");

        try {
            ObjectMapper objectmapper = new ObjectMapper();
            String json = objectmapper.writeValueAsString(country);
            System.out.println("Json file created:");
            System.out.println(json);
            Country country1 = objectmapper.readValue(json, Country.class);
            System.out.println("After deserialization");
            for (Map.Entry<String, String> entry : countries.entrySet()) {
                System.out.println(entry.getKey() + ":" + entry.getValue());

            }


        } catch (JsonProcessingException e) {
            e.printStackTrace();

        }
    }
}
