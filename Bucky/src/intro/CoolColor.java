package intro;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CoolColor extends JFrame{
	private JButton b;
	private Color color = (Color.white);
	private JPanel panel;
	public CoolColor(){
		super("Colr");
		panel = new JPanel();
		panel.setBackground(color);
		b = new JButton("Choose a Color");
		b.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				color = JColorChooser.showDialog(null, "Choose A Color", color);
				if(color ==null)
					color = (Color.white);
				
				panel.setBackground(color);
				
			}
			
		});
		
		add(panel, BorderLayout.CENTER);
		add(b,  BorderLayout.SOUTH);
		setSize(425,150);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
