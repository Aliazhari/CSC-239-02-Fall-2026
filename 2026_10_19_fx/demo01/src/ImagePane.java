import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ImagePane extends Application{
    int times = 0;
  
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        

        // Main container
        Pane pane = new Pane();
        pane.setPrefSize(600, 600);
        pane.setStyle("-fx-background-color: #F3F6FB;");

        // 1. Load the banner image
        Image image = new Image(
            getClass().getResourceAsStream(
                "bhcc_logo.png"
            )
        );

        // 2. Display the banner
        ImageView banner = new ImageView(image);
        banner.setFitWidth(600);
        banner.setFitHeight(200);
        banner.setPreserveRatio(false);
        banner.setLayoutX(0);
        banner.setLayoutY(0);

        // 3. Banner title
        Label bannerTitle = new Label("MY APPLICATION");
        bannerTitle.setFont(
            Font.font("Arial", 30)
        );
        bannerTitle.setTextFill(Color.BLACK);
        bannerTitle.setLayoutX(215);
        bannerTitle.setLayoutY(205);

        Label bannerSubtitle =
            new Label("Your gateway to success");
        bannerSubtitle.setFont(
            Font.font("Arial", 16)
        );
        bannerSubtitle.setTextFill(Color.WHITE);
        bannerSubtitle.setLayoutX(238);
        bannerSubtitle.setLayoutY(310);

        // 4. Login title
        Label title = new Label("Welcome Back");
        title.setFont(Font.font("Arial", 26));
        title.setTextFill(Color.web("#e7c014"));

        Label message = new Label(
            "Sign in to access your account"
        );
        message.setFont(Font.font("Arial", 14));
        message.setTextFill(Color.GRAY);

        // 5. Username field
        Label usernameLabel = new Label("Username");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter your username");
        usernameField.setPrefHeight(40);

        // 6. Password field
        Label passwordLabel = new Label("Password");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter your password");
        passwordField.setPrefHeight(40);

        TextField visiblePassword = new TextField();
        visiblePassword.setPromptText("Enter password");
        visiblePassword.setPrefHeight(40);
        visiblePassword.setManaged(false);
        visiblePassword.setVisible(false);

        

        // 7. Login button
        Button loginButton = new Button("Login");
        loginButton.setMaxWidth(Double.MAX_VALUE);
        loginButton.setPrefHeight(42);

        loginButton.setStyle(
            "-fx-background-color: #2563EB;" +
            "-fx-text-fill: white;" +
            "-fx-font-size: 16px;" +
            "-fx-font-weight: bold;" +
            "-fx-background-radius: 8;"
        );

        // 8. Status message
        Label statusLabel = new Label("");
        statusLabel.setTextFill(
            Color.web("#DC2626")
        );

        class Handler implements EventHandler {

            @Override
            public void handle(Event arg0) {
            String username =
                usernameField.getText().trim();

            String password =
                passwordField.getText();

            if (username.isEmpty() ||
                password.isEmpty()) {

                statusLabel.setText(
                    "Please enter both fields."
                );

            } else {
                statusLabel.setTextFill(
                    Color.web("#15803D")
                );

                statusLabel.setText(
                    "Login form submitted!"
                );
            }
        }

        }

      
        loginButton.setOnAction(x -> {

            String username =
                usernameField.getText().trim();

            String password =
                passwordField.getText();

            if (username.isEmpty() || password.isEmpty()) {
                statusLabel.setText(
                    "Please enter both fields."
                );

            } else {
                statusLabel.setTextFill(
                    Color.web("#15803D")
                );

                statusLabel.setText(
                    "Login form submitted!"
                );
            }
        });

        Label showPass = new Label("\nShow");
        HBox hBox  = new HBox(2);
        hBox.getChildren().addAll(passwordField, visiblePassword, showPass);

        // 9. Arrange form controls vertically
        VBox form = new VBox(10);
        

        form.setAlignment(Pos.CENTER_LEFT);
        form.setPrefWidth(340);

        form.getChildren().addAll(
            title,
            message,
            usernameLabel,
            usernameField,
            passwordLabel,
            hBox,
            loginButton,
            statusLabel
        );

        form.setLayoutX(130);
        form.setLayoutY(230);

        // 10. Add everything to the Pane
        pane.getChildren().addAll(
            banner,
            bannerTitle,
            bannerSubtitle,
            form
        );

        showPass.setOnMousePressed(event -> {
            boolean show = true;
            visiblePassword.setText(passwordField.getText());
            passwordField.setVisible(!show);
            passwordField.setManaged(!show);

            visiblePassword.setVisible(show);
            visiblePassword.setManaged(show);
            
        });

        usernameField.setOnKeyPressed(event -> {
            System.out.println(event.getCode());
        }

        );
   
        passwordField.setOnKeyTyped( event -> {
            System.out.println(event.getSource());
        
            String s = passwordField.getText();
            //  statusLabel.setText( "Key presses " + s.charAt(0));
            if ( (s.charAt(0) < 'A') || (s.charAt(0) > 'z')) 
                statusLabel.setText("Invalid password: " + s.charAt(0));
            else
                statusLabel.setText("Valid: " + s.charAt(0));
            });

        showPass.setOnMouseClicked(event -> {
            boolean show = false;
            passwordField.setVisible(!show);
            passwordField.setManaged(!show);

            visiblePassword.setVisible(show);
            visiblePassword.setManaged(show);
            
        });

        Scene scene = new Scene(pane, 600, 600);

        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

 
}

    

