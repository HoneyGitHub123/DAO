package utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLValidationFlight {

    public static void main(String[] args) {
        String xmlPath = "src/test/flight.xml";

        boolean isValid = validateSchema(xmlPath);
        System.out.println("Validated XML Schema:" + isValid);

        if (isValid) {
            parseXMLWithDOM(xmlPath);
        }
    }

    public static boolean validateSchema(String xmlPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setNamespaceAware(true);
            factory.setFeature("http://apache.org/xml/features/validation/schema", true);
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.setErrorHandler(null);
            builder.parse(xmlPath);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void parseXMLWithDOM(String xmlPath) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(new File(xmlPath));
            String flightNum = document.getElementsByTagName("flightno").item(0).getTextContent();
            String flightName = document.getElementsByTagName("flightname").item(0).getTextContent();
            String departure = document.getElementsByTagName("departure").item(0).getTextContent();
            String arrival = document.getElementsByTagName("arrival").item(0).getTextContent();
            String source = document.getElementsByTagName("source").item(0).getTextContent();
            String destination = document.getElementsByTagName("destination").item(0).getTextContent();
            String seats = document.getElementsByTagName("seats").item(0).getTextContent();
            System.out.println("Flight Number:" + flightNum);
            System.out.println("Flight Name:" + flightName);
            System.out.println("Departure Time:" + departure);
            System.out.println("Arrival Time:" + arrival);
            System.out.println("Starting Place:" + source);
            System.out.println("Ending Place:" + destination);
            System.out.println("Seats Available:" + seats);
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        }

    }


}




