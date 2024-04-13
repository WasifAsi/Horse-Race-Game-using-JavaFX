module org.example.javacoursework {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.javacoursework to javafx.fxml;
    exports org.example.javacoursework;
}