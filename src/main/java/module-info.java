module com.example.caranimation {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires junit;

    opens com.example.caranimation to javafx.fxml;
    exports com.example.caranimation;
}