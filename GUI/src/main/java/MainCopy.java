import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainCopy {
    private JFrame frame1;
    private JLabel label1;
    public static void main(String[] args){
        MainCopy gui = new MainCopy();
        gui.go();
    }
    public void go(){
        frame1 = new JFrame();
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JButton labelButton = new JButton("lmao");
        labelButton.addActionListener(new LableListener());
        JButton colorButton = new JButton("lmaolmao");
        colorButton.addActionListener(new ColorListener());
        label1 = new JLabel("a label");

        frame1.getContentPane().add(BorderLayout.SOUTH, colorButton);
        //frame1.getContentPane().add(BorderLayout.SOUTH, colorButton);
        frame1.getContentPane().add(BorderLayout.EAST, labelButton);
        frame1.getContentPane().add(BorderLayout.NORTH, label1);

        frame1.setSize(500,400);
        frame1.setVisible(true);

    }
    class LableListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            label1.setText("ia chay");
        }
    }
    class ColorListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            label1.setText("ia chay");
        }
    }

}
















