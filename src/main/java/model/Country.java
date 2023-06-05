package model;

public class Country {
    private String countryCode;
    private String countryName;

    public Country(String countryCode, String countryName) {

        this.countryCode = countryCode;
        this.countryName = countryName;

    }

    public Country() {
    }


    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public String toString() {
        return String.format("Country[countryCode=%s,countryName=%s]", countryCode, countryName);

    }

}
