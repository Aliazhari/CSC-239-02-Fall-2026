import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class PolylineDemo extends Application {

    @Override
    public void start(Stage stage) {

        Pane pane = new Pane();

        Polyline polyline = new Polyline();

        // Define points (x, y)
        polyline.getPoints().addAll(
            50.0, 50.0,
            150.0, 50.0,
            150.0, 150.0,
            250.0, 150.0,
            250.0, 250.0
        );
        polyline.getPoints().addAll(50.0, 250.0);

        polyline.setStroke(Color.BLUE);
        polyline.setStrokeWidth(4);

        pane.getChildren().add(polyline);

        Scene scene = new Scene(pane, 400, 350);

        stage.setTitle("JavaFX Polyline Example");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
