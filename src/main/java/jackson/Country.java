package jackson;


import com.fasterxml.jackson.annotation.*;

import java.util.HashMap;
import java.util.Map;

//used Json annotations
//used Map objects
public class Country {

    private Map<String, String> countries;

    public Country() {
        countries = new HashMap<>();
    }

    @JsonAnyGetter
    public Map<String, String> getCountries() {
        return countries;
    }


    @JsonAnySetter
    public void setCountries(String name, String value) {
        this.countries.put(name, value);
    }

}
