import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;

// Swing: JFrame -> JavaFX: Stage
// Swing: JPanel -> JavaFX: VBox, HBox, GridPane, etc.
// Swing: component.add() -> JavaFX: container.getChildren().add()
// Swing: setSize(w,h) -> JavaFX: new Scene(root, w, h)
// Swing: setVisible(true) -> JavaFX: stage.show()

public class app extends Application {

    public static void main(String[] args) {
        launch(args); // this sets up JavaFX
    }

    @Override
    public void start(Stage stage) {
        // Stage = the window (like JFrame)
        stage.setTitle("My First JavaFX App");

        // VBox = vertical layout (like BoxLayout Y_AXIS)
        VBox root = new VBox(10); // 10px spacing between children
        root.setPadding(new Insets(10));

        Label label = new Label("Enter your name:");
        TextField input = new TextField();
        input.setPromptText("Type here...");

        Button btn = new Button("Say Hello");
        Label output = new Label();

        // Event handling (like ActionListener)
        btn.setOnAction(e -> {
            String name = input.getText();
            if (name.isEmpty()) name = "World";
            output.setText("Hello, " + name + "!");
        });

        root.getChildren().addAll(label, input, btn, output);

        // Scene = the content area (like JFrame's content pane)
        Scene scene = new Scene(root, 400, 300);
        stage.setScene(scene);
        stage.show(); // like frame.setVisible(true)
    }
}
