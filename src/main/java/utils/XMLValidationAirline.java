package utils;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLValidationAirline {

    public static void main(String[] args) {
        String xmlPath = "src/test/airline.xml";

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
            NodeList list = document.getElementsByTagName("airlinename");
            for (int i = 0; i < list.getLength(); i++) {
                Node a = list.item(i);
                String airlineName = a.getTextContent();
                System.out.println("Airline Name:" + airlineName);

            }

            NodeList list1 = document.getElementsByTagName("airlinecode");
            for (int i = 0; i < list1.getLength(); i++) {
                Node a1 = list1.item(i);
                String airlineCode = a1.getTextContent();
                System.out.println("Airline Code:" + airlineCode);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}

