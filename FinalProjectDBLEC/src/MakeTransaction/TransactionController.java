package MakeTransaction;

import DatabaseUtil.DBconnect;
import TransDetail.Transaction;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TransactionController implements Initializable {
    @FXML
    private TextField ProductInput;
    @FXML
    private TextField productQTY;
    @FXML
    private TextField CashInput;
    @FXML
    private TextField TotalPrice;
    @FXML
    private TextField ChangePrice;
    @FXML
    private Button addItemButton;

    //Table
    @FXML
    TableView<TransactionData> ItemTable;
    @FXML
    TableColumn<TransactionData,Integer> ItemIDColumn;
    @FXML
    TableColumn<TransactionData,String> ItemNameColumn;
    @FXML
    TableColumn<TransactionData,Integer> ItemPriceColumn;
    @FXML
    TableColumn<TransactionData,Integer> ItemQtyColumn;

    private DBconnect dc;
    private ObservableList<TransactionData> data;

    private String sql = "SELECT * FROM item";

    public void initialize(URL url, ResourceBundle rb){
        this.dc = new DBconnect();
        ItemTable.getSelectionModel().selectedItemProperty().addListener((old,oldSelection,newSelection) ->
        {
            if(newSelection != null){
                ProductInput.setText(newSelection.getItemName());
                TotalPrice.setText(Integer.toString(newSelection.getItemPrice()));
            }
        });
    }

    @FXML
    public void loadTransactionData(ActionEvent ev){
        loadTransactionDataFunc();
    }

    public void loadTransactionDataFunc(){
        try{
            Connection conn = DBconnect.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new TransactionData(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4) ));
            }

        }catch(SQLException e){
            e.printStackTrace();
        }
        //Diplay it to the Table
        this.ItemIDColumn.setCellValueFactory(new PropertyValueFactory<TransactionData,Integer>("itemID"));
        this.ItemNameColumn.setCellValueFactory(new PropertyValueFactory<TransactionData,String>("itemName"));
        this.ItemPriceColumn.setCellValueFactory(new PropertyValueFactory<TransactionData,Integer>("itemPrice"));
        this.ItemQtyColumn.setCellValueFactory(new PropertyValueFactory<TransactionData,Integer>("itemStock"));

        this.ItemTable.setItems(null);
        this.ItemTable.setItems(this.data);
    }

    @FXML
    public void Additem(ActionEvent ev){
//        String sql2 = "";
//        try{
//            Connection con1 = DBconnect.getConnection();
//
//        }catch(SQLException e){
//            e.printStackTrace();
//        }
        try{
        }catch(NumberFormatException e) {
            e.printStackTrace();

        }


    }

}
