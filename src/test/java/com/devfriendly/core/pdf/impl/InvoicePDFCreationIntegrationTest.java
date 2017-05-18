package com.devfriendly.core.pdf.impl;


import javax.xml.transform.TransformerFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.apache.fop.apps.FopFactory;
import org.junit.Test;

import com.devfriendly.core.invoice.data.CompanyData;
import com.devfriendly.core.invoice.data.InvoicePDFContext;
import com.devfriendly.core.invoice.data.OrderData;
import com.devfriendly.core.invoice.data.OrderItemData;
import com.devfriendly.core.invoice.data.TotalsData;
import com.devfriendly.core.pdf.PDFCreationService;
import com.devfriendly.core.pdf.data.PDFOutputData;

/**
 * Created by Patrick Fey on 18.05.2017.
 */
public class InvoicePDFCreationIntegrationTest {

    @Test
    public void createDefaultPDF() throws Exception{

        PDFCreationService pdfCreationService = PDFCreationServiceImpl.getInstance();

        InvoicePDFContext pdfInput = new InvoicePDFContext();

        pdfInput.setStylesheetForPDF("appData/pdfStyle/invoiceTemplate.xsl");

        populatePdfInput(pdfInput);

        PDFOutputData pdfOutputData = pdfCreationService.createPDF(pdfInput);


        FileOutputStream outputStream = new FileOutputStream(new File("appData/temp//pdfTest.pdf"));

        pdfOutputData.getByteArrayOutputStream().writeTo(outputStream);

        outputStream.flush();
        outputStream.close();
    }

    private void populatePdfInput(InvoicePDFContext pdfInput) {
        pdfInput.setCompanyData(createCompanyData());
        pdfInput.setIssuer(createIssuerCompanyData());
        pdfInput.setOrderData(createOrderData());
;    }

    private OrderData createOrderData() {
        OrderData orderData = new OrderData();
        orderData.setCreationTime(Calendar.getInstance().getTime().toString());
        orderData.setOrderNumber("101");
        orderData.setTotalsData(createTotalsData());
        orderData.setCustomerNumber("1");
        orderData.setOrderItems(createOrderItems());
        return orderData;
    }

    private List<OrderItemData> createOrderItems() {
        OrderItemData orderItemData = new OrderItemData();

        orderItemData.setItemPosition("1");
        orderItemData.setProductName("Gehacktes");
        orderItemData.setQuantity("100");
        orderItemData.setUnit("g");
        orderItemData.setTotalPrice("5,20 €");

        OrderItemData orderItemData2 = new OrderItemData();

        orderItemData2.setItemPosition("2");
        orderItemData2.setProductName("Haxe");
        orderItemData2.setQuantity("1");
        orderItemData2.setUnit("Stk.");
        orderItemData2.setTotalPrice("10 €");

        return Arrays.asList(orderItemData,orderItemData2);
    }

    private TotalsData createTotalsData() {
        TotalsData totalsData = new TotalsData();
        totalsData.setTax("19 %");
        totalsData.setTaxFromTotal("100 €");
        totalsData.setTotal("1000 €");
        totalsData.setTotalIncludingTax("1100");
        return totalsData;
    }

    private CompanyData createCompanyData() {
        CompanyData companyData = new CompanyData();
        companyData.setCompanyName("Schlachter Mustermann");
        companyData.setName("Herr Mustermann");
        companyData.setCity("5551112 Musterstadt2");
        companyData.setAddress("Musterstraße2 1");
        companyData.setPhoneNumber("123456");
        return companyData;
    }

    private CompanyData createIssuerCompanyData() {
        CompanyData companyData = new CompanyData();
        companyData.setCompanyName("Fleischerei Mustermann");
        companyData.setCity("123456 Musterstadt ");
        companyData.setAddress("Musterstraße 2");
        companyData.setPhoneNumber("123456");
        return companyData;
    }
}