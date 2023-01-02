module hagenmcgowan.coursework.studentmanagementservice {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.opencsv;
    requires java.desktop;

    opens hagenmcgowan.coursework.studentmanagementservice to javafx.fxml;
    exports hagenmcgowan.coursework.studentmanagementservice;
}