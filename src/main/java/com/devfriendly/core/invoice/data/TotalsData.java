package com.devfriendly.core.invoice.data;

/**
 * Created by Patrick Fey on 18.05.2017.
 */
public class TotalsData {

    private String total;
    private String totalIncludingTax;
    private String taxFromTotal;
    private String tax;


    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getTotalIncludingTax() {
        return totalIncludingTax;
    }

    public void setTotalIncludingTax(String totalIncludingTax) {
        this.totalIncludingTax = totalIncludingTax;
    }

    public String getTaxFromTotal() {
        return taxFromTotal;
    }

    public void setTaxFromTotal(String taxFromTotal) {
        this.taxFromTotal = taxFromTotal;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }
}
