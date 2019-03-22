package fx;


import static fx.Point.CrossPoint;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;
import static oracle.jrockit.jfr.events.Bits.intValue;

public class сontroller2 {
    
    сontroller cn = new сontroller();
    
    public ComplexNumber Z1 = cn.Z1;
    public ComplexNumber Z2 = cn.Z2;
    public ComplexNumber Z3 = cn.Z3;
    public ComplexNumber U1 = cn.U1;
    public ComplexNumber Zn = cn.Zn;
    public int type = cn.type;
    public double φ2 = cn.φ2;
    public double φ2K; 
    public double Ψ;
    
    public ComplexNumber U2;
    public ComplexNumber I1;
    public ComplexNumber I2;
    public ComplexNumber S1;
    public ComplexNumber S2;
                                            
    public ComplexNumber Z10;
    public ComplexNumber Z1K;
    public ComplexNumber Z20;   
    public ComplexNumber Z2K;
    
    public String str10;
    public String str1K;
    public String str20;
    public String str2K;
    
    public ComplexNumber A;
    public ComplexNumber B;
    public ComplexNumber C;
    public ComplexNumber D;
    
    public ComplexNumber A1;
    public ComplexNumber B1;
    public ComplexNumber C1;
    public ComplexNumber D1;
    public ComplexNumber Cn1 = new ComplexNumber (1, 0);
    
    public ComplexNumber I10;
    public ComplexNumber I1K;
    public ComplexNumber Z22K;
    
    public Straight str1;
    public Straight str2;
    public Straight str3;
    public Straight str4;
    public Point point1;
    public Point point2;
    public Point point3;
    public Point point4;
    
    public double Z2Kr;
    public double φ2Kr;
    public double Ψr;
    
    String name1 = "C:\\Users\\";
    String username = System.getProperty("user.name");
    String name2 = "\\Desktop\\solve";
    String name3 = ".doc";
    
    String LS = System.getProperty("line.separator");  //оператор переноса текста на новую строку
    String result;
    String result2;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea textArea;
    
    @FXML
    private Button ExportButton;
    
    @FXML
    private Button Graph;
    
     
    public void Solve(){
       
        
        if (type ==1) {    
            Z10 = ComplexNumber.roundResult(ComplexNumber.divide(ComplexNumber.multiply(Z1, ComplexNumber.sum(Z3, Z2)),ComplexNumber.sum(Z2, ComplexNumber.sum(Z3 , Z1))));
            Z1K = ComplexNumber.roundResult(ComplexNumber.divide(ComplexNumber.multiply(Z1 , Z3),ComplexNumber.sum(Z1, Z3)));
            Z20 = ComplexNumber.roundResult(ComplexNumber.divide(ComplexNumber.multiply(Z2, ComplexNumber.sum(Z3 , Z1)),ComplexNumber.sum(Z2, ComplexNumber.sum(Z3 , Z1))));
            Z2K = ComplexNumber.roundResult(ComplexNumber.divide(ComplexNumber.multiply(Z2 , Z3),ComplexNumber.sum(Z2, Z3)));
                   
            A = (ComplexNumber.pow(ComplexNumber.divide(Z10, ComplexNumber.subtract(Z20, Z2K)),0.5));
            B = (ComplexNumber.multiply(A,Z2K));
            C = (ComplexNumber.divide(A,Z10));
            D = (ComplexNumber.multiply(A,ComplexNumber.divide(Z20, Z10)));
        
            A1 = ComplexNumber.sum(Cn1, ComplexNumber.divide(Z3,Z2));
            B1 = Z3;
            C1 = ComplexNumber.sum(ComplexNumber.divide(Cn1, Z2), ComplexNumber.sum(ComplexNumber.divide(Cn1, Z1), ComplexNumber.divide(Z3, ComplexNumber.multiply(Z2, Z1))));
            D1 = ComplexNumber.sum(Cn1, ComplexNumber.divide(Z3,Z1));
            result2  = "1. Расчет при частоте 50Гц." + LS + "Z10 = Z1 * (Z3 + Z2) / (Z2 + Z3 + Z1) = " +Z10 + LS + "Z1K = Z1 * Z3 / (Z1 + Z3) = " +Z1K + LS + "Z20 = Z2 * (Z1 + Z3) / (Z2 + Z1 + Z3) = "+Z20 + LS + "Z2K = Z2 * Z3 / ( Z2 + Z3 ) = " +Z2K + LS + LS
            + "Проверка соотношения" + LS + "Z10 * Z2k = Z20 * Z1K" + LS
            + ComplexNumber.roundResult(ComplexNumber.multiply(Z10,Z2K)) + " = " + ComplexNumber.roundResult(ComplexNumber.multiply(Z20,Z1K)) + LS
            + "выполняется." + LS + LS
           + "2. Расчет А-постоянных четырехполюсника." + LS + "2.1. Через сопротивления крайних режимов." + LS + "A = √(Z10 / (Z20 - Z2K)) = " + ComplexNumber.roundResult(A) + LS + "B = A * Z2K = " + ComplexNumber.roundResult(B) + LS + "C = A / Z10 = " + ComplexNumber.roundResult(C)+ LS + "D = A * Z20 / Z10 = " + ComplexNumber.roundResult(D)
            + LS + LS + "проверка соотношения"+ LS + "AD - BC = 1" + LS + "(" +ComplexNumber.roundResult(A) + ") * (" + ComplexNumber.roundResult(D) + ") - (" + ComplexNumber.roundResult(B) + ") * (" + ComplexNumber.roundResult(C) + ")"
            + LS + "(" + ComplexNumber.roundResult(ComplexNumber.multiply(A,D))+ ") - (" + ComplexNumber.roundResult(ComplexNumber.multiply(B,C))+ ") = " + ComplexNumber.roundResult(ComplexNumber.subtract(ComplexNumber.multiply(A, D),ComplexNumber.multiply(B,C))) + LS + "выполняется."
            + LS + LS + "2.2. Через первичные параметры." + LS + "A = 1 + (Z3 / Z2) = " + ComplexNumber.roundResult(A1)+ LS + "B = Z3 = " + ComplexNumber.roundResult(B1)+ LS + "C = (Z3 + Z2 + Z1) / (Z2 * Z1) = " + ComplexNumber.roundResult(C1)+ LS + "D = 1 + Z3 / Z1 = " + ComplexNumber.roundResult(D1)
            + LS + LS + "проверка соотношения " + LS + "AD - BC = 1" + LS + "(" +ComplexNumber.roundResult(A1) + ") * (" + ComplexNumber.roundResult(D1) + ") - (" + ComplexNumber.roundResult(B1) + ") * (" + ComplexNumber.roundResult(C1) + ")" 
            + LS + "(" + ComplexNumber.roundResult(ComplexNumber.multiply(A1,D1))+ ") - (" + ComplexNumber.roundResult(ComplexNumber.multiply(B1,C1))+ ") = " + ComplexNumber.roundResult(ComplexNumber.subtract(ComplexNumber.multiply(A1, D1),ComplexNumber.multiply(B1,C1)))+ LS + "выполняется."
            + LS + LS;
        }
        
        if (type ==2) {    
            Z10 = ComplexNumber.roundResult(ComplexNumber.sum(Z1, Z3));
            Z1K = ComplexNumber.roundResult(ComplexNumber.sum(Z1,ComplexNumber.divide(ComplexNumber.multiply(Z2,Z3), ComplexNumber.sum(Z2, Z3))));
            Z20 = ComplexNumber.roundResult(ComplexNumber.sum(Z2, Z3));
            Z2K = ComplexNumber.roundResult(ComplexNumber.sum(Z2,ComplexNumber.divide(ComplexNumber.multiply(Z1,Z3), ComplexNumber.sum(Z1, Z3))));
                   
            A = (ComplexNumber.pow(ComplexNumber.divide(Z10, ComplexNumber.subtract(Z20, Z2K)),0.5));
            B = (ComplexNumber.multiply(A,Z2K));
            C = (ComplexNumber.divide(A,Z10));
            D = (ComplexNumber.multiply(A,ComplexNumber.divide(Z20, Z10)));
        
            A1 = ComplexNumber.sum(Cn1, ComplexNumber.divide(Z1,Z3));
            B1 = ComplexNumber.sum(Z1, ComplexNumber.sum(Z2,ComplexNumber.divide(ComplexNumber.multiply(Z1, Z2), Z3)));
            C1 = ComplexNumber.divide(Cn1,Z3);
            D1 = ComplexNumber.sum(Cn1, ComplexNumber.divide(Z2,Z3));
            
            result2 = "1. Расчет при частоте 50Гц." + LS + "Z10 = Z1 + Z3 = " + Z10 + LS + "Z1K = Z1 + Z2 * Z3 / (Z2 + Z3) = " + Z1K + LS + "Z20 = Z2 + Z3 = "+Z20 + LS + "Z2K = Z2 + Z1 * Z3 / (Z2 + Z3) = " +Z2K + LS + LS
            + "Проверка соотношения" + LS + "Z10 * Z2k = Z20 * Z1K" + LS
            + ComplexNumber.roundResult(ComplexNumber.multiply(Z10,Z2K)) + " = " + ComplexNumber.roundResult(ComplexNumber.multiply(Z20,Z1K)) + LS
            + "выполняется." + LS + LS
            + "2. Расчет А-постоянных четырехполюсника." + LS + "2.1. Через сопротивления крайних режимов." + LS + "A = √(Z10 / (Z20 - Z2K)) = " + ComplexNumber.roundResult(A) + LS + "B = A * Z2K = " + ComplexNumber.roundResult(B) + LS + "C = A / Z10 = " + ComplexNumber.roundResult(C)+ LS + "D = A * Z20 / Z10 = " + ComplexNumber.roundResult(D)
            + LS + LS + "проверка соотношения"+ LS + "AD - BC = 1" + LS + "(" +ComplexNumber.roundResult(A) + ") * (" + ComplexNumber.roundResult(D) + ") - (" + ComplexNumber.roundResult(B) + ") * (" + ComplexNumber.roundResult(C) + ")"
            + LS + "(" + ComplexNumber.roundResult(ComplexNumber.multiply(A,D))+ ") - (" + ComplexNumber.roundResult(ComplexNumber.multiply(B,C))+ ") = " + ComplexNumber.roundResult(ComplexNumber.subtract(ComplexNumber.multiply(A, D),ComplexNumber.multiply(B,C))) + LS + "выполняется."
            + LS + LS + "2.2. Через первичные параметры." + LS + "A = 1 + Z1 / Z3 = " + ComplexNumber.roundResult(A1)+ LS + "B = Z1 + Z2 + Z1 * Z2 / Z3 = " + ComplexNumber.roundResult(B1)+ LS + "C = 1 / Z3 = " + ComplexNumber.roundResult(C1)+ LS + "D = 1 + Z2 / Z3 = " + ComplexNumber.roundResult(D1)
            + LS + LS + "проверка соотношения " + LS + "AD - BC = 1" + LS + "(" +ComplexNumber.roundResult(A1) + ") * (" + ComplexNumber.roundResult(D1) + ") - (" + ComplexNumber.roundResult(B1) + ") * (" + ComplexNumber.roundResult(C1) + ")" 
            + LS + "(" + ComplexNumber.roundResult(ComplexNumber.multiply(A1,D1))+ ") - (" + ComplexNumber.roundResult(ComplexNumber.multiply(B1,C1))+ ") = " + ComplexNumber.roundResult(ComplexNumber.subtract(ComplexNumber.multiply(A1, D1),ComplexNumber.multiply(B1,C1)))+ LS + "выполняется."
            + LS + LS;
        }
        
        I2 = ComplexNumber.divide(U1, ComplexNumber.sum(ComplexNumber.multiply(A1, Zn), B1));
        U2 = ComplexNumber.multiply(I2,Zn);
        I1 = ComplexNumber.sum(ComplexNumber.multiply(C1, U2),ComplexNumber.multiply(D1, I2));
        S1 = ComplexNumber.multiply(ComplexNumber.reverse(I1), U1);
        S2 = ComplexNumber.multiply(ComplexNumber.reverse(I2), U2);
        
        I10 = ComplexNumber.roundResult(ComplexNumber.divide(ComplexNumber.multiply(U1, C1),A1));
        I1K = ComplexNumber.roundResult(ComplexNumber.divide(ComplexNumber.multiply(U1, D1),B1));
        Z22K = ComplexNumber.roundResult(ComplexNumber.divide(B1,A1));
        φ2K = ComplexNumber.getAngle(Z22K);
        Ψ = φ2 - φ2K;
        
        

    }
    
    public void Result (){
        Z2Kr = Math.round(Z22K.getModule()*1000);
        Ψr = Math.round(Ψ*100);
        φ2Kr = Math.round(φ2K*100);
        result = result2 + "3. Нагрузочный режим по уравнениям в А-постоянных." + LS + "I2 = U1 / (A * Z2 + B) = " + ComplexNumber.roundResult(I2) + LS + "U2 = I2 * Z2 = " + ComplexNumber.roundResult(U2) + LS + "I1 = C * U2 + D * I2 = " + ComplexNumber.roundResult(I1) + LS + "S1 = I1 * U1 = " + ComplexNumber.roundResult(S1) + LS + "S2 = I2 * U2 = " + ComplexNumber.roundResult(S2)
            + LS + LS + "4. Круговая диаграмма тока I1 при U1 = " + intValue(U1.getRe()) + "B, φ2 = " + intValue(φ2) + "°, f = 50 Гц, Z2 = 0 ÷ ∞." + LS + "Находим токи I10 и I1K " + LS + "и сопротивление нагрузки при коротком замыкании:" + LS + "I10 = U1 * (C/A) = " + intValue(U1.getRe()) + "*(" + ComplexNumber.roundResult(C) + ")/(" + ComplexNumber.roundResult(A) + ") = " +  I10
            + LS + "I1K = U1 * D / B = " + intValue(U1.getRe()) + "*(" + ComplexNumber.roundResult(D1) + ")/(" + ComplexNumber.roundResult(B1) + ") = " +  I1K
            + LS + "Z2K = B / A = (" + ComplexNumber.roundResult(B1) + ") / (" + ComplexNumber.roundResult(A1) + ") = " + Z22K + " = " + Z2Kr/1000 + "∠" + φ2Kr/100
            + LS + "φ2K = " + φ2Kr/100 + LS + "Ψ = " + Ψr/100 ;
        
    }
    
    public void Export(){
               
        for (int i = 1; i <= 50; i++){
            File file = new File(name1+username+name2+i+name3);
            
            if (!file.exists()){
                try {
                    file.createNewFile();
                    PrintWriter pw = new PrintWriter(file, "UTF-8");
                    pw.println(result);
                    pw.close();
                    break;
                } catch (IOException ex) {
                    Logger.getLogger(сontroller2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    
    public void InitGraph(){
            double ox = 300;
            double oy = 300;
            GraphicsContext GC;
            Stage stageGR = new Stage();
            stageGR.setTitle("График");
            stageGR.getIcons().add(new Image("fx/img1.png"));
            FlowPane rootNode = new FlowPane();
            rootNode.setAlignment(Pos.CENTER);
            Scene sceneGR = new Scene(rootNode, 600, 630);
            stageGR.setScene(sceneGR);
            stageGR.setResizable(false);
            double M = 0;  //масштаб построения диаграммы
            Canvas cnvs = new Canvas(600, 630);
            GC = cnvs.getGraphicsContext2D();
            ComplexNumber MM = ComplexNumber.subtract(I1K, I10); // I1K - I10
            ComplexNumber MM2 = ComplexNumber.multiply(MM, new ComplexNumber (Math.cos(Ψ*Math.PI/180), Math.sin(Ψ*Math.PI/180)));  //повернутый на угол Ψ отрезок
            ComplexNumber P1 = ComplexNumber.sum(I1K, MM);
            ComplexNumber P2 = ComplexNumber.sum(I1K, MM2);
            point1 = new Point (I10.getRe(), I10.getIm());
            point2 = new Point (I1K.getRe(), I1K.getIm());
            point3 = new Point (P2.getRe(), P2.getIm());
            str1 = Straight.TwoPoints(point1, point2);
            str2 = Straight.TwoPoints(point2, point3);
            str3 = Straight.Normal(str1, new Point((point2.getX()+point1.getX())/2, (point2.getY()+point1.getY())/2));
            str4 = Straight.Normal(str2, point2);
            point4 = CrossPoint(str3, str4);
            double Radius = Math.sqrt((point2.getX()-point4.getX())*(point2.getX()-point4.getX()) + (point2.getY()-point4.getY())*(point2.getY()-point4.getY()));
            
            double [] massive = {I1K.getRe(), I1K.getIm(), I10.getRe(), I10.getIm()};
            double MaxDouble = 0;
            for (int i = 0; i < massive.length; i++){
                if (Math.abs(massive[i]) > MaxDouble){
                    MaxDouble = Math.abs(massive[i]);
                }
            }
            
            for (double i = 1; ox/(i*MaxDouble) > 1.2; i += 1){
                M = i-1;
                
            }
            double a1 = 0;
            double a2 = 0;
            
            if (point2.getY() >= point4.getY() && point2.getX() > point4.getX()){
                a1 = - Math.toDegrees(Math.asin((point4.getY() - point2.getY())/Radius));
                
            } 
            if (point2.getY() > point4.getY() && point2.getX() <= point4.getX()){
                a1 = 180 + Math.toDegrees(Math.asin((point4.getY() - point2.getY())/Radius));
                
            }
            if (point2.getY() <= point4.getY() && point2.getX() < point4.getX()){
                a1 = - 180 + Math.toDegrees(Math.asin((point4.getY() - point2.getY())/Radius));
                
            }
            if (point2.getY() < point4.getY() && point2.getX() >= point4.getX()){
                a1 = - Math.toDegrees(Math.asin((point4.getY() - point2.getY())/Radius));
                
            }
            
            
            if (point1.getY() >= point4.getY() && point1.getX() > point4.getX()){
                a2 = - Math.toDegrees(Math.asin((point4.getY() - point1.getY())/Radius));
            } 
            if (point1.getY() > point4.getY() && point1.getX() <= point4.getX()){
                a2 = 180 + Math.toDegrees(Math.asin((point4.getY() - point1.getY())/Radius));
            }
            if (point1.getY() <= point4.getY() && point1.getX() < point4.getX()){
                a2 = - 180 + Math.toDegrees(Math.asin((point4.getY() - point1.getY())/Radius));
            }
            if (point1.getY() < point4.getY() && point1.getX() >= point4.getX()){
                a2 = - Math.toDegrees(Math.asin((point4.getY() - point1.getY())/Radius));
            }
              
            
            GC.strokeLine(20, oy, 2*ox - 20, oy); //ось +i
            GC.strokeLine(ox, 20, ox, 2*oy - 20); // ось +1
            GC.strokeText("+i", ox+5, 20);
            GC.strokeText("+1", 2*ox - 25, oy - 5);
            
            GC.setStroke(Color.GREEN);           
            GC.strokeLine(ox, oy, ox + I1K.getRe()*M, oy - I1K.getIm()*M);  //I1K
            GC.strokeText("I1K",40, 610);
            GC.strokeLine(20, 605, 35, 605);
            
            GC.setStroke(Color.BLUE);
            GC.strokeLine(ox, oy, ox + I10.getRe()*M, oy - I10.getIm()*M);  //I10
            GC.strokeText("I10",100, 610);
            GC.strokeLine(80, 605, 95, 605);
            //GC.strokeLine(ox + I10.getRe()*M, oy - I10.getIm()*M, ox + I1K.getRe()*M, oy-I1K.getIm()*M);  // отрезок (Мо,Мк)
            //GC.strokeLine(ox + I1K.getRe()*M, oy - I1K.getIm()*M, ox + P1.getRe()*M, oy - P1.getIm()*M);  //строим продолжение отрезка МоМк
            //GC.strokeLine(ox + I1K.getRe()*M, oy - I1K.getIm()*M, ox + P2.getRe()*M, oy - P2.getIm()*M);
            
            GC.setStroke(Color.RED);
            
            if (Ψ < 0){
                GC.strokeArc(ox - Radius*M + point4.getX()*M, oy - Radius*M - point4.getY()*M, 2*Radius*M, 2*Radius*M, a1 ,   - a1 + a2, ArcType.OPEN);
                  
            }else{
                GC.strokeArc(ox - Radius*M + point4.getX()*M, oy - Radius*M - point4.getY()*M, 2*Radius*M, 2*Radius*M,  a2 , a1 - a2, ArcType.OPEN);
                 
            }
            GC.strokeText("I1 при Zn(0÷∞)",135, 610);
            //GC.strokeLine(ox, oy, ox + point4.getX()*M,oy -  point4.getY()*M);
            
            GC.setStroke(Color.LIGHTGRAY);
            GC.strokeText("Разработал Гасанов Э.Г.", 450, 610);
            GC.strokeText("Elbrus201267@gmail.com", 450, 625);    
            
            
            rootNode.getChildren().addAll(cnvs);
            stageGR.show();
       
    }
           
    @FXML
    void initialize() {
            Solve(); 
            Result();
            textArea.setText(result);
            
            ExportButton.setOnAction(event ->{
                Export();
            });
            
            Graph.setOnAction(event ->{
               InitGraph(); 
            });
    }
}
