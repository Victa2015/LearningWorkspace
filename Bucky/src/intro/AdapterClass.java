package intro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdapterClass  extends JFrame{
	
	private String details;
	private JLabel statusbar;
	
	public AdapterClass(){
		super("titel");
		
		statusbar = new JLabel("Default");
		add(statusbar, BorderLayout.SOUTH);
		addMouseListener(new Mouseclass());
		
	}
	
	private class Mouseclass extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			details = String.format("You Clicked %d times ", e.getClickCount() );
			
			if(e.isMetaDown())
				details += "with the right mouse button";
			else if(e.isAltDown())
				details += "with the center mouse button";
			else
				details += "with the left mouse button";
			statusbar.setText(details);
			
		}
		
	}
}
