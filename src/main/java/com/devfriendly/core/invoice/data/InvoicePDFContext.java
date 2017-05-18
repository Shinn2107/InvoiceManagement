package com.devfriendly.core.invoice.data;

import javax.xml.transform.Source;
import javax.xml.transform.sax.SAXSource;

import com.devfriendly.core.invoice.pdf.InvoicePDFInputSource;
import com.devfriendly.core.invoice.pdf.InvoicePDFXmlReader;
import com.devfriendly.core.pdf.AbstractPDFContext;

/**
 * Created by Patrick Fey on 18.05.2017.
 */
public class InvoicePDFContext extends AbstractPDFContext{

    private CompanyData companyData;

    private CompanyData issuer;

    private OrderData orderData;


    @Override
    public Source getSourceDataForPDF() {
        return new SAXSource(new InvoicePDFXmlReader(), new InvoicePDFInputSource(this));

    }

    public CompanyData getCompanyData() {
        return companyData;
    }

    public void setCompanyData(CompanyData companyData) {
        this.companyData = companyData;
    }

    public CompanyData getIssuer() {
        return issuer;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public void setOrderData(OrderData orderData) {
        this.orderData = orderData;
    }



    public void setIssuer(CompanyData issuer) {
        this.issuer = issuer;
    }
}
