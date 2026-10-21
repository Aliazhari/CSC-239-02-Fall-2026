import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
          
        Label lbl = new Label();
        lbl.setText("Username");
        Button btn = new Button("Click");
        btn.setLayoutX(85);
        btn.setLayoutY(90);

        Pane pane = new Pane();
        pane.getChildren().addAll(lbl, btn);
        Scene scene = new Scene(pane, 200, 200);
        stage.setScene(scene);
        stage.setTitle("First FX APP");
        stage.show();
    }
}
