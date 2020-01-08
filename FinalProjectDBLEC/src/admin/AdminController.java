package admin;

import Employee.EmployeeController;
import DatabaseUtil.DBconnect;
import MakeTransaction.TransactionController;
import Profile.ProfController;
import Profile.ProfileData;
import Stock.StockController;
import TransDetail.TDetailController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdminController implements Initializable{

    private DBconnect dc;

    public void initialize(URL url, ResourceBundle rb){
        this.dc = new DBconnect();
    }

    @FXML
    public void Employees(){
        /*Parent LoginParent = FXMLLoader.load(getClass().getResource("/Employee/employee.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Employee");
        stage.setScene(new Scene(LoginParent));
        stage.show();*/
        try{
            Stage employeestage = new Stage();

            FXMLLoader EmpLoader = new FXMLLoader(getClass().getResource("/Employee/employee.fxml"));
            Parent root = EmpLoader.load();
            EmployeeController employeeController = EmpLoader.getController();
            employeeController.loadEmpDataFunc();
            Scene scene1 = new Scene(root);

            //Employee Scene
            employeestage.setScene(scene1);
            employeestage.setTitle("Employee Dashboard");
            employeestage.setResizable(false);
            employeestage.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    @FXML
    public void Profiles(ActionEvent event) throws IOException{
//        Parent LoginParent = FXMLLoader.load(getClass().getResource("/Profile/profile.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        stage.setTitle("LoginPage");
//        stage.setScene(new Scene(LoginParent));
//        stage.show();


        try{
            Stage Profilestage = new Stage();

            FXMLLoader ProfLoader = new FXMLLoader(getClass().getResource("/Profile/profile.fxml"));
            Parent root = ProfLoader.load();
            ProfController profController = ProfLoader.getController();
            ProfileData profileData = new ProfileData(10, "alexander", "setiadi","0841247729" , "manager", "2010-04-06", "1200000");
            profController.load(profileData);
//            profController.initdata();
            Scene sceneProf = new Scene(root);

            //Profile Scene
            Profilestage.setScene(sceneProf);
            Profilestage.setResizable(false);
            Profilestage.setTitle("LoginPage");
            Profilestage.show();
        }catch (IOException e){
            e.printStackTrace();
        }



    }
    @FXML
    public void Stocks(){
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

    @FXML
    public void TransDetails() {
        try {
            Stage detailstage = new Stage();

            FXMLLoader detailLoader = new FXMLLoader(getClass().getResource("/TransDetail/TransactionHistory.fxml"));
            Parent root = detailLoader.load();
            TDetailController TDcontroller = detailLoader.getController();
            TDcontroller.loadTranshisData();

            Scene scene4 = new Scene(root);

            //Trans scene
            detailstage.setScene(scene4);
            detailstage.setResizable(false);
            detailstage.setTitle("Details History");
            detailstage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void Transaction(){
        try{
            Stage Transstage = new Stage();

            FXMLLoader transLoader = new FXMLLoader(getClass().getResource("/MakeTransaction/Transaction.fxml"));
            Parent root = transLoader.load();
            TransactionController transactionController = transLoader.getController();
            transactionController.loadTransactionDataFunc();

            Scene scene5 = new Scene(root);

            //Transaction Scene
            Transstage.setScene(scene5);
            Transstage.setTitle("Transaction Tab");
            Transstage.setResizable(false);
            Transstage.show();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    @FXML
    public void LogOut(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("/Login/login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("LoginPage");
        stage.setScene(new Scene(LoginParent));
        stage.show();
    }
}




