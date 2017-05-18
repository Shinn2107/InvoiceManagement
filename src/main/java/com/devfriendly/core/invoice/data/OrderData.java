package com.devfriendly.core.invoice.data;

import java.util.List;
/**
 * Created by Patrick Fey on 18.05.2017.
 */
public class OrderData {

    private String creationTime;
    private String orderNumber;
    private String customerNumber;

    private List<OrderItemData> orderItems;

    private TotalsData totalsData;


    public String getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(String creationTime) {
        this.creationTime = creationTime;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(String customerNumber) {
        this.customerNumber = customerNumber;
    }

    public List<OrderItemData> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemData> orderItems) {
        this.orderItems = orderItems;
    }

    public TotalsData getTotalsData() {
        return totalsData;
    }

    public void setTotalsData(TotalsData totalsData) {
        this.totalsData = totalsData;
    }
}
