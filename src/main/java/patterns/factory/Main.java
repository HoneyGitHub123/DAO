package patterns.factory;

public class Main {


    public static void main(String[] args) {

        //Create DomesticAirport using DomesticAirportFactory
        AirportFactory domesticAirportFactory = new DomesticAirportFactory();
        Airport domesticAirport = domesticAirportFactory.createAirport();
        domesticAirport.displayInfo();

        //Create InternationalAirport using InternationalAirportFactory
        AirportFactory internationalAirportFactory = new InternationalAirportFactory();
        Airport internationalAirport = internationalAirportFactory.createAirport();
        internationalAirport.displayInfo();
    }
}
