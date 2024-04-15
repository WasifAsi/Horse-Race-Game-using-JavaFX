module org.example.javacoursework {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;


    opens Java_coursework to javafx.fxml;
    exports Java_coursework;
}