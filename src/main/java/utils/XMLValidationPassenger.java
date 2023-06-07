package utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLValidationPassenger {

    public static void main(String[] args) {
        String xmlPath = "src/test/passenger.xml";

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
            String passengerID = document.getElementsByTagName("passengerId").item(0).getTextContent();
            String passengerName = document.getElementsByTagName("passengername").item(0).getTextContent();
            int age = Integer.parseInt(document.getElementsByTagName("age").item(0).getTextContent());
            String mobileNum = document.getElementsByTagName("mobilenum").item(0).getTextContent();
            String dob = document.getElementsByTagName("dob").item(0).getTextContent();
            String address = document.getElementsByTagName("address").item(0).getTextContent();
            String city = document.getElementsByTagName("city").item(0).getTextContent();
            String state = document.getElementsByTagName("state").item(0).getTextContent();
            System.out.println("Passenger ID:" + passengerID);
            System.out.println("Passenger Name:" + passengerName);
            System.out.println("Mobile Number:" + mobileNum);
            System.out.println("Age:" + age);
            System.out.println("DOB:" + dob);
            System.out.println("Address" + address);
            System.out.println("City:" + city);
            System.out.println("State:" + state);
        } catch (ParserConfigurationException ex) {
            throw new RuntimeException(ex);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SAXException ex) {
            throw new RuntimeException(ex);
        }

    }


}


