package patterns.factory;

public abstract class Airport {

    protected String airportCode;
    protected String airportName;
    protected String cityName;
    protected String countryCode;
    protected String stateName;


    public abstract void displayInfo();
}
