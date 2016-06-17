package intro;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;


import javax.swing.JFrame;

import org.w3c.dom.css.RGBColor;

public class Gui7_Mouse extends JFrame{
	
	private JPanel mousepanel;
	private JLabel statusbar;
	
	public Gui7_Mouse(){
		
		super("Nice Mouse");
		
		mousepanel = new JPanel();
		mousepanel.setBackground(Color.white);
		add(mousepanel, BorderLayout.CENTER);
		
		statusbar = new JLabel(":)");
		add(statusbar, BorderLayout.SOUTH);
		
		HandlerClass handler = new HandlerClass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
		
		
	}
	
	private class HandlerClass implements MouseListener, MouseMotionListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			statusbar.setText(String.format("Clicked at %d,%d", e.getX(),e.getY()));
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			statusbar.setText("You Pressed the mouse");
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			//statusbar.setText();
			statusbar.setText("You Released the mouse");
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			statusbar.setText("You entered the area");
			mousepanel.setBackground(Color.gray);
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			statusbar.setText("You Left");
			mousepanel.setBackground(getBackground());
		}

		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
			statusbar.setText("You're Dragging the Mouse");
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		  
			statusbar.setText(String.format("%d,%d",e.getX(),e.getY()));
			
		}
		
	}
	
	
}
