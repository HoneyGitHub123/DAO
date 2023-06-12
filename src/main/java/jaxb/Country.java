package jaxb;


import javax.xml.bind.annotation.*;


//jaxb annotations used
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="Country")
public class Country {

    @XmlAttribute
    private String countrycode;
    @XmlElement
    private String countryname;

    public Country(String countrycode, String countryname) {

        this.countrycode = countrycode;
        this.countryname = countryname;

    }

    public Country() {
    }

    public void setCountryCode(String countrycode) {
        this.countrycode = countrycode;
    }

    public String getCountryCode() {
        return countrycode;
    }


    public void setCountryName(String countryname) {
        this.countryname = countryname;
    }


    public String getCountryName() {
        return countryname;
    }

    @Override
    public String toString() {
        return String.format("Country[countrycode=%s,countryname=%s]", countrycode, countryname);

    }

}
