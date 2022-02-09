package vamsee.application.digitalregisterassignment.Model;

public class Transaction {
    private String date;
    private String time;
    private String name;
    private String unit;
    private int quantity;
    private int totalPrice;
    private String typeOfTransaction;

    public Transaction(String date, String time, String name, String unit, int quantity, int totalPrice, String typeOfTransaction) {
        this.date = date;
        this.time = time;
        this.name = name;
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
