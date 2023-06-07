package utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLValidationAirport {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xmlPath = "src/test/airport.xml";
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

    public static void parseXMLWithDOM(String xmlPath) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File(xmlPath));
        String airportCode = document.getElementsByTagName("airportcode").item(0).getTextContent();
        String airportName = document.getElementsByTagName("airportname").item(0).getTextContent();
        String city = document.getElementsByTagName("city").item(0).getTextContent();
        String state = document.getElementsByTagName("state").item(0).getTextContent();
        System.out.println("Airport Code:" + airportCode);
        System.out.println("Airport Name:" + airportName);
        System.out.println("City:" + city);
        System.out.println("State:" + state);


    }


}

