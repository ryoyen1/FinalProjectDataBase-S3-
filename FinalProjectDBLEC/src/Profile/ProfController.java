package Profile;

import DatabaseUtil.DBconnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ProfController implements Initializable{
    @FXML
    private TextField username;
    @FXML
    private Label Fname;
    @FXML
    private Label Lname;
    @FXML
    private Label position;
    @FXML
    private Label salary;
    @FXML
    private Label Phonenum;
    @FXML
    private Text Date;
    @FXML
    private Text Month;
    @FXML
    private Text Year;

    private DBconnect dc;
    private ProfileData data;

    private String username1 = "SELECT * FROM employee";
    public void initialize(URL url, ResourceBundle rb){
        this.dc= new DBconnect();
    }

    public void initdata(ProfileData data) {
        Fname.setText(data.getFname());
        Lname.setText(data.getLname());
        position.setText(data.getPosition());

        this.data = data;
    }
    @FXML
    public void load(ProfileData data){
        Fname.setText(data.getFname());
        Lname.setText(data.getLname());
        position.setText(data.getPosition());
        salary.setText(data.getSalary());
        Phonenum.setText(data.getPhonenum());
        Date.setText(data.getDate());
    }
//        public void loadProfData () {
//            try {
//                Connection conn = DBconnect.getConnection();
//                this.data = FXCollections.observableArrayList();
//
//                ResultSet rs = conn.createStatement().executeQuery(username1);
//                while (rs.next()) {
//                    this.data.add(new ProfileData(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
//                }
//
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
////        this.username.("");
//
//
////        System.out.println(data.getFname());
//        }

        public void Back (ActionEvent event) throws IOException {
            Parent LoginParent = FXMLLoader.load(getClass().getResource("/admin/Mainpage.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("LoginPage");
            stage.setScene(new Scene(LoginParent));
            stage.show();
        }
    }


