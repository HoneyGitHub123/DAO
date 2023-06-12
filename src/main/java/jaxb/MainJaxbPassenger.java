package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainJaxbPassenger {
    public static void main(String[] args) throws JAXBException {

        List<Passenger> listPassenger = new ArrayList<Passenger>();
        listPassenger.add(new Passenger(201, "Lokesh Gupta", "5678909932", 36, "1988-05-22", "1678 Nelson Street", "West Covina", "California", "US"));
        listPassenger.add(new Passenger(202, "Mike John", "5678999932", 35, "1989-07-22", "167 Park Street", "Santa Ana", "California", "US"));
        PassengerList passengerList = new PassengerList();
        passengerList.setListPassenger(listPassenger);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PassengerList.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            File file = new File("src\\main\\java\\resources\\passenger.xml");
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(passengerList, file);
            marshaller.marshal(passengerList, System.out);
        } catch (JAXBException e) {

            e.printStackTrace();
        }


        try {
            File file = new File("src\\main\\java\\resources\\passenger.xml");
            JAXBContext jabxbContent = JAXBContext.newInstance(PassengerList.class);
            Unmarshaller unmarshaller = jabxbContent.createUnmarshaller();
            PassengerList psgLst = (PassengerList) unmarshaller.unmarshal(file);
            for (Passenger p : psgLst.getListPassenger()) {
                System.out.println("Passenger Details");
                System.out.println("=======================");
                System.out.println("PassengerID: " + p.getPassengerID());
                System.out.println("Passenger Name: " + p.getPassengerName());
                System.out.println("Mobile Number: " + p.getMobileNum());
                System.out.println("Age: " + p.getAge());
                System.out.println("DOB: " + p.getDob());
                System.out.println("Address: " + p.getAddress());
                System.out.println("City: " + p.getCity());
                System.out.println("State: " + p.getState());
                System.out.println("Country: " + p.getCountryCode());
            }

        } catch (JAXBException e) {
            e.printStackTrace();


        }
    }
}





