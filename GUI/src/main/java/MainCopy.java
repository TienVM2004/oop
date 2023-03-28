import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainCopy {
    public static void main(String[] args){
        Frame1 frame1 = new Frame1();
        Frame2 frame2 = new Frame2();
        frame1.getBall().register(frame2);
        frame1.go();


    }


}
















