/******************************************
 *  Author : Stephen Costigan   
 *  Created On : Tue Apr 08 2025
 *  File : RandomWalk.java
 *  Description: This is a JavaFX program that simulates a random walk with a blue circle and green circles
 *  that change to red when the blue circle intersects with them
 *******************************************/

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class RandomWalkerDemo extends Application {
    private static final int NUM_GREEN_CIRCLES = 10;
    private static final double GREEN_RADIUS = 10; // At least 2x the radius of the blue walk
    private static final double BLUE_RADIUS = 5;
    private List<Circle> greenCircles = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        // Create the initial blue random walker
        RandomWalker blueWalker = new RandomWalker(BLUE_RADIUS, Color.BLUE, pane);
        blueWalker.startWalk();

        // Add 10 random green circles
        for (int i = 0; i < NUM_GREEN_CIRCLES; i++) {
            Circle greenCircle = new Circle(
                Math.random() * 500, // Random x position
                Math.random() * 500, // Random y position
                GREEN_RADIUS,
                Color.GREEN
            );
            greenCircles.add(greenCircle);
            pane.getChildren().add(greenCircle);
        }

        // Set up the scene and stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Random Walk Simulation");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Handle interactions between the blue walker and green circles
        blueWalker.setOnStep(() -> handleInteractions(blueWalker, pane));
    }

    private void handleInteractions(RandomWalker walker, Pane pane) {
        // Check if the walker intersects with any green circle
        for (Circle greenCircle : greenCircles) {
            if (greenCircle.getFill() == Color.GREEN && walker.intersects(greenCircle)) {
                // Change the green circle to red
                greenCircle.setFill(Color.RED);

                // Remove the green circle from the pane
                pane.getChildren().remove(greenCircle);

                // Start a new random walk for the red circle at the green circle's position
                RandomWalker redWalker = new RandomWalker(
                    greenCircle.getRadius(), // Radius
                    Color.RED,               // Color
                    pane,                    // Pane
                    greenCircle.getCenterX(), // Start X
                    greenCircle.getCenterY()  // Start Y
                );
                redWalker.startWalk();

                // Recursively handle interactions for the new red walker
                redWalker.setOnStep(() -> handleInteractions(redWalker, pane));
            }
        }
    }

    public static void main(String[] args) {
        launch(args); // Launch the application
    }
}
