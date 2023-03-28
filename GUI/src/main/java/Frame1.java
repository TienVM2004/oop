import javax.swing.*;
import java.awt.*;

public class Frame1 extends Observer{
    //all Frame1's components
    private JFrame frame1;
    private int width;
    private int height;
    private Ball ball;

    //constructor
    Frame1(){
        ball = new Ball(30, 2, 1);
        frame1 = new JFrame("lmaolmaolmao");
        width = 500;
        height = 500;
        frame1.setSize(width, height);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.add(ball);
        frame1.setVisible(true);
    }

    //functions
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public void moveBall(){
        ball.move();
    }
    public Ball getBall(){
        return ball;
    }
    public void go(){
        while(true){
            moveBall();
            try {
                Thread.sleep(10); // wait for 50 milliseconds
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void notification() {

    }
}
