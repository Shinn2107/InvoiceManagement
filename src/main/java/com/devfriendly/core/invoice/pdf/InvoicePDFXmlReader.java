package com.devfriendly.core.invoice.pdf;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import com.devfriendly.core.invoice.data.InvoicePDFContext;
import com.devfriendly.core.invoice.data.OrderItemData;
import com.devfriendly.core.pdf.AbstractObjectXMLReader;


/**
 * Created by Patrick Fey on 02.11.2015.
 */
public class InvoicePDFXmlReader extends AbstractObjectXMLReader {

    @Override
    public void parse(InputSource input) throws IOException, SAXException {
        if(input instanceof InvoicePDFInputSource){
            parse(((InvoicePDFInputSource)input).getInvoicePDFContext());
        }else{
            throw new SAXException("Given InputSource is not instance of FitmentPDFInputSource and therefore can't be handled");
        }
    }

    private void parse(InvoicePDFContext invoicePDFContext) throws SAXException {
        if (invoicePDFContext == null) {
            throw new NullPointerException("Parameter projectTeam must not be null");
        }
        if (handler == null) {
            throw new IllegalStateException("ContentHandler not set");
        }

        handler.startDocument();
        generateFor(invoicePDFContext);
        handler.endDocument();
    }

    private void generateFor(InvoicePDFContext invoicePDFContext) throws SAXException {
        handler.startElement("ORDER");

        generateInvoiceRecipientAddress(invoicePDFContext);
        generateInvoiceIssuer(invoicePDFContext);
        generateOrderHead(invoicePDFContext);
        generateOrderItems(invoicePDFContext);
        generateOrderTotals(invoicePDFContext);

        handler.endElement("ORDER");
    }

    private void generateOrderTotals(InvoicePDFContext invoicePDFContext) throws SAXException {
        handler.startElement("TOTALS");

        handler.element("totals",invoicePDFContext.getOrderData().getTotalsData().getTotal());
        handler.element("totalIncludingTax",invoicePDFContext.getOrderData().getTotalsData().getTotalIncludingTax());
        handler.element("taxFromTotals",invoicePDFContext.getOrderData().getTotalsData().getTaxFromTotal());
        handler.element("tax",invoicePDFContext.getOrderData().getTotalsData().getTax());

        handler.endElement("TOTALS");
    }

    private void generateOrderItems(InvoicePDFContext invoicePDFContext) throws SAXException {
        handler.startElement("DATA");
        for (OrderItemData orderItemData : invoicePDFContext.getOrderData().getOrderItems()) {
            handler.startElement("item");

            handler.element("itemPosition",orderItemData.getItemPosition());
            handler.element("productName",orderItemData.getProductName());
            handler.element("quantity",orderItemData.getQuantity());
            handler.element("unit",orderItemData.getUnit());
            handler.element("pricePerUnit",orderItemData.getPricePerUnit());
            handler.element("totalPrice",orderItemData.getTotalPrice());

            handler.endElement("item");
        }


        handler.endElement("DATA");
    }

    private void generateOrderHead(InvoicePDFContext invoicePDFContext) throws SAXException {
        handler.startElement("HEAD");
        handler.element("orderCreationDate",invoicePDFContext.getOrderData().getCreationTime());
        handler.element("orderNumber",invoicePDFContext.getOrderData().getOrderNumber());
        handler.element("customerNumber",invoicePDFContext.getOrderData().getCustomerNumber());
        handler.endElement("HEAD");
    }

    private void generateInvoiceIssuer(InvoicePDFContext invoicePDFContext) throws SAXException {
        handler.startElement("ISSUER");

        handler.element("companyName",invoicePDFContext.getIssuer().getCompanyName());
        handler.element("address",invoicePDFContext.getIssuer().getAddress());
        handler.element("city",invoicePDFContext.getIssuer().getCity());
        handler.element("phoneNumber",invoicePDFContext.getIssuer().getPhoneNumber());

        handler.endElement("ISSUER");
    }

    private void generateInvoiceRecipientAddress(InvoicePDFContext invoicePDFContext) throws SAXException {
        handler.startElement("RECIPIENT-ADDRESS");

        handler.element("companyName",invoicePDFContext.getCompanyData().getCompanyName());
        handler.element("name",invoicePDFContext.getCompanyData().getName());
        handler.element("address",invoicePDFContext.getCompanyData().getAddress());
        handler.element("city",invoicePDFContext.getCompanyData().getCity());
        handler.element("phoneNumber",invoicePDFContext.getCompanyData().getPhoneNumber());

        handler.endElement("RECIPIENT-ADDRESS");
    }

}
