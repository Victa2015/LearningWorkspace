package intro;

import javax.swing.*;
import java.awt.*;

public class DGraphics extends JPanel {

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(Color.WHITE);
				g.setColor(Color.blue);
		g.fillRect(25, 2, 100, 30);
		g.setColor(new Color(10,245,13));
		g.fillRect(25, 65, 100, 30);
		g.setColor(Color.red);
		g.drawString("This is some text", 25, 130);
		 g.draw3DRect(34, 34, 100, 200, true);

	}
}
