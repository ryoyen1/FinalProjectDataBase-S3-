package Stock;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StockData {
    private final IntegerProperty itemID;
    private final StringProperty stockname;
    private final IntegerProperty stockprice;
    private final IntegerProperty stockqty1;


    public StockData(Integer itemID, String stockname, Integer stockprice, Integer stockqty1) {
        this.itemID = new SimpleIntegerProperty(itemID);
        this.stockname = new SimpleStringProperty(stockname);
        this.stockprice = new SimpleIntegerProperty(stockprice);
        this.stockqty1 = new SimpleIntegerProperty(stockqty1);
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

    public String getStockname() {
        return stockname.get();
    }

    public StringProperty stocknameProperty() {
        return stockname;
    }

    public void setStockname(String stockname) {
        this.stockname.set(stockname);
    }

    public int getStockprice() {
        return stockprice.get();
    }

    public IntegerProperty stockpriceProperty() {
        return stockprice;
    }

    public void setStockprice(int stockprice) {
        this.stockprice.set(stockprice);
    }

    public int getStockqty1() {
        return stockqty1.get();
    }

    public IntegerProperty stockqty1Property() {
        return stockqty1;
    }

    public void setStockqty1(int stockqty1) {
        this.stockqty1.set(stockqty1);
    }
}
