package patterns.factory;

public class InternationalAirport extends Airport {
    public InternationalAirport() {

        this.airportCode = "LAX";
        this.airportName = "Los Angeles International Airport";
        this.cityName = "Los Angeles";
        this.stateName = "California";
        this.countryCode = "US";
    }

    @Override
    public void displayInfo() {

        System.out.println("International Airport Information");
        System.out.println("Airport Code:" + airportCode);
        System.out.println("Airport Name:" + airportName);
        System.out.println("Airport City:" + cityName);
        System.out.println("Airport State:" + stateName);
        System.out.println("Airport Country:" + countryCode);


    }
}
