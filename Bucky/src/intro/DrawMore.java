package intro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class DrawMore extends JPanel{
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		this.setBackground(Color.white);
		
		g.setColor(Color.BLUE);
		g.drawLine(10, 25, 200, 45);
		g.setColor(Color.RED);
		g.fillOval(10, 95, 100, 30);
		
		g.setColor(Color.orange);
		
		
		g.fill3DRect(10, 160, 100, 50, true);
		
	}
	

}
