package fx;

public class ComplexNumber {
    private double re;  //действительная часть числа
    private double im;  //мнимая часть числа
    
    public ComplexNumber(double re, double im){
        this.re = re;
        this.im = im;
    }
    
    public double getRe(){
        return re;      //метод, возвращающий действительную часть числа
    }
    
    public double getIm(){
        return im;      //метод, возвращающий мнимую часть числа
    }
    
    public double getModule(){
        return Math.sqrt(this.re * this.re + this.im * this.im);  //возвращает модуль числа
    }
    
    public static ComplexNumber sum(ComplexNumber cn1,ComplexNumber cn2){
        return new ComplexNumber(cn1.getRe()+cn2.getRe(), cn1.getIm()+cn2.getIm());
    }
    
    public static ComplexNumber multiply(ComplexNumber cn1, ComplexNumber cn2) {
        return new ComplexNumber(cn1.getRe() * cn2.getRe() - cn1.getIm() * cn2.getIm(), cn1.getRe() * cn2.getIm() + cn1.getIm() * cn2.getRe());
    }
    
    public static ComplexNumber subtract(ComplexNumber cn1, ComplexNumber cn2) {
        return new ComplexNumber(cn1.getRe() - cn2.getRe(), cn1.getIm() - cn2.getIm());
    }
    
    public static ComplexNumber divide(ComplexNumber cn1, ComplexNumber cn2) {
        ComplexNumber temp = new ComplexNumber(cn2.getRe(), (-1) * cn2.getIm());
        temp = ComplexNumber.multiply(cn1, temp);
        double denominator = cn2.getRe() * cn2.getRe() + cn2.getIm() * cn2.getIm();
        return new ComplexNumber(temp.getRe() / denominator, temp.getIm() / denominator);
    }
    
    public double getArg() {      
        if (this.re > 0) {
            return Math.atan(im / re);
        } else {
            if (re < 0 && im > 0) {
                return Math.PI + Math.atan(im / re);
            } else {
                return -Math.PI + Math.atan(im / re);
            }
        }
    }
        
        private String sign(){
        if (im > 0){
            return " + ";
        }
        else{
            return " - ";
        }
        
    }
    public static ComplexNumber roundResult (ComplexNumber d) {
    double pr = 1000;
    double CX = d.getRe();
    double CY = d.getIm();
    CX *= pr;
    CY *= pr;
    CX = Math.round(CX);
    CY = Math.round(CY);
    CX = CX/pr;
    CY = CY/pr;
    return new ComplexNumber(CX,CY);
     
    }
    
    public static ComplexNumber reverse (ComplexNumber d){  //позволяет менять знак угла
        double R = d.getRe();
        double I = d.getIm();
        I = I * (-1);
        return new ComplexNumber (R,I);
         
    }
    
    public static ComplexNumber pow(ComplexNumber cn, double power) { //позволяет возводить в степень
        double factor = Math.pow(cn.getModule(), power);
        return new ComplexNumber(factor * Math.cos(power * cn.getArg()), factor * Math.sin(power * cn.getArg()));
    }
    
    public static double getAngle(ComplexNumber cn){
        double φ = 0;
        if (cn.getRe() > 0 && cn.getIm() > 0){
            φ = Math.round((180/Math.PI)*Math.acos(cn.getRe()/cn.getModule()) * 100)*0.01;
        }
        else if (cn.getRe() <= 0 && cn.getIm() > 0){
            φ = 90 + Math.round((180/Math.PI)*Math.acos(cn.getIm()/cn.getModule()) * 100)*0.01;
        }
        else if (cn.getRe() <= 0 && cn.getIm() <= 0){
           φ = - 90 - Math.round((180/Math.PI)*Math.acos(cn.getIm()*(-1)/cn.getModule()) * 100)*0.01; 
        }
        else if (cn.getRe() > 0 && cn.getIm() <= 0){
           φ = - Math.round((180/Math.PI)*Math.acos(cn.getIm()*(-1)/cn.getModule()) * 100)*0.01;
        }
        return φ;
    }
 
    @Override
    public String toString() {
        String string;
        if (im == 1 || im == -1) {
            if (re == 0) {
                string = sign() + "i";
            } else {
                string = Double.toString(re) + sign() + im + "i";
            }
        } else {
            string = Double.toString(re) + sign() + Double.toString(Math.abs(im)) + "i";
        }
        return string;
    }
 
    @Override
    public boolean equals(Object obj) {
        if (this.getClass() != obj.getClass() || obj == null)
            return false;
        return true;
    
    }
    
}