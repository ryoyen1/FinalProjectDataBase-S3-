package TransDetail;

import DatabaseUtil.DBconnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class TDetailController implements Initializable {


    @FXML
    private TextField SearchInput;

    //Table column for Transaction
    @FXML
    TableView<Transaction> TransTable;
    @FXML
    TableColumn<Transaction, String> transactioncolumn;
    @FXML
    TableColumn<Transaction, Integer> TransactionIDcolumn;
    @FXML
    TableColumn<Transaction, Integer> TimeColumn;


    //Table column for Payment
    @FXML
    TableColumn<Transaction, String> PaymentMethod;


    //Table column for Employees
    @FXML
    TableColumn<Transaction, String> employeecolumn;
    @FXML
    TableColumn<Transaction, Integer> EmployeeIDcolumn;
    @FXML
    TableColumn<Transaction, String> EmployeeNameColumn;

    private ObservableList<Transaction> data;

    private DBconnect dc;
    private String sql = "SELECT transactionID,transactionTime, employeeID, firstName, paymentMethod from transaction t inner join employee e on t.employeeID = e.ID";

    public void initialize(URL url, ResourceBundle rb){
        this.dc = new DBconnect();
        TransTable.getSelectionModel().selectedItemProperty().addListener((old,oldSelection,newSelection) ->
        {
            if(newSelection != null){
                SearchInput.setText(Integer.toString(newSelection.getTransID()));
            }
        });
    }

    public void loadTranshisData(){
        try{
            Connection conn = DBconnect.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new Transaction(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5)));
            }
            this.TransactionIDcolumn.setCellValueFactory(new PropertyValueFactory<Transaction,Integer>("transID"));
            this.TimeColumn.setCellValueFactory(new PropertyValueFactory<Transaction,Integer>("transTime"));
            this.EmployeeIDcolumn.setCellValueFactory(new PropertyValueFactory<Transaction,Integer>("EmployeeID"));
            this.EmployeeNameColumn.setCellValueFactory(new PropertyValueFactory<Transaction,String>("EmployeeName"));
            this.PaymentMethod.setCellValueFactory(new PropertyValueFactory<Transaction,String>("payMethod"));

            this.TransTable.setItems(null);
            this.TransTable.setItems(this.data);

        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void Delete(){
        String sqldelete = "DELETE FROM transaction WHERE transactionID = (?)";

        try{
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(sqldelete);
            stnt.setString(1,this.SearchInput.getText());

            stnt.execute();

        }catch(SQLException e){
            e.printStackTrace();
        }
        loadTranshisData();
    }
}
