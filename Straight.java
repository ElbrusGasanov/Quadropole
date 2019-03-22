package fx;

public class Straight {
    
    private double A;
    private double B;
    private double C;
    //метод будет определять параметры А,В и С уравнения прямой
    public Straight(double A, double B, double C){
        this.A = A;
        this.B = B;
        this.C = C;
    }
    
    public double getA(){
        return A;
    }
    
    public double getB(){
        return B;
    }
    
    public double getC(){
        return C;
    }
    
    //метод позволяет определить параметры прямой по координатам двух точек
    public static Straight TwoPoints(Point a, Point b){
        double A = 0;
        double B = 0;
        double C = 0;
        A = b.getY() - a.getY();
        B = -b.getX() + a.getX();
        C = (-a.getX()) * B + (-a.getY()) * A; 
        for (double i = 2; i <= 100; i++){
            if (A%i==0 && B%i==0 && C%i==0){
                A = A/i;
                B = B/i;
                C = C/i;
            }
        }
        return new Straight (A, B, C);
    }
    
    //метод позволяет определить параметры прямой, проходящей через точку p (X;Y)
    //и перпендикулярной прямой d с параметрами (A,B,C)
    public static Straight Normal(Straight d, Point p){
        double A = d.getB();
        double B = - d.getA();
        double C = - d.getB()*p.getX() + d.getA()*p.getY();
        return new Straight (A, B, C);
    }
}
