package Login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class login extends Application{

    public void start(Stage stage) throws Exception{
            Parent root = FXMLLoader.load(getClass().getResource("/Login/login.fxml"));
            stage.setTitle("LoginPage");
            stage.setScene(new Scene(root));
            stage.show();
        }
    public static void main(String[] args){
        launch(args);
    }
}
