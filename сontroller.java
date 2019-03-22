package fx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;


public class сontroller {
          
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button SolveButton;

    @FXML
    private TextField text31;

    @FXML
    private TextField text11;

    @FXML
    private TextField text22;

    @FXML
    private TextField text21;

    @FXML
    private TextField text32;

    @FXML
    private TextField text12;
    
    @FXML
    private TextField Voltage;
    
    @FXML
    private RadioButton TType;
    
    @FXML
    private RadioButton PType;
    
    @FXML
    private TextField TextFieldφ2;
    
    @FXML
    private TextField TextFieldZn;
    
    
    @FXML
    private ToggleGroup tg;
     
    public static ComplexNumber Z1;
    public static ComplexNumber Z2;
    public static ComplexNumber Z3;
    public static ComplexNumber U1;
    public static ComplexNumber Zn;
    public static double φ2;
    public static int type = 1;
    
    public void InitNums(){
        try {
            Z1 = new ComplexNumber (Double.parseDouble(text11.getText()), Double.parseDouble(text12.getText()));
            Z2 = new ComplexNumber (Double.parseDouble(text21.getText()), Double.parseDouble(text22.getText()));
            Z3 = new ComplexNumber (Double.parseDouble(text31.getText()), Double.parseDouble(text32.getText()));
            U1 = new ComplexNumber (Double.parseDouble(Voltage.getText()), 0);
            Zn = new ComplexNumber (Double.parseDouble(TextFieldZn.getText()), 0);
            φ2 = Double.parseDouble(TextFieldφ2.getText());
            
            
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXML2.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 550, 530);
            Stage stage = new Stage();
            stage.setTitle("Решение");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.getIcons().add(new Image("fx/img1.png"));
            stage.show();
            
        }
        catch (IOException e) {
            Logger logger = Logger.getLogger(getClass().getName());
            logger.log(Level.SEVERE, "Failed to create new Window.", e);
        }
    }
           
    public void ptype (){
        type = 1;
    }
    
    public void ttype(){
        type = 2;
    }
    
    
    @FXML
    void initialize() {
                
        TType.setOnAction(event ->{
            ttype();
        });
        
        PType.setOnAction(event ->{
            ptype();
        });
             
        SolveButton.setOnAction(event ->{
        try{
            InitNums();
        } catch(NumberFormatException e){
        
        }
            
        });
    }
  
}