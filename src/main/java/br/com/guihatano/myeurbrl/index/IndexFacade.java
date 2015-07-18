package br.com.guihatano.myeurbrl.index;

import java.math.BigDecimal;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class IndexFacade {

    @Inject
    private IndexService indexService;

    public BigDecimal getEuro() {
        return indexService.getEuroQuotation();
    }
}
