package intro;

import java.awt.*;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Gui5 extends JFrame {

	private JList list;

	private static String[] colornames = { "black", "blue", "red", "white" };
	private static Color[] colors = { Color.BLACK, Color.BLUE, Color.RED, Color.white };

	public Gui5() {
		super("title");
		setLayout(new FlowLayout());

		list = new JList(colornames);
		list.setVisibleRowCount(4);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		add(new JScrollPane(list));
		
		
		list.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent e) {
				getContentPane().setBackground(colors[list.getSelectedIndex()]);
				
			}
			
		});

	}

}
