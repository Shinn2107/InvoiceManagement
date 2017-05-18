package com.devfriendly.core.pdf;

import javax.xml.transform.Source;

/**
 * Created by Patrick Fey on 18.05.2017.
 */
public abstract class AbstractPDFContext implements PDFContext {
    protected String styleSheetForPDF;

    @Override
    public void setStylesheetForPDF(String styleSheetForPDF) {
        this.styleSheetForPDF = styleSheetForPDF;
    }

    @Override
    public String getStylesheetForPDF() {
        return styleSheetForPDF;
    }

    @Override
    public abstract Source getSourceDataForPDF();
}
