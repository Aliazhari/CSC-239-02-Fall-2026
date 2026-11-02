

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public class RandomWalker {
    private final double radius;
    private final Color color;
    private final Pane pane;
    private double x, y;
    private Circle circle;
    private Polyline path;
    private Timeline animation;
    private Runnable onStep;

    // Constructor with explicit position
    public RandomWalker(double radius, Color color, Pane pane, double startX, double startY) {
        this.radius = radius;
        this.color = color;
        this.pane = pane;
        this.x = startX;
        this.y = startY;

        // Create the initial circle and path at the correct position
        initializeWalker();
    }

    // Constructor with random position
    public RandomWalker(double radius, Color color, Pane pane) {
        this(radius, color, pane, Math.random() * 500, Math.random() * 500);
    }

    private void initializeWalker() {
        // Create the circle at the starting position
        circle = new Circle(x, y, radius, color);
        pane.getChildren().add(circle);

        // Create the path starting at the initial position
        path = new Polyline();
        path.setStroke(color);
        pane.getChildren().add(path);
        path.getPoints().addAll(x, y);
    }

    public void setPosition(double x, double y) {
        this.x = x;
        this.y = y;

        // Update the circle's position
        if (circle != null) {
            circle.setCenterX(x);
            circle.setCenterY(y);
        }

        // Update the path's starting point
        if (path != null) {
            path.getPoints().clear();
            path.getPoints().addAll(x, y);
        }
    }

    public void startWalk() {
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> move()));
        animation.setCycleCount(2000); // Perform 2000 steps
        animation.play();
    }

    public void setOnStep(Runnable onStep) {
        this.onStep = onStep;
    }

    private void move() {
        // Generate a random direction (0 to 7 for 8 cardinal directions)
        int direction = (int) (Math.random() * 8);
        // Generate a random step size between 1 and 9
        double step = Math.random() * 9 + 1;

        // Update x and y based on the direction
        switch (direction) {
            case 0: y -= step; break; // North
            case 1: x += step; y -= step; break; // Northeast
            case 2: x += step; break; // East
            case 3: x += step; y += step; break; // Southeast
            case 4: y += step; break; // South
            case 5: x -= step; y += step; break; // Southwest
            case 6: x -= step; break; // West
            case 7: x -= step; y -= step; break; // Northwest
        }

        // Keep the walker within the pane boundaries
        if (x < radius) x = radius;
        if (x > pane.getWidth() - radius) x = pane.getWidth() - radius;
        if (y < radius) y = radius;
        if (y > pane.getHeight() - radius) y = pane.getHeight() - radius;

        // Update the circle's position
        circle.setCenterX(x);
        circle.setCenterY(y);

        // Add the new point to the path
        path.getPoints().addAll(x, y);

        // Trigger the onStep callback
        if (onStep != null) {
            onStep.run();
        }
    }

    public boolean intersects(Circle other) {
        double dx = x - other.getCenterX();
        double dy = y - other.getCenterY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        return distance <= radius + other.getRadius();
    }
}
