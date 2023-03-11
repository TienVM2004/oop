import java.lang.Math;
/*
Area of a triangle.
Write a program TriangleArea.java that takes three command line inputs a, b, and c, representing the side lengths of a triangle
and prints the area of the triangle using Heron's formula
 area = sqrt(s(s-a)(s-b)(s-c)), where s = (a + b + c) / 2.
 */
public class AreaOfTriangle {
    public static void main(String[] args){
        double a = Double.parseDouble(args[0]);
        double b = Double.parseDouble(args[1]);
        double c = Double.parseDouble(args[2]);
        double p = (a+b+c)/2;
        double area = Math.sqrt(p*(p-a)*(p-b)*(p-c));
        System.out.println("Area of the triangle is: "+area);
    }
}
