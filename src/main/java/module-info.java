module edu.stud.ntnu.idatt2003_oblig3 {
  requires javafx.controls;
  requires javafx.fxml;


  opens edu.stud.ntnu.idatt2003_oblig3 to javafx.fxml;
  exports edu.stud.ntnu.idatt2003_oblig3;
  exports edu.stud.ntnu.idatt2003_oblig3.models;
  opens edu.stud.ntnu.idatt2003_oblig3.models to javafx.fxml;
  exports edu.stud.ntnu.idatt2003_oblig3.controllers;
  opens edu.stud.ntnu.idatt2003_oblig3.controllers to javafx.fxml;
}