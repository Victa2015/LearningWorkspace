package intro;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.event.*;


public class Gui4  extends JFrame{
	private JComboBox box;
	private JLabel picture;
	private static String[] filename = {"b.png","x.png"};
	
	private Icon[] pics = {new ImageIcon(getClass().getResource(filename[0 ]))};
	
	public Gui4(){
		super("Combo Box");
		setLayout(new FlowLayout());
		
		box = new JComboBox(filename);
		box.addItemListener(new ItemListener(){

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED)
					picture.setIcon(pics[box.getSelectedIndex()]);
			}
			
		});
		add(box);
		picture = new JLabel(pics[0]);
		add(picture);
	}
}
