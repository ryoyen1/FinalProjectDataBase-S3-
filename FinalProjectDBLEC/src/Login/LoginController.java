package Login;

import DatabaseUtil.DBconnect;
//import admin.AdminController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {
    LoginModel loginModel = new LoginModel();

    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Button loginbutton;

    private DBconnect dc;

    public void initialize(URL url, ResourceBundle rb) {
//        if(this.loginModel.isDatabaseConnected()){        //Status only
//            this
//        }
    }

    @FXML
    public void Register(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("/Register/Register.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("RegisterPage");
        stage.setScene(new Scene(LoginParent));
        stage.show();
    }
    @FXML
    public void Login(ActionEvent ev) {
        try {
            if (this.loginModel.isLogin(this.username.getText(), this.password.getText())) {
                Stage stage = (Stage) this.loginbutton.getScene().getWindow();
                stage.close();
                adminlogin();

            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Invalid");
                alert.setHeaderText("Invalid Username / Password");
                alert.setContentText("Please Re-enter the correct Credentials");
                alert.show();
            }
        } catch (Exception localException) {

        }


    }
    @FXML
    public void adminlogin(){
        try{
            //make new stages
            Stage adminstage = new Stage();

            FXMLLoader adminloader = new FXMLLoader(getClass().getResource("/admin/MainPage.fxml"));
            Parent root = adminloader.load();
//            AdminController adminController = adminloader.getController();
//            adminController.loadUserDataFunction();
            Scene scene = new Scene(root);

            //admn scene
            adminstage.setScene(scene);
            adminstage.setTitle("Admin thing");
            adminstage.setResizable(false);
            adminstage.show();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
