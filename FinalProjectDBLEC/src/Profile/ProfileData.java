package Profile;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class ProfileData {
    private final IntegerProperty ID;
    private final StringProperty Fname;
    private final StringProperty Lname;
    private final StringProperty Phonenum;
    private final StringProperty position;
    private final StringProperty date;
    private final StringProperty salary;

    public ProfileData (Integer id, String FirstName, String LastName, String Phonenumber, String pos, String dateofb, String sal) {
        this.ID = new SimpleIntegerProperty(id);
        this.Fname = new SimpleStringProperty(FirstName);
        this.Lname = new SimpleStringProperty(LastName);
        this.Phonenum = new SimpleStringProperty(Phonenumber);
        this.position = new SimpleStringProperty(pos);
        this.date = new SimpleStringProperty(dateofb);
        this.salary = new SimpleStringProperty(sal);
    }

    public int getID() {
        return ID.get();
    }

    public IntegerProperty IDProperty() {
        return ID;
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

    public StringProperty dateProperty() {
        return date;
    }

    public void setDate(String date) {
        this.date.set(date);
    }

    public String getSalary() {
        return salary.get();
    }

    public StringProperty salaryProperty() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary.set(salary);
    }
}
