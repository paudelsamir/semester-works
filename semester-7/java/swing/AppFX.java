import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AppFX extends Application {

    @Override
    public void start(Stage stage) {
        // Window title
        stage.setTitle("My JavaFX App");

        // Container (VBox, HBox, GridPane, etc.)
        VBox root = new VBox(10); // 10px spacing

        // Add components here:
        // root.getChildren().add(new Label("Hello"));

        // Attach to stage
        stage.setScene(new Scene(root, 500, 400));
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
