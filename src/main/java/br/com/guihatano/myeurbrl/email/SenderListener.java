package br.com.guihatano.myeurbrl.email;

import br.com.guihatano.myeurbrl.parser.HtmlParserService;
import java.math.BigDecimal;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class SenderListener {

    @Inject
    private EmailService emailService;
    @Inject
    private HtmlParserService htmlParserService;

    @Schedule(dayOfWeek = "1-5", hour = "9-17", minute = "*/10")
    public void getEuroCurrencyQuote() {

        final BigDecimal euro = htmlParserService.parseEuro();

        //hard coded just for the first release
        if (euro.compareTo(new BigDecimal("3.44")) == -1) {
            emailService.sendEmail("your-email@gmail.com", "euro", euro.toPlainString());
        }
    }
}
