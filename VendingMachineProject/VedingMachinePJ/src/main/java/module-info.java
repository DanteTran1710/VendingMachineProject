module com.findingcareer.vedingmachinepj {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires javafx.base;
    requires javafx.graphics;
    requires java.sql;
    
    opens com.findingcareer.vedingmachinepj to javafx.fxml;
    exports com.findingcareer.vedingmachinepj;
}
