package TransDetail;

import DatabaseUtil.DBconnect;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class TransDetailController implements Initializable {
    @FXML
    TableView <TransactionDetail> DetailTable;
    @FXML
    TableColumn<TransactionDetail,Integer> TransactionIDcolumn;
    @FXML
    TableColumn<TransactionDetail,Integer> DetailID;
    @FXML
    TableColumn<TransactionDetail,String> ProductColumn;
    @FXML
    TableColumn<TransactionDetail,Integer> ItemIDColumn;
    @FXML
    TableColumn<TransactionDetail,String> ItemNameColumn;
    @FXML
    TableColumn<TransactionDetail,String> ItemBrandColumn;
    @FXML
    TableColumn<TransactionDetail,Integer> QuantityColumn;
    @FXML
    TableColumn<TransactionDetail,Integer> PriceColumn;

    private DBconnect dc;
    private ObservableList<TransactionDetail> data;
    private String sql = "SELECT transactionID, td.itemID, name,itemQTY,price from transactiondetail td RIGHT JOIN item i ON td.itemID = i.itemID WHERE transactionID = (?)";
    public void initialize(URL url, ResourceBundle rb){
        this.dc = new DBconnect();
    }

    public void loadDetailsData(){
        try{
            Connection conn = dc.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new TransactionDetail(rs.getInt(1),rs.getInt(2),rs.getString(3),rs.getInt(4),rs.getInt(5)));
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        this.TransactionIDcolumn.setCellValueFactory(new PropertyValueFactory<TransactionDetail,Integer>("transID"));

    }
}
