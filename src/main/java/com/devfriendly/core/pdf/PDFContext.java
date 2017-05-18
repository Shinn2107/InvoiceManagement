package com.devfriendly.core.pdf;

import javax.xml.transform.Source;

/**
 * Created by Patrick Fey on 18.05.2017.
 */
public interface PDFContext {

    void setStylesheetForPDF(String xslFile);
    String getStylesheetForPDF();

    Source getSourceDataForPDF();
}
