module com.example.weatherapi {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires java.net.http;
    requires java.desktop;
    requires com.google.gson;

    opens com.example.weatherapi to javafx.fxml, com.google.gson; // <- Added com.google.gson here

    exports com.example.weatherapi;
}
