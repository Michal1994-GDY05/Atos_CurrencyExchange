package currencyExchangeMethod;

import currencyEnum.CurrencyEnum;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Map;

import static parserDom.ParserXMLtoCurrencyPOJO.parseCurrencyXML;

public class CurrencyExchange {

    public static BigDecimal currencyExchangeCalculator(CurrencyEnum currency, BigDecimal rate) throws ParserConfigurationException, IOException, SAXException {
        Map<String, BigDecimal> stringBigDecimalMap = parseCurrencyXML();

        try {
            if (rate.compareTo(BigDecimal.ZERO) < 0) {
                throw new IllegalArgumentException();
            } else if (currency.toString() == null) {
                throw new NullPointerException();
            }

        } catch (IllegalArgumentException | NullPointerException e) {
            return BigDecimal.ZERO;
        }


        BigDecimal currencyValue = stringBigDecimalMap.get(currency.toString());
        return currencyValue.multiply(rate).setScale(4, RoundingMode.HALF_UP);

    }
}
