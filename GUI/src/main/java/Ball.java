import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Ball extends JComponent {
    protected int radius;
    protected int dx;
    protected int dy;
    protected int x;
    protected int y;
    Ball(int r, int vx, int vy){
        radius = r;
        dx = vx;
        dy = vy;
        x = 100;
        y = 100;
    }

    List<Observer> observers = new ArrayList<>();
    public void register (Observer observer){
        observers.add(observer);
    }
    public void unregister(Observer observer){
        observers.remove(observer);
    }
    public void notifi(){
        for(Observer ob : observers){
            ob.notification();
        }
    }
    public void changeX(){
        dx = dx * -1;
    }
    public void changeY(){
        dy = dy * -1;
    }


    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.fillOval(x, y, radius, radius);
    }
    public void move() {
        if(MoveOrNot.Move) {
            x += dx;
            y += dy;
            if ((x < 500 && x > 0) && (y > 500 - 2 * radius || y < 0)) {
                changeY();
                notifi();
            } else if ((x > 500 - radius || x < 0) && (y < 500 && y > 0)) {
                changeX();
                notifi();
            }
            repaint();
        }
    }
    public void check(Frame1 frame){


    }
}
