package TransDetail;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TransactionDetail {
    private final IntegerProperty transID;
    private final IntegerProperty itemID;
    private final StringProperty name;
    private final IntegerProperty itemQTY;
    private final IntegerProperty priceID;

    public TransactionDetail(Integer transID, Integer itemID, String name, Integer itemQTY, Integer priceID){
        this.transID = new SimpleIntegerProperty(transID);
        this.itemID = new SimpleIntegerProperty(itemID);
        this.name = new SimpleStringProperty(name);
        this.itemQTY = new SimpleIntegerProperty(itemQTY);
        this.priceID = new SimpleIntegerProperty(priceID);
    }

    public int getTransID() {
        return transID.get();
    }

    public IntegerProperty transIDProperty() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID.set(transID);
    }

    public int getItemID() {
        return itemID.get();
    }

    public IntegerProperty itemIDProperty() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID.set(itemID);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getItemQTY() {
        return itemQTY.get();
    }

    public IntegerProperty itemQTYProperty() {
        return itemQTY;
    }

    public void setItemQTY(int itemQTY) {
        this.itemQTY.set(itemQTY);
    }

    public int getPriceID() {
        return priceID.get();
    }

    public IntegerProperty priceIDProperty() {
        return priceID;
    }

    public void setPriceID(int priceID) {
        this.priceID.set(priceID);
    }
}
