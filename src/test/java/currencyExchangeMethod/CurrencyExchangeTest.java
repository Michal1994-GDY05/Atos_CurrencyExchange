package currencyExchangeMethod;

import currencyEnum.CurrencyEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

class CurrencyExchangeTest {

    @Test
    void shouldCurrencyExchange() throws ParserConfigurationException, IOException, SAXException {
//      given
        BigDecimal bigDecimal = CurrencyExchange.currencyExchangeCalculator(CurrencyEnum.PLN, new BigDecimal("123456789"));
//      then
        Assertions.assertEquals(new BigDecimal("565481476.3356").setScale(4, RoundingMode.HALF_UP), bigDecimal);
    }

    @Test
    void shouldNotCurrencyExchangeBadResult() throws ParserConfigurationException, IOException, SAXException {
//      given
        BigDecimal bigDecimal = CurrencyExchange.currencyExchangeCalculator(CurrencyEnum.PLN, new BigDecimal(20));
//      when
        BigDecimal bigDecimalWithFourDecimalPlaces = new BigDecimal("91").setScale(4, RoundingMode.HALF_UP);
//      then
        Assertions.assertNotEquals(bigDecimalWithFourDecimalPlaces, bigDecimal);
    }

    @Test
    void shouldReturnZeroWhenRateFieldHasNegativeValue() throws ParserConfigurationException, IOException, SAXException {
//      given
        BigDecimal bigDecimal = CurrencyExchange.currencyExchangeCalculator(CurrencyEnum.PLN, new BigDecimal(-100));
//      then
        Assertions.assertEquals(BigDecimal.ZERO, bigDecimal);

    }

    @Test
    void shouldReturnZeroWhenCurrencyOrRateFieldHasNullValue() throws ParserConfigurationException, IOException, SAXException {
//      given
        BigDecimal bigDecimal_nullInCurrency = CurrencyExchange.currencyExchangeCalculator(null, new BigDecimal(10000));
        BigDecimal bigDecimal_nullInRate = CurrencyExchange.currencyExchangeCalculator(CurrencyEnum.PLN, null);
//      then
        Assertions.assertEquals(BigDecimal.ZERO ,bigDecimal_nullInCurrency);
        Assertions.assertEquals(BigDecimal.ZERO, bigDecimal_nullInRate);
    }
}