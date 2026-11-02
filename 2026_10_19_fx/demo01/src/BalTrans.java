import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class BalTrans extends Application {

    @Override
    public void start(Stage stage) {

        Pane pane = new Pane();

        // Object to animate
        Circle ball = new Circle(10, Color.RED);
        ball.setCenterX(100);
        ball.setCenterY(100);

        // Define the path
        Circle path = new Circle(100);
        path.setCenterX(200);
        path.setCenterY(200);
        path.setFill(Color.TRANSPARENT);
        path.setStroke(Color.GRAY);

        // Create animation
        PathTransition pt = new PathTransition();

        pt.setDuration(Duration.seconds(5));
        pt.setPath(path);
        pt.setNode(ball);
        pt.setCycleCount(PathTransition.INDEFINITE);
        pt.setAutoReverse(false);

        pt.play();

        pane.getChildren().addAll(path, ball);

        Scene scene = new Scene(pane, 400, 400);

        stage.setScene(scene);
        stage.setTitle("Path Transition Demo");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
