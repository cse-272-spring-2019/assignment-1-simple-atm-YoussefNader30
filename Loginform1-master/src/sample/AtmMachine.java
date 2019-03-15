package sample;

import javafx.application.Application;
import javafx.stage.Stage;

public class AtmMachine extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Atm Machine");

        Main main = new Main(primaryStage);
        Homescreen homescreen = new Homescreen(primaryStage);

        main.PreperScene();
        homescreen.prepareScene();
        homescreen.prepareScene1();
        homescreen.prepareScene2();
        homescreen.prepareScene3();
        homescreen.prepareScene4();
        main.setHomescreen(homescreen);
        homescreen.setMain(main);

        primaryStage.setScene(main.getScene());
        primaryStage.show();
    }
}
