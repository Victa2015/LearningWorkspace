package intro;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Gui2 extends JFrame {
	private JTextField tf;
	private JCheckBox boldbox;
	private JCheckBox italicbox;
	private JButton btn;

	public Gui2() {
		super("Checkbobs");
		setLayout(new FlowLayout());
		

		tf = new JTextField("This is a sentence", 20);
		tf.setFont(new Font("Serif", Font.PLAIN, 14));
		btn = new JButton("Submit");

		
		boldbox = new JCheckBox("Bold");
		italicbox = new JCheckBox("italic");
		add(tf);
		add(boldbox);
		add(italicbox);
		HandlerClass handler = new HandlerClass();
		boldbox.addItemListener(handler);
		italicbox.addItemListener(handler);
		add(btn);
		JSpinner spin = new JSpinner();
		add(spin);
		JColorChooser chooser = new JColorChooser();
	
		add(chooser);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				JOptionPane.showMessageDialog(null, "Thanks");
				

			}
		});

	}

	private class HandlerClass implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent event) {

			Font font = null;
			if (boldbox.isSelected() && italicbox.isSelected()) {
				font = new Font("Serif", Font.BOLD + Font.ITALIC, 14);

			} else if (boldbox.isSelected()) {
				font = new Font("Serif", Font.BOLD, 14);
			} else if (italicbox.isSelected()) {
				font = new Font("Serif", Font.ITALIC, 14);
			} else {
				font = new Font("Serif", Font.PLAIN, 14);
			}
			tf.setFont(font);

		}

	}
}
