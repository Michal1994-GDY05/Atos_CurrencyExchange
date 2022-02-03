package parserDom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import pojo.Currency;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class ParserXMLtoCurrencyPOJO {

    public static Map<String, BigDecimal> parseCurrencyXML() throws ParserConfigurationException, SAXException, IOException {
// Initialize a map of currency
        Map<String, BigDecimal> currencyMap = new HashMap<>();
        Currency currencyPojo = null;

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new File("currencyExchange.xml"));
        document.getDocumentElement().normalize();
        NodeList nList = document.getElementsByTagName("Cube");
        for (int temp = 2; temp < nList.getLength(); temp++)
        {
            Node node = nList.item(temp);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element eElement = (Element) node;
// Create new Currency Object
                currencyPojo = new Currency();
                currencyPojo.setCurrency(eElement.getAttribute("currency"));
                currencyPojo.setRate(new BigDecimal(eElement.getAttribute("rate")));
// Add Currency to map
                currencyMap.put(currencyPojo.getCurrency(), currencyPojo.getRate());
            }
        }
        return currencyMap;
    }
}
