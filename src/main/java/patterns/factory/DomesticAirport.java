package patterns.factory;

public class DomesticAirport extends Airport {


    public DomesticAirport() {
        this.airportCode = "SMX";
        this.airportName = "Santa Maria Airport";
        this.cityName = "Santa Barbara";
        this.stateName = "California";
        this.countryCode = "US";
    }

    @Override
    public void displayInfo() {

        System.out.println("Domestic Airport Information");
        System.out.println("Airport Code:" + airportCode);
        System.out.println("Airport Name:" + airportName);
        System.out.println("Airport City:" + cityName);
        System.out.println("Airport State:" + stateName);
        System.out.println("Airport Country:" + countryCode);


    }
}
