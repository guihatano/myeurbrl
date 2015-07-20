package br.com.guihatano.myeurbrl.parser;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Stateless
public class HtmlParserService {

    public BigDecimal parseEuro() {
        Document doc;
        try {
            doc = Jsoup.connect("http://eurohoje.com/")
                    .userAgent("Mozilla")
                    .get();

            final String value = doc.getElementById("nacional").val();
            final BigDecimal euro = new BigDecimal(value.replace(",", "."));

            return euro;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BigDecimal(BigInteger.ZERO);
    }
}
