import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame2 extends Observer{
    private JFrame frame2;
    private JLabel Bounce;
    private int numBounce;
    private JButton toggle;


    Frame2(){
        frame2 = new JFrame("Observer");
        numBounce = 0;
        Bounce = new JLabel("Bounce " + numBounce);
        toggle = new JButton("Start");
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.getContentPane().add(BorderLayout.SOUTH, toggle);
        frame2.getContentPane().add(BorderLayout.NORTH, Bounce);
        toggle.addActionListener(new toggleListener()) ;


        frame2.setSize(600,100);
        frame2.setVisible(true);

    }
    public JFrame getFrame2(){
        return frame2;
    }
    class toggleListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            MoveOrNot.Move = !MoveOrNot.Move;
            if(MoveOrNot.Move){
                toggle.setText("Stop");
            }
            else{
                toggle.setText("Start");
            }

            }
        }

    @Override
    public void notification() {
        numBounce ++;
        Bounce.setText("Bounce " + numBounce);
    }
}
