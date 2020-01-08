module FinalProjectDB.S3 {
    requires javafx.fxml;
    requires javafx.controls;
    requires javafx.graphics;
    requires java.sql;

    exports Login;
    opens Login to javafx.fxml;

    exports admin;
    opens admin to javafx.fxml;

    exports Profile;
    opens Profile to javafx.fxml;

    exports Employee;
    opens Employee to javafx.fxml;

    exports Stock;
    opens Stock to javafx.fxml;

    exports Register;
    opens Register to javafx.fxml;

    exports TransDetail;
    opens TransDetail to javafx.fxml;

    exports MakeTransaction;
    opens MakeTransaction to javafx.fxml;
}