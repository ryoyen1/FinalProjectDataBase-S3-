package MakeTransaction;


import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TransactionData {
    private final IntegerProperty itemID;
    private final StringProperty itemName;
    private final IntegerProperty itemPrice;
    private final IntegerProperty itemStock;

    public TransactionData (Integer itemID, String itemName, Integer itemPrice, Integer itemStock){
        this.itemID = new SimpleIntegerProperty(itemID);
        this.itemName = new SimpleStringProperty(itemName);
        this.itemPrice = new SimpleIntegerProperty(itemPrice);
        this.itemStock = new SimpleIntegerProperty(itemStock);

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

    public String getItemName() {
        return itemName.get();
    }

    public StringProperty itemNameProperty() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName.set(itemName);
    }

    public int getItemPrice() {
        return itemPrice.get();
    }

    public IntegerProperty itemPriceProperty() {
        return itemPrice;
    }

    public void setItemPrice(int itemPrice) {
        this.itemPrice.set(itemPrice);
    }

    public int getItemStock() {
        return itemStock.get();
    }

    public IntegerProperty itemStockProperty() {
        return itemStock;
    }

    public void setItemStock(int itemStock) {
        this.itemStock.set(itemStock);
    }
}
