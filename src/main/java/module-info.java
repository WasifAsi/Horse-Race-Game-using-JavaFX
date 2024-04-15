module org.example.javacoursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens org.example.javacoursework to javafx.fxml;
    exports org.example.javacoursework;
}