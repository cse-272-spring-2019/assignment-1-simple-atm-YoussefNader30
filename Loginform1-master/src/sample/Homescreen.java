package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import java.util.LinkedList;

 class Homescreen {
    private Scene scene,scene1,scene2,scene3,scene4;
    private Main main;
    private Stage stage;
    private double CurrentBalance = 0.0;

    class LimitedQueue<String> extends LinkedList<String> {
        private int limit;

        LimitedQueue(int limit) {
            this.limit = limit;
        }

        @Override
        public boolean add(String o) {
            super.add(o);
            while (size() > limit) { super.remove(); }
            return true;
        }
    }
     private LimitedQueue q = new LimitedQueue(5);
     private LimitedQueue q1 = new LimitedQueue(5);
     Homescreen(Stage stage) {
        this.stage = stage;
    }

    void prepareScene() {
        Label Welcome = new Label("Welcome");
        Button logout = new Button("Logout");
        Button deposit = new Button("Deposit");
        Button withdraw = new Button("Withdraw");
        Button current = new Button("GetBalance");
        Button history = new Button("History");

        GridPane grid = new GridPane();
        grid.add(Welcome, 0, 0);
        grid.add(deposit, 0, 2);
        grid.add(withdraw, 0, 3);
        grid.add(current, 0, 4);
        grid.add(history, 0, 5);
        grid.add(logout, 0, 6);

        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(main.getScene());
            }
        });
        deposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getScene1());
            }
        });
        withdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getScene2());
            }
        });
        current.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getScene3());
            }
        });
        history.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getScene4());
            }
        });

        scene = new Scene(grid, 600, 400);
    }

   void prepareScene1() {
        Label addedmount = new Label("Enter the amount that you need to deposit ");
        Label newamount = new Label();
        TextField add = new TextField();
        Button submit = new Button("Submit");
        Button logout = new Button("HomeScreen");
        GridPane grid = new GridPane();
        add.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    add.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        grid.add(addedmount, 0, 0);
        grid.add(add, 1, 0);
        grid.add(newamount, 1, 1);
        grid.add(submit, 0, 1);
        grid.add(logout, 0, 3);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String op = add.getText();
                int result = Integer.parseInt(op);
                CurrentBalance += result;
                newamount.setText("The new balance: " + CurrentBalance);
                q.add("Deposit" +result);

            }
        });
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getScene());
            }
        });
        scene1 = new Scene(grid, 600, 400);
    }

     void prepareScene2() {
        Label subamount = new Label("Enter the amount that you need to withdraw ");
        Label newamount1 = new Label();
        TextField sub = new TextField();
        Button submit = new Button("Submit");
        Button logout = new Button("HomeScreen");
        GridPane grid = new GridPane();
        sub.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("\\d*")) {
                    sub.setText(newValue.replaceAll("[^\\d]", ""));
                }
            }
        });
        grid.add(subamount, 0, 0);
        grid.add(sub, 1, 0);
        grid.add(newamount1, 1, 1);
        grid.add(submit, 0, 1);
        grid.add(logout, 0, 3);

        submit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String op = sub.getText();
                int result = Integer.parseInt(op);
                if (result < CurrentBalance) {
                    CurrentBalance -= result;
                    newamount1.setText("The new balance: " + CurrentBalance);
                    q.add("Withdraw: " + result);
                } else {
                    newamount1.setText("The entered amount is more than you have ");
                }
            }
        });
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getScene());
            }
        });
        scene2 = new Scene(grid, 600, 400);
    }

     void prepareScene3() {
        Label currents = new Label();
        GridPane grid = new GridPane();
        Button current = new Button("GetCurrent");
        Button logout = new Button("HomeScreen");
        grid.add(current, 0, 0);
        grid.add(currents, 1, 0);
        grid.add(logout, 0, 1);

        current.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                currents.setText("The current Balance is: " + CurrentBalance);

            }
        });
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getScene());
            }
        });
        scene3 = new Scene(grid, 600, 400);
    }

    void prepareScene4() {
        GridPane grid = new GridPane();
        Label Null = new Label();
        Button next1 = new Button("Next");
        Label next2 = new Label();
        Button previous1 = new Button("Previous");
        Label previous2 = new Label();
        Button logout = new Button("HomeScreen");
        grid.add(next1, 0, 0);
        grid.add(next2,2,0);
        grid.add(previous1, 0, 1);
        grid.add(previous2, 1, 1);
        grid.add(Null,2,0);
        grid.add(logout, 0, 2);

        next1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (q.peek() != null){
                next2.setText("The next transaction: " +q.peek());
                q1.add(q.peek());
                 q.remove();
                }
                else
                    next2.setText("No more transactions");
            }
        });
        previous1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                if (q1.peek() != null) {
                    next2.setText("The previous transaction: " + q1.peek());
                    q.add(q1.peek());
                    q1.remove();
                }
                else
                    next2.setText("No more transactions");
            }
        });
        logout.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                stage.setScene(getScene());
            }
        });
        scene4 = new Scene(grid, 600, 400);
    }
    Scene getScene4() {
        return this.scene4;
    }

    Scene getScene3() {
        return this.scene3;
    }

    Scene getScene2() {
        return this.scene2;
    }

    Scene getScene1() {
        return this.scene1;
    }

    Scene getScene() {
        return scene;
    }

    void setMain(Main main) {
        this.main = main;
    }
}
