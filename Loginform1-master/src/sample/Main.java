package sample;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import java.util.HashMap;

class Main {

    private Stage stage;
    private Homescreen homescreen;
    private Scene scene;

    private HashMap usersdict;



    Main(Stage stage){
        this.stage =stage;
    }

    void PreperScene() {

        Label usernameLabel = new Label("Username:");
        Label passwordLabel = new Label("Password:");
        TextField usernameField = new TextField();
        PasswordField passwordField = new PasswordField();
        Button submit = new Button("Submit");
        Label ValidationLabel = new Label();
        GridPane grid = new GridPane();
        grid.add(usernameLabel, 0, 0);
        grid.add(passwordLabel, 0, 1);
        grid.add(usernameField, 1, 0);
        grid.add(passwordField, 1, 1);
        grid.add(submit, 1, 2);
        grid.add(ValidationLabel, 1, 3);
        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String username = usernameField.getText();
                String password = passwordField.getText();
                usersdict = new HashMap();
                usersdict.put("joe", "1234");
                boolean ValidationResult = false;
                String Fetchedp = (String) usersdict.get(username);
                if (Fetchedp != null) {
                    ValidationResult = Fetchedp.equals(password);
                }
                boolean valid = ValidationResult;
                if(valid){
                    ValidationLabel.setText("Welcome " +username);
                    stage.setScene(homescreen.getScene());
                }
                else {
                    ValidationLabel.setText("Wrong username or password");
                    ValidationLabel.setFont(new Font("Verdana",20));
                    ValidationLabel.setStyle("color:red");
                }
            }
        });
        scene = new Scene(grid, 600,400);
    }

    Scene getScene(){ return this.scene; }

    void setHomescreen(Homescreen homescreen) {
        this.homescreen = homescreen;
    }
}
