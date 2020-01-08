package Employee;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class EmployeeData {
    private final IntegerProperty ID;
    private final StringProperty Fname;
    private final StringProperty Lname;
    private final StringProperty Phonenum;
    private final StringProperty position;
    private final StringProperty date;
    private final StringProperty salary;
    private final StringProperty username;
    private final StringProperty password;


    public EmployeeData(Integer id, String FirstName, String LastName, String Phonenumber, String pos, String dateofb, String sal, String username, String password){
        this.ID = new SimpleIntegerProperty(id);
        this.Fname = new SimpleStringProperty(FirstName);
        this.Lname = new SimpleStringProperty(LastName);
        this.Phonenum = new SimpleStringProperty(Phonenumber);
        this.position = new SimpleStringProperty(pos);
        this.date = new SimpleStringProperty(dateofb);
        this.salary = new SimpleStringProperty(sal);
        this.username = new SimpleStringProperty(username);
        this.password = new SimpleStringProperty(password);
    }

    public IntegerProperty IDProperty() {
        return ID;
    }
    public StringProperty FnameProperty(){
        return Fname;
    }
    public StringProperty LnameProperty(){
        return Lname;
    }
    public StringProperty PhonenumProperty(){
        return Phonenum;
    }
    public StringProperty posProperty(){
        return position;
    }
    public StringProperty dateProperty(){
        return date;
    }
    public StringProperty salaryProperty(){
        return salary;
    }

    public String getUsername() {
        return username.get();
    }

    public StringProperty usernameProperty() {
        return username;
    }

    public void setUsername(String username) {
        this.username.set(username);
    }

    public String getPassword() {
        return password.get();
    }

    public StringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public int getID() {
        return ID.get();
    }

    public void setID(int ID) {
        this.ID.set(ID);
    }

    public String getFname() {
        return Fname.get();
    }

    public StringProperty fnameProperty() {
        return Fname;
    }

    public void setFname(String fname) {
        this.Fname.set(fname);
    }

    public String getLname() {
        return Lname.get();
    }

    public StringProperty lnameProperty() {
        return Lname;
    }

    public void setLname(String lname) {
        this.Lname.set(lname);
    }

    public String getPhonenum() {
        return Phonenum.get();
    }

    public StringProperty phonenumProperty() {
        return Phonenum;
    }

    public void setPhonenum(String phonenum) {
        this.Phonenum.set(phonenum);
    }

    public String getPosition() {
        return position.get();
    }

    public StringProperty positionProperty() {
        return position;
    }

    public void setPosition(String position) {
        this.position.set(position);
    }

    public String getDate() {
        return date.get();
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getSalary() {
        return salary.get();
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }

}
