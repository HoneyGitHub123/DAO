package patterns.factory;

public class InternationalAirportFactory implements AirportFactory {
    @Override
    public Airport createAirport() {
        return new InternationalAirport();
    }
}
