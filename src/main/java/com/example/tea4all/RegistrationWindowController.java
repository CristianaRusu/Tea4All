package com.example.tea4all;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegistrationWindowController extends Application {
    @Override
    public void start(Stage primaryStage) {
        // Create UI components
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        Label emailLabel = new Label("Email:");
        TextField emailField = new TextField();
        Label passwordLabel = new Label("Password:");
        TextField passwordField = new TextField();
        Button registerButton = new Button("Register");

        // Register button action
        registerButton.setOnAction(event -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String password = passwordField.getText();
            // Implement registration logic here
            System.out.println("Registered: " + name + ", " + email + ", " + password);
        });

        // Create layout
        VBox root = new VBox(10);
        root.getChildren().addAll(nameLabel, nameField, emailLabel, emailField, passwordLabel, passwordField, registerButton);

        // Create scene and set it on the stage
        Scene scene = new Scene(root, 350, 250);
        primaryStage.setScene(scene);

        // Set window title and show the stage
        primaryStage.setTitle("Registration Window");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
