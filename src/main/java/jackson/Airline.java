package jackson;

import com.fasterxml.jackson.annotation.*;

//Used Json annotations
@JsonRootName("airline details")
@JsonPropertyOrder({"airlinecode", "airlinename" })
@JsonIgnoreProperties(ignoreUnknown = true)
public class Airline {
    @JsonProperty("airlinename")
    private String airlineName;

    @JsonProperty("airlinecode")
    private String airlineCode;
    @JsonCreator
    public Airline(@JsonProperty("airlinename")String airlineName,  @JsonProperty("airlinecode")String airlineCode) {
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
    }

    public Airline() {
    }

    public void setAirlineCode(String airlineCode) {
        this.airlineCode = airlineCode;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }


    public String getAirlineName() {
        return airlineName;
    }


    public String getAirlineCode() {
        return airlineCode;
    }



    @Override
    public String toString() {
        return String.format("Airline{airlineName=%s,airlineCode=%s}", airlineName, airlineCode);

    }
}
