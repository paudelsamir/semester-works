import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Label label = new Label("Enter your name:");
        TextField textField = new TextField();
        Button button = new Button("Say Hello");
        Label output = new Label();

        button.setOnAction(e ->
            output.setText("Hello, " + (textField.getText().isEmpty() ? "World" : textField.getText()) + "!")
        );

        VBox root = new VBox(10);
        root.getChildren().addAll(label, textField, button, output);

        stage.setScene(new Scene(root, 300, 200));
        stage.setTitle("My First JavaFX App");
        stage.show();
    }
}
