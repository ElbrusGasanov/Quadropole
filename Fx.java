package fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;

public class Fx extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        primaryStage.setTitle("4-полюсник");
        primaryStage.setScene(new Scene(root, 430, 300 ));  
        primaryStage.setResizable(false);
        primaryStage.getIcons().add(new Image("fx/img1.png"));
        primaryStage.show();
        
    }
        
    public static void main(String[] args) {
        launch(args);
        
    }
    
}