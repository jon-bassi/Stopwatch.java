import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application
{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXMLLoader.load(getClass().getResource("stopwatch.fxml"));
        primaryStage.setTitle("Stopwatch.java - made with <3");
        primaryStage.setScene(new Scene(root, 400, 65));
        primaryStage.show();
    }
}
