package br.com.guihatano.myeurbrl.index;

import br.com.guihatano.myeurbrl.email.EmailService;
import br.com.guihatano.myeurbrl.parser.HtmlParserService;
import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class IndexService {

    @Inject
    private EmailService emailService;
    @Inject
    private HtmlParserService htmlParserService;

    public BigDecimal getEuroQuotation() {

        final BigDecimal euro = htmlParserService.parseEuro();

        //hard coded just for a first release
        if (euro.compareTo(new BigDecimal("3.44")) == -1) {
            emailService.sendEmail("your-email@gmail.com", "euro", euro.toPlainString());
        }
        return euro;
    }
}
