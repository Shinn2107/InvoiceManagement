package com.devfriendly.core.invoice.pdf;

import org.xml.sax.InputSource;

import com.devfriendly.core.invoice.data.InvoicePDFContext;

/**
 * Created by Patrick Fey on 02.11.2015.
 */
public class InvoicePDFInputSource extends InputSource {

    private InvoicePDFContext invoicePDFContext;

    public InvoicePDFInputSource(InvoicePDFContext fitmentPDFData) {
        this.invoicePDFContext = fitmentPDFData;
    }

    public InvoicePDFContext getInvoicePDFContext() {
        return invoicePDFContext;
    }

    public void setInvoicePDFContext(InvoicePDFContext invoicePDFContext) {
        this.invoicePDFContext = invoicePDFContext;
    }
}
