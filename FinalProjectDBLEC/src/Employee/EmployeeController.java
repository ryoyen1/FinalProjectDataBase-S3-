package Employee;

import DatabaseUtil.DBconnect;
import Employee.EmployeeController;
import javafx.beans.property.Property;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EmployeeController {
    @FXML
    private TextField employeeNameInput;
    @FXML
    private TableView<EmployeeData> empdata;

    //Columns in the table
    @FXML
    private TableColumn<EmployeeData, Integer> IDcolumn;
    @FXML
    private TableColumn<EmployeeData, String> FnameColumn;
    @FXML
    private TableColumn<EmployeeData, String> LnameColumn;
    @FXML
    private TableColumn<EmployeeData, String> PhoneNumColumn;
    @FXML
    private TableColumn<EmployeeData, String> PositionColumn;
    @FXML
    private TableColumn<EmployeeData, String> BirthDateColumn;
    @FXML
    private TableColumn<EmployeeData, String> SalaryColumn;

    @FXML
    private Button SearchButton;

    private DBconnect dc;
    private ObservableList<EmployeeData> data;

    private String sql = "SELECT * FROM employee e join position p on e.Position = p.Position_Name";

    public void initialize(URL url, ResourceBundle rb){
        this.dc = new DBconnect();
//        empdata.getSelectionModel().selectedItemProperty().addListener((old, oldSelection, newSelection) ->
//        {
//            if(newSelection != null){
//
//            }
//        });
    }
    @FXML
    private void loadEmpData(ActionEvent event){
        loadEmpDataFunc();
    }



    public void loadEmpDataFunc(){
        try{
            Connection conn = DBconnect.getConnection();
            this.data = FXCollections.observableArrayList();

            ResultSet rs = conn.createStatement().executeQuery(sql);
            while(rs.next()){
                this.data.add(new EmployeeData(rs.getInt(1),rs.getString(4),rs.getString(5),rs.getString(8),rs.getString(6),rs.getString(7),rs.getString(10),rs.getString(2),rs.getString(3)));
            }
        }catch(SQLException e){
            System.err.println("Error" + e);
        }
        this.IDcolumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, Integer>("ID"));
        this.FnameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("Fname"));
        this.LnameColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("Lname"));
        this.PhoneNumColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("Phonenum"));
        this.PositionColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("position"));
        this.BirthDateColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("date"));
        this.SalaryColumn.setCellValueFactory(new PropertyValueFactory<EmployeeData, String>("salary"));

        this.empdata.setItems(null);
        this.empdata.setItems(this.data);
    }
    @FXML
    public void Search(ActionEvent ev){
        String sqlsearch = "SELECT FirstName FROM employee WHERE FirstName = ?";
        try{
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(sqlsearch);
            stnt.setString(1,this.employeeNameInput.getText());

            stnt.execute();
            con.close();

            this.employeeNameInput.clear();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    @FXML
    public void Back(ActionEvent event) throws IOException {
        Parent LoginParent = FXMLLoader.load(getClass().getResource("/admin/MainPage.fxml"));
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Page");
        stage.setScene(new Scene(LoginParent));
        stage.show();
    }

    @FXML
    public void Delete() {
        EmployeeData employee = empdata.getSelectionModel().getSelectedItem();

        String delete = "DELETE from employee where ID = ?";
        try{
            Connection con = dc.getConnection();
            PreparedStatement stnt = con.prepareStatement(delete);
            stnt.setInt(1,employee.getID());

            stnt.execute();
            con.close();

        }catch(SQLException e){
            e.printStackTrace();
        }
//        if (employee == null) {
//            Alert alert = new Alert(Alert.AlertType.WARNING);
//            alert.setTitle("Warning!!!");
//            alert.setHeaderText("Please Select an employee");
//            alert.show();
//        } else {
//            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//            alert.setTitle("Confirmation");
//            alert.setHeaderText("Are you sure want to delete this employee");
//            alert.show();
//        }
    }

    @FXML
    public void Edit(ActionEvent event)throws IOException{
        EmployeeData employee = empdata.getSelectionModel().getSelectedItem();
        if(employee != null){ // if choose something
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/Employee/editEmployee.fxml"));
            Parent EmployeePage = loader.load();
            editEmployeeController control = loader.getController();
            control.initdata(employee);

            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(new Scene(EmployeePage));
            stage.setTitle("Employee");
            stage.show();
            System.out.println(employee.getUsername());
        }else{
            System.out.println("Please Select Data!!");
        }
    }

}
