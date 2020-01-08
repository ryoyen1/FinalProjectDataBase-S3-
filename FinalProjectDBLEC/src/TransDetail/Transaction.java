package TransDetail;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Transaction{
    private final IntegerProperty transID;
    private final IntegerProperty transTime;
    private final IntegerProperty EmployeeID;
    private final StringProperty EmployeeName;
    private final StringProperty payMethod;

    public Transaction (Integer transID, Integer transTime, Integer EmployeeID, String EmployeeName, String payMethod){
        this.transID = new SimpleIntegerProperty(transID);
        this.transTime = new SimpleIntegerProperty(transTime);
        this.EmployeeID = new SimpleIntegerProperty(EmployeeID);
        this.EmployeeName = new SimpleStringProperty(EmployeeName);
        this.payMethod = new SimpleStringProperty(payMethod);
    }

    public int getTransID() {
        return transID.get();
    }

    public IntegerProperty transIDProperty() {
        return transID;
    }

    public void setTransID(int transID) {
        this.transID.set(transID);
    }

    public int getTransTime() {
        return transTime.get();
    }

    public IntegerProperty transTimeProperty() {
        return transTime;
    }

    public void setTransTime(int transTime) {
        this.transTime.set(transTime);
    }

    public int getEmployeeID() {
        return EmployeeID.get();
    }

    public IntegerProperty employeeIDProperty() {
        return EmployeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.EmployeeID.set(employeeID);
    }

    public String getEmployeeName() {
        return EmployeeName.get();
    }

    public StringProperty employeeNameProperty() {
        return EmployeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.EmployeeName.set(employeeName);
    }

    public String getPayMethod() {
        return payMethod.get();
    }

    public StringProperty payMethodProperty() {
        return payMethod;
    }

    public void setPayMethod(String payMethod) {
        this.payMethod.set(payMethod);
    }
}