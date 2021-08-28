package model;

import java.util.Date;

public class Billing {

    private int billingId;
    private int customerId;
    private int orderId;
    private float total;
    private Date paymentDueDate;
    private int shopId;

    public int getBillingId() {
        return billingId;
    }

    public void setBillingId(int billingId) {
        this.billingId = billingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Date getPaymentDueDate() {
        return paymentDueDate;
    }

    public void setPaymentDueDate(Date paymentDueDate) {
        this.paymentDueDate = paymentDueDate;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "Billing{" +
                "billingId=" + billingId +
                ", customerId='" + customerId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", total='" + total + '\'' +
                ", paymentDueDate='" + paymentDueDate + '\'' +
                ", shopId=" + shopId +
                '}';
    }
}
