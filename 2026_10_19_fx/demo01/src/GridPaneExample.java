import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

    @Override
    public void start(Stage stage) {

        // Create the GridPane
        GridPane grid = new GridPane();

        // Space between columns and rows
        grid.setHgap(15);
        grid.setVgap(15);

        // Space around the grid
        grid.setPadding(new Insets(25));

        // Align the grid contents
        grid.setAlignment(Pos.CENTER);

        // Title
        Label title = new Label("Student Portal");
        title.setFont(Font.font("Arial", 26));
        title.setTextFill(Color.DARKBLUE);

        // Username controls
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");

        // Password controls
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");

        // Login button
        Button loginButton = new Button("Login");

        // Status message
        Label message = new Label();

        // Add controls using column and row indices
        grid.add(title, 0, 0, 2, 1);

        grid.add(usernameLabel, 0, 1);
        grid.add(usernameField, 1, 1);

        grid.add(passwordLabel, 0, 2);
        grid.add(passwordField, 1, 2);

        grid.add(loginButton, 1, 3);
        grid.add(message, 0, 4, 2, 1);

        // loginButton.setOnMouseMoved(event ->{
        //     System.out.println("Hello");

        // });
        // Handle button click
        loginButton.setOnAction(event -> {

            String username =
                usernameField.getText().trim();

            String password =
                passwordField.getText();

            if (username.isEmpty() ||
                password.isEmpty()) {

                message.setText(
                    "Please fill in both fields."
                );
                message.setTextFill(Color.RED);

            } else {

                message.setText(
                    "Login form submitted!"
                );
                message.setTextFill(Color.GREEN);
            }
        });

        // Put the grid inside a VBox to add a heading area
        VBox root = new VBox(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(grid);

        Scene scene = new Scene(root, 500, 350);

        stage.setTitle("GridPane Login Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
