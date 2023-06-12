package jaxb;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

//jaxb annotations used
//List of objects used

@XmlRootElement(name = "Passengers")
public class PassengerList {


    private List<Passenger> listPassenger = new ArrayList<Passenger>();


    public List<Passenger> getListPassenger() {
        return listPassenger;
    }

    public void setListPassenger(List<Passenger> listPassenger) {
        this.listPassenger = listPassenger;

    }
}
