import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class PaneExample extends Application {

    @Override
    public void start(Stage stage) {

        // Create a Pane
        Pane pane = new Pane();

        // Create a Label
        Label label = new Label("Welcome to JavaFX!");
        label.setLayoutX(50);
        label.setLayoutY(30);

        // Create a Button
        Button button = new Button("Click Me");
        button.setLayoutX(50);
        button.setLayoutY(80);

        // Create a Circle
        Circle circle = new Circle(150, 100, 30);
        circle.setFill(Color.CORNFLOWERBLUE);

        // Add an event handler
        button.setOnAction(e -> {
            label.setText("Button was clicked!");
            circle.setFill(Color.RED);
        });

        // Add all nodes to the Pane
        pane.getChildren().addAll(label, button, circle);

        // Create the Scene
        Scene scene = new Scene(pane, 350, 200);

        stage.setTitle("JavaFX Pane Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}