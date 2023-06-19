package db.model;

public class Airline {

    private String airlineName;
    private String airlineCode;

    public Airline(String airlineName, String airlineCode) {
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
        return String.format("Airline[airlineName=%s,airlineCode=%s]", airlineName, airlineCode);

    }
}
