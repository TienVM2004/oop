import java.util.Arrays;
import java.util.Scanner;
/*
 Shape data for ShapeClient:
 "0 0  0 1  1 1  1 0"
 "10 10  10 11  11 11  11 10"
 "0.5 0.5  0.5 -10  1.5 0"
 "0.5 0.5  0.75 0.75  0.75 0.2"
*/
public class ShapeClient {
    public static void main(String[] args){
        String[] coordinates = {"0 0  0 1  1 1  1 0", "10 10  10 11  11 11  11 10", "0.5 0.5  0.5 -10  1.5 0", "0.5 0.5  0.75 0.75  0.75 0.2"};

        Shape[] shapes = new Shape[4];
        for(int i=0;i<4;i++){
            shapes[i] = new Shape(coordinates[i]);
        }
        for(int i=1;i<4;i++){
            System.out.println("a crossed "+(char)('a'+i)+":"+shapes[0].cross(shapes[0],shapes[i]));
        }
        for(int i=1;i<4;i++){
            System.out.println("a encircles "+(char)('a'+i)+":"+shapes[0].encircle(shapes[0],shapes[i]));
        }
    }
}
