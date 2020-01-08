package Register;

import DatabaseUtil.DBconnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.text.SimpleDateFormat;

import javafx.stage.Stage;

import java.io.IOException;


public class RegisterController extends DBconnect {
    private DBconnect dc;
    @FXML
    private TextField Fname;
    @FXML
    private TextField Lname;
    @FXML
    private MenuButton PositionSelector;
    @FXML
    private MenuItem Manager;
    @FXML
    private MenuItem employee;
    @FXML
    private TextField PositionInput;
    @FXML
    private TextField PhoneNumInput;
    @FXML
    private TextField Date;
    @FXML
    private TextField Month;
    @FXML
    private TextField Year;
    @FXML
    private TextField Username;
    @FXML
    private PasswordField Password;
    @FXML
    private PasswordField ConfirmPass;
    @FXML
    private Label Warning;

    @FXML
    public void ManagerSelect(){
        PositionInput.setText("manager");
    }

    @FXML
    public void workerSelect(){
        PositionInput.setText("worker");
    }

    @FXML
    public void Register(ActionEvent event) throws Exception {

        String FirstName = Fname.getText();
        String LastName = Lname.getText();
        String username = Username.getText();
        String password = Password.getText();
        String Confirm = ConfirmPass.getText();
        String Position = PositionInput.getText();
        if(Confirm.equals(password)){
            Warning.setText("Password doesn't Match");
        }
        String Phone = PhoneNumInput.getText();
        String dates = Date.getText();
        String months = Month.getText();
        String years = Year.getText();
        String birthDate = years + "/" + months + "/" + dates;
//        Date date = new SimpleDateFormat("dd/MM/yyyy").parse(birthDate);
//        String dob = date.toString();


        String register = String.format("insert into employee(username, password, firstName, lastName, Position, birthDate, phoneNumber) values('%s', '%s' ,'%s' , '%s', '%s' , '%s', '%s')", username, password, FirstName, LastName,
                Position, birthDate ,Phone);
        try{
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(register);

            stnt.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Register success");
            alert.show();
            con.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        Parent LoginParent = FXMLLoader.load(getClass().getResource("/Admin/MainPage.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("MainPage");
        stage.setScene(new Scene(LoginParent));
        stage.show();
    }

    @FXML
    public void Cancel(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("/Login/Login.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("LoginPage");
        stage.setScene(new Scene(LoginParent));
        stage.show();
    }
}
