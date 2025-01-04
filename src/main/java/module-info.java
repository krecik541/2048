module org.example.ui2048 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires jdk.xml.dom;
    requires java.desktop;
    requires jdk.accessibility;


    opens org.example.ui2048 to javafx.fxml;
    exports org.example.ui2048;
}