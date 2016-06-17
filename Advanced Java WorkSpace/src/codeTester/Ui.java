package codeTester;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

class Ui extends JFrame 
{
    private JButton buzz = new JButton("BUZZ ME!!");
    public Ui ()
    {
        super("BUZZ Frame!!");
    }
    public void prepareGUI()
    {
        buzz.addActionListener(new BuzzActionListener(this));
        setSize(300,200);
        getContentPane().add(buzz,BorderLayout.NORTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String st[])
    {
        SwingUtilities.invokeLater ( new Runnable()
        {
            public void run()
            {
                Ui bFrame = new Ui();
                bFrame.prepareGUI();
                bFrame.setVisible(true);
            }
        });
    }
}
class BuzzActionListener implements ActionListener
{
    private JFrame frame;
    private Point currLocation;
    private int iDisplaceXBy = 50;
    private int iDisplaceYBy = -10;
    public BuzzActionListener(JFrame frame)
    {
        this.frame = frame;
    }
    public void actionPerformed(ActionEvent evt)
    {
        currLocation = frame.getLocationOnScreen();
        fireBuzzAction();
    }
    private void fireBuzzAction()
    {
        SwingUtilities.invokeLater ( new Runnable() 
        {
            public void run()
            {
                Point position1 = new Point( currLocation.x + iDisplaceXBy , currLocation.y );
                Point position2 = new Point( currLocation.x - iDisplaceXBy , currLocation.y - iDisplaceYBy );
                for (int i = 0; i < 20 ; i++)
                {
                    frame.setLocation(position1);
                    frame.setLocation(currLocation);
                    frame.setLocation(position2);
                }
                frame.setLocation(currLocation);
            }
        });
    }
}