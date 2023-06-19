package db.model;

public class Airport {

    private String airportCode;
    private String airportName;
    private String cityName;
    private String countryCode;
    private String stateName;

    public Airport(String airportCode, String airportName, String cityName, String countryCode, String stateName) {
        this.airportCode = airportCode;
        this.airportName = airportName;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.stateName = stateName;
    }

    public Airport() {
    }

    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public void setCityNameCode(String cityName) {
        this.cityName = cityName;

    }

    public String getAirportCode() {
        return airportCode;
    }

    public String getCityName() {
        return cityName;
    }

    public String getStateName() {
        return stateName;
    }

    public String getAirportName() {
        return airportName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    @Override
    public String toString() {
        return String.format("Airport[airportCode=%s,airportName=%s,cityName=%S,stateName=%s]", airportCode, airportName, cityName, stateName);

    }
}


