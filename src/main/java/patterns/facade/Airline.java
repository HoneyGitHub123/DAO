package patterns.facade;

public class Airline {

    private String airlineName;
    private String airlineCode;

    public Airline(String airlineName, String airlineCode) {
        this.airlineName = airlineName;
        this.airlineCode = airlineCode;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public String getAirlineCode() {
        return airlineCode;
    }

}
