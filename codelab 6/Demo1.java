package org.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Demo1 extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Login Form");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Text sceneTitle = new Text("Welcome");
        sceneTitle.setFont(Font.font( 20));
        grid.add(sceneTitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:");
        grid.add(userName, 0, 1);

        TextField userTextField = new TextField();
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);

        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actionTarget = new Text();
        grid.add(actionTarget, 1, 6);

        btn.setOnAction(event -> {
            if (userTextField.getText().equals("grey") && pwBox.getText().equals("1")) {
                actionTarget.setFill(Color.GREEN);
                actionTarget.setText("Login successful!");

                VBox newVBox = new VBox();
                newVBox.setAlignment(Pos.CENTER);
                Text newText = new Text("Hi " + userTextField.getText());
                newText.setFont(Font.font( 20));
                newVBox.getChildren().add(newText);

                Scene scene2 = new Scene(newVBox, 400, 300);
                Stage newStage = new Stage();

                Button backButton = new Button("Kembali");
                backButton.setOnAction(e -> primaryStage.show());
                HBox hboxButton = new HBox(10);
                hboxButton.setAlignment(Pos.BASELINE_CENTER);
                hboxButton.getChildren().add(backButton);
                newVBox.getChildren().add(hboxButton);

                newStage.setTitle("Halaman Baru");
                newStage.setScene(scene2);
                newStage.show();
                primaryStage.hide();


            } else {
                actionTarget.setFill(Color.RED);
                actionTarget.setText("Invalid username or password!");
            }
        });

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}