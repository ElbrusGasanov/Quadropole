
package fx;

//класс будет позволять работать с точками на координнатной плоскости
public class Point {
    double X;
    double Y;
    
    public Point (double X, double Y){
        this.X = X;
        this.Y = Y;
    }
    
    public double getX(){
        return X;
    }
    
    public double getY(){
        return Y;
    }
    
    //метод будет находить точку пересечения двух прямых (двух объектов класса Straight
    public static Point CrossPoint(Straight s1, Straight s2){
        double X = 0;
        double Y = 0;
        double A1 = s1.getA();
        double B1 = s1.getB();
        double C1 = s1.getC();
        double A2 = s2.getA();
        double B2 = s2.getB();
        double C2 = s2.getC();
        
        Y = (-C2 + A2*C1/A1)/((-A2*B1/A1)+B2);
        X = (-C1 - B1*Y)/A1;
        Point p = new Point (X, Y);
        return p;

    }
}
