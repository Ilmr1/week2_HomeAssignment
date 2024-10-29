module org.example.week2_homeassignment {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.week2_homeassignment to javafx.fxml;
    exports org.example.week2_homeassignment;
}