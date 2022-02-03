import currencyEnum.CurrencyEnum;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;

import static currencyExchangeMethod.CurrencyExchange.currencyExchangeCalculator;


public class Main {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        System.out.println(currencyExchangeCalculator(CurrencyEnum.NOK, new BigDecimal(10)));
    }
}
