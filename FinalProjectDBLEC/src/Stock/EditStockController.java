package Stock;

import DatabaseUtil.DBconnect;
import Employee.EmployeeData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditStockController implements Initializable {
    private DBconnect dc;
    private StockData stock;
    @FXML
    private TextField ItemName;

    @FXML
    private TextField ItemPrice;

    @FXML
    private TextField ItemStock;


    public void initialize(URL url, ResourceBundle rb){
        this.dc = new DBconnect();

    }

    @FXML
    public void initdata(StockData stock) {
        ItemName.setText(stock.getStockname());
        String Price = Integer.toString(stock.getStockprice());
        ItemPrice.setText(Price);
        String quantity = Integer.toString(stock.getStockqty1());
        ItemStock.setText(quantity);
        this.stock = stock;
    }

    @FXML
    public void Cancel(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("/Stock/ItemStock.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Page");
        stage.setScene(new Scene(LoginParent));
        stage.show();
    }

    @FXML
    public void Save() {
//        String name = ItemName.getText();
//        String price = ItemPrice.getText();
//        Integer prices = Integer.parseInt(price);
//        String qty = ItemStock.getText();
//        Integer quantity = Integer.parseInt(qty);
//
//        updatename(stock.getItemID(), name);
//        updateprice(stock.getItemID(), prices);
//        updatestock(stock.getItemID() , quantity);
        try{
            String update = "UPDATE item SET name = '" + ItemName.getText() + "', price = '" + ItemPrice.getText() + "', stock = '" + ItemStock.getText() + "' WHERE name = '" + ItemName.getText() + "'";
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(update);


            stnt.execute();
            con.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void updatename(int ID, String name) {
        String updatenames = String.format("update item SET %h where name = '%s'", ID, name);
        try {
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(updatenames);
            stnt.execute();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
//        try{
//            String update = "UPDATE item SET name = '" + ItemName.getText() + "', price = '" + ItemPrice.getText() + "', stock = '" + ItemStock.getText() + "' WHERE name = '" + ItemName.getText() + "'";
//            Connection con = dc.getConnection();
//            PreparedStatement stnt = con.prepareStatement(update);
//
//
//            stnt.execute();
//            con.close();
//
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
    }

    public void updateprice(int ID, int price) {
        String updateprices = String.format("update item set %h where price = '%s'", ID, price);
        try {
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(updateprices);
            stnt.execute();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatestock(int ID, int stock) {
        String updatestocks = String.format("UPDATE item set %h where stock = '%s'", ID, stock);
        try {
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(updatestocks);
            stnt.execute();
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
