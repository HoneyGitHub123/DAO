package patterns.facade;

public class AirlineFacade {

    private Airline airline;

    public AirlineFacade(String airlineName, String airlineCode) {
        this.airline = new Airline(airlineName, airlineCode);
    }

    public String getAirlineInfo() {
        String details = "Airline Information:\n" +
                "Airline Name:" + airline.getAirlineName() + "\n" +
                "Airline Code:" + airline.getAirlineCode();

        return details;
    }

}
