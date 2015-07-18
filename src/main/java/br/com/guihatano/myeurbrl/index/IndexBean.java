package br.com.guihatano.myeurbrl.index;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class IndexBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @Inject
    private IndexFacade indexFacade;
    private BigDecimal euro;

    public void viewAction() {
        euro = indexFacade.getEuro();
    }

    public BigDecimal getEuro() {
        return euro;
    }
}
