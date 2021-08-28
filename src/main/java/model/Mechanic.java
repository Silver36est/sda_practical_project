package model;

public class Mechanic {

    private int mechanicId;
    private String firstName;
    private String lastName;
    private String workPhone;
    private String workEmail;
    private int shopId;
    private boolean available;

    public int getMechanicId() {
        return mechanicId;
    }

    public void setMechanicId(int mechanicId) {
        this.mechanicId = mechanicId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Mechanic{" +
                "mechanicId=" + mechanicId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", workPhone='" + workPhone + '\'' +
                ", workEmail='" + workEmail + '\'' +
                ", shopId='" + shopId + '\'' +
                ", available=" + available +
                '}';
    }
}
