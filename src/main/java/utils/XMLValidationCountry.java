package utils;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

public class XMLValidationCountry {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        String xmlPath = "country.xml";

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
            String countryCode = document.getElementsByTagName("countrycode").item(0).getTextContent();
            String countryName = document.getElementsByTagName("countryname").item(0).getTextContent();
            System.out.println("Country Code:" + countryCode);
            System.out.println("Country Name:" + countryName);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }


}



