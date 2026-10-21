import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BorderPaneExample extends Application {

    @Override
    public void start(Stage stage) {

        // Create the BorderPane
        BorderPane root = new BorderPane();

        // TOP region
        Label header = new Label("Student Dashboard");
        header.setFont(Font.font("Arial", 24));
        header.setTextFill(Color.WHITE);

        VBox top = new VBox(header);
        top.setAlignment(Pos.CENTER);
        top.setPadding(new Insets(20));
        top.setStyle("-fx-background-color: #17345B;");

        // LEFT region: navigation menu
        Button dashboardButton = new Button("Dashboard");
        Button coursesButton = new Button("My Courses");
        Button gradesButton = new Button("Grades");

        VBox menu = new VBox(15);
        menu.setPadding(new Insets(20));
        menu.setStyle("-fx-background-color: #E5E7EB;");

        menu.getChildren().addAll(
            dashboardButton,
            coursesButton,
            gradesButton
        );

        // CENTER region: main content
        Label welcome = new Label("Welcome, Student!");
        welcome.setFont(Font.font("Arial", 22));

        Label course1 = new Label(
            "CSC 242 - Data Structures"
        );

        Label course2 = new Label(
            "CSC 239 - Java Programming"
        );

        VBox content = new VBox(20);
        content.setPadding(new Insets(30));

        content.getChildren().addAll(
            welcome, course1, course2
        );

        // RIGHT region
        Label announcements = new Label(
            "Announcements\n\n" +
            "Assignment due Friday\n\n" +
            "Exam next week"
        );

        VBox right = new VBox(announcements);
        right.setPadding(new Insets(20));
        right.setStyle("-fx-background-color: #F1F5F9;");

        // BOTTOM region
        Label footer = new Label(
            "Student Portal © 2026"
        );

        VBox bottom = new VBox(footer);
        bottom.setAlignment(Pos.CENTER);
        bottom.setPadding(new Insets(12));
        bottom.setStyle("-fx-background-color: #CBD5E1;");

        // Place nodes in the five regions
        root.setTop(top);
        root.setLeft(menu);
        root.setCenter(content);
        root.setRight(right);
        root.setBottom(bottom);

        // Button actions
        dashboardButton.setOnAction(e ->
            welcome.setText("Welcome to your Dashboard!")
        );

        coursesButton.setOnAction(e ->
            welcome.setText("Here are your courses.")
        );

        gradesButton.setOnAction(e ->
            welcome.setText("Check your grades here.")
        );

        // Create and display the scene
        Scene scene = new Scene(root, 850, 500);

        stage.setTitle("BorderPane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
