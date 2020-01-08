package Stock;

import DatabaseUtil.DBconnect;
import Employee.EmployeeData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class StockController implements Initializable {
    @FXML
    private TextField searchstock;
    @FXML
    private Button SearchButton;
    @FXML
    private Button EditButton;
    @FXML
    private Button InsertButton;
    @FXML
    private Button DeleteButton;
    @FXML
    private Button UpdateButton;

    //Table
    @FXML
    TableView<StockData> stocktable;

    //Columns
    @FXML
    TableColumn<StockData, Integer> Stockid;
    @FXML
    TableColumn<StockData, String> NameColumn;
    @FXML
    TableColumn<StockData, String> TypeColumn;
    @FXML
    TableColumn<StockData, Integer> PriceColumn;
    @FXML
    TableColumn<StockData, Integer> StockColumn;

    private ObservableList<StockData> data;

    private String sql = "SELECT * FROM item";

    private DBconnect dc;

    public void initialize(URL url, ResourceBundle rb) {
        this.dc = new DBconnect();
        stocktable.getSelectionModel().selectedItemProperty().addListener((old,oldSelection,newSelection) ->
        {
            if(newSelection != null){
                searchstock.setText(newSelection.getStockname());
            }
        });
    }

    public void loadStockData() {
        loadStockDataFunc();
        this.searchstock.clear();
    }

    public void loadStockDataFunc() {
        try {
            Connection conn = DBconnect.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while (rs.next()) {
                this.data.add(new StockData(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        this.Stockid.setCellValueFactory(new PropertyValueFactory<StockData, Integer>("itemID"));
        this.NameColumn.setCellValueFactory(new PropertyValueFactory<StockData, String>("stockname"));
        this.PriceColumn.setCellValueFactory(new PropertyValueFactory<StockData, Integer>("stockprice"));
        this.StockColumn.setCellValueFactory(new PropertyValueFactory<StockData, Integer>("stockqty1"));

        this.stocktable.setItems(null);
        this.stocktable.setItems(this.data);

    }


    @FXML
    public void Insert(ActionEvent ev) {
        try {
            Stage insertstage = new Stage();

            FXMLLoader InsertLoader = new FXMLLoader(getClass().getResource("/Stock/InsertItem.fxml"));
            Parent root = InsertLoader.load();
            InsertStockController InsController = InsertLoader.getController();

            Scene scene2 = new Scene(root);

            //Profile scene
            insertstage.setScene(scene2);
            insertstage.setTitle("Profile Dashboard");
            insertstage.setResizable(false);
            insertstage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
        loadStockDataFunc();
    }

    @FXML
    public void Edit(ActionEvent ev)throws IOException{
//            try {
//                Stage Editstage = new Stage();
//
//                FXMLLoader EditLoader = new FXMLLoader(getClass().getResource("/Stock/EditItem.fxml"));
//                Parent root = EditLoader.load();
//                EditStockController editController = EditLoader.getController();
//
//                Scene scene2 = new Scene(root);
//
//                //Profile scene
//                Editstage.setScene(scene2);
//                Editstage.setTitle("Profile Dashboard");
//                Editstage.setResizable(false);
//                Editstage.show();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            loadStockDataFunc();
        StockData stockData = stocktable.getSelectionModel().getSelectedItem();
        if(stockData != null){ // if choose something
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Stock/EditItem.fxml"));
            Parent EmployeePage = loader.load();
            EditStockController control = loader.getController();
            control.initdata(stockData);

            Stage stage = (Stage)((Node)ev.getSource()).getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(new Scene(EmployeePage));
            stage.setTitle("Employee");
            stage.show();
            System.out.println(stockData.getStockname());
        }else{
            System.out.println("Please Select Data!!");
        }
        }


    @FXML
    public void Search(ActionEvent ev){
        String sqlsearch = "SELECT * FROM item WHERE name = ?";
        try {
            Connection connn = dc.getConnection();
            this.data = FXCollections.observableArrayList();
            PreparedStatement stmt = connn.prepareStatement(sqlsearch);
            stmt.setString(1, this.searchstock.getText());

            stmt.execute();

            ResultSet rs = connn.createStatement().executeQuery(sqlsearch);
            while (rs.next()) {
                this.data.add(new StockData(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4)));
            }
        } catch (SQLException e) {
            System.err.println("Error" + e);
        }
        this.Stockid.setCellValueFactory(new PropertyValueFactory<StockData, Integer>("itemID"));
        this.NameColumn.setCellValueFactory(new PropertyValueFactory<StockData, String>("stockname"));
        this.PriceColumn.setCellValueFactory(new PropertyValueFactory<StockData, Integer>("stockprice"));
        this.StockColumn.setCellValueFactory(new PropertyValueFactory<StockData, Integer>("stockqty1"));

        this.stocktable.setItems(null);
        this.stocktable.setItems(this.data);

    }



    @FXML
    public void Delete(ActionEvent ev){
        String sqldelete = "DELETE FROM item WHERE name = (?)";
        try{
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(sqldelete);
            stnt.setString(1,this.searchstock.getText());

            stnt.execute();
            con.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
        loadStockDataFunc();
    }
}

