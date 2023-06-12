package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class MainJaxbCountry {

    public static void main(String[] args) {

        try {
            Country country = new Country();
            country.setCountryCode("NP");
            country.setCountryName("Nepal");
            JAXBContext jaxbContext = JAXBContext.newInstance(Country.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            File file = new File("src\\main\\java\\resources\\country.xml");
            marshaller.marshal(country, file);
            marshaller.marshal(country, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            File file = new File("src\\main\\java\\resources\\country.xml");
            JAXBContext jabxbContent = JAXBContext.newInstance(Country.class);
            Unmarshaller unmarshaller = jabxbContent.createUnmarshaller();
            Country country = (Country) unmarshaller.unmarshal(file);
            System.out.println(country.getCountryName());
            System.out.println(country.getCountryCode());

        } catch (JAXBException e) {
            e.printStackTrace();


        }
    }
}

