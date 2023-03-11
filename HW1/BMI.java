/*Body mass index. The body mass index (BMI)
is the ratio of the weight of a person (in kilograms) to the square of the height (in meters).
Write a program BMI.java that takes two command-line arguments, weight and height, and prints the BMI.
 */
public class BMI {
    public static void main(String[] args){
        double weight = Double.parseDouble(args[0]);
        double height = Double.parseDouble(args[1]);
        double BMI = weight/(height*height);
        System.out.println("Your Body Mass Index is: "+BMI);
    }
}
