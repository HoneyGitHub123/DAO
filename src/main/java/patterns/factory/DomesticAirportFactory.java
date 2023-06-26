package patterns.factory;

public class DomesticAirportFactory implements AirportFactory {

    @Override
    public Airport createAirport() {
        return new DomesticAirport();
    }
}
