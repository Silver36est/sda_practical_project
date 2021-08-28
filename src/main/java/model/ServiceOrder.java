package model;

import java.util.Date;

public class ServiceOrder {

    private int orderId;
    private int serviceId;
    private String notes;
    private Date startDate;
    private Date endDate;
    private int customerId;
    private int bikeId;
    private int repairShopId;
    private int mechanicId;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public int getRepairShopId() {
        return repairShopId;
    }

    public void setRepairShopId(int repairShopId) {
        this.repairShopId = repairShopId;
    }

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    @Override
    public String toString() {
        return "ServiceOrder{" +
                "orderId=" + orderId +
                ", serviceId='" + serviceId + '\'' +
                ", notes='" + notes + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", customerId='" + customerId + '\'' +
                ", bikeId='" + bikeId + '\'' +
                ", repairShop='" + repairShopId + '\'' +
                ", mechanicId=" + mechanicId +
                '}';
    }
}
