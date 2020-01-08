package Stock;

import DatabaseUtil.DBconnect;
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

public class InsertStockController implements Initializable {
    @FXML
    public TextField ItemName;
    @FXML
    public TextField ItemPrice;
    @FXML
    public TextField ItemStock;
    @FXML
    public Button SaveButton;
    @FXML
    public Button cancelButton;

    private DBconnect dc;
    public void initialize(URL url, ResourceBundle rb ){
        this.dc = new DBconnect();
    }

    public void SaveButton(ActionEvent ev) throws IOException{

        String sqlinsert = "insert into item(name,price,stock) values(?,?,?)";
        try{


            Connection conn = DBconnect.getConnection();
            PreparedStatement stnt = conn.prepareStatement(sqlinsert);

            stnt.setString(1,this.ItemName.getText());
            stnt.setString(2,this.ItemPrice.getText());
            stnt.setString(3,this.ItemStock.getText());

            stnt.execute();
            FXMLLoader stockLoader = new FXMLLoader(getClass().getResource("/Stock/ItemStock.fxml"));
            Parent root = stockLoader.load();
            StockController stockController = stockLoader.getController();
            stockController.loadStockDataFunc();
            conn.close();



        }catch(SQLException e){
            e.printStackTrace();
        }
//     StockController stockController = new StockController();
//     stockController.loadStockData();

    }
    public void Cancel(ActionEvent ev){
        try{
            Stage stockstage = new Stage();

            FXMLLoader stockLoader = new FXMLLoader(getClass().getResource("/Stock/ItemStock.fxml"));
            Parent root = stockLoader.load();
            StockController stockController = stockLoader.getController();
            stockController.loadStockDataFunc();

            Scene scene3 = new Scene(root);

            //Profile scene
            stockstage.setScene(scene3);
            stockstage.setTitle("Profile Dashboard");
            stockstage.setResizable(false);
            stockstage.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}

