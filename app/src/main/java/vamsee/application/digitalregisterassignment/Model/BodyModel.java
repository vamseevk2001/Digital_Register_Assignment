package vamsee.application.digitalregisterassignment.Model;

public class BodyModel {
    private String date;
    private String time;
    private String name;
    private int pricePerItem;
    private String unit;
    private int quantity;
    private int totalPrice;
    private String typeOfTransaction;

    public BodyModel(String date, String time, String name, int pricePerItem, String unit, int quantity, int totalPrice, String typeOfTransaction) {
        this.date = date;
        this.time = time;
        this.name = name;
        this.pricePerItem = pricePerItem;
        this.unit = unit;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
        this.typeOfTransaction = typeOfTransaction;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPricePerItem() {
        return pricePerItem;
    }

    public void setPricePerItem(int pricePerItem) {
        this.pricePerItem = pricePerItem;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }
}
