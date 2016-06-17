package intro;

import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Gui extends JFrame{
	private JButton reg;
	private JButton custom;
	
	public Gui(){
		super("This is the title for my window...");
		setLayout(new FlowLayout());
		
		reg = new JButton("Regular"); 
		add(reg);
		Icon b = new ImageIcon(getClass().getResource("b.png"));
		Icon x = new ImageIcon(getClass().getResource("x.png"));
		custom = new JButton(b);
		custom.setRolloverIcon(x);
		add(custom);
		
		HandlerClass handler = new HandlerClass();
		reg.addActionListener(handler);
		custom.addActionListener(handler);
	}
	private class HandlerClass implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, String.format("%s", e.getActionCommand()));
			
		}
		
	}

}
