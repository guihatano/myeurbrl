package br.com.guihatano.myeurbrl.index;

import br.com.guihatano.myeurbrl.email.EmailService;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import javax.ejb.Stateless;
import javax.inject.Inject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

@Stateless
public class IndexService {

    @Inject
    private EmailService emailService;

    public BigDecimal getEuroQuotation() {
        Document doc;
        try {
            doc = Jsoup.connect("http://eurohoje.com/")
                    .userAgent("Mozilla")
                    .get();

            final String value = doc.getElementById("nacional").val();
            final BigDecimal euro = new BigDecimal(value.replace(",", "."));

            //hard coded just for a first release
            if (euro.compareTo(new BigDecimal("3.44")) == -1) {
                emailService.sendEmail("your-email@gmail.com", "euro", euro.toPlainString());
            }
            return euro;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new BigDecimal(BigInteger.ZERO);
    }
}
