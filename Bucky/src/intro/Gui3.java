package intro;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.*;

public class Gui3 extends JFrame{
	private JTextField tf;
	private Font pf, bf, itf, bif;
	private JRadioButton pb, bb, ib, bib;
	private ButtonGroup group;
	
	public Gui3(){
		super("Tit");
		setLayout(new FlowLayout());
		
		tf = new JTextField("Victor is awesome and Hot", 20);
		add(tf);
		pb = new JRadioButton ("plain", true);
		bb = new JRadioButton ("bold", false);
		ib = new JRadioButton ("italic", false);
		bib = new JRadioButton ("bold and italic", false);
		add(pb);
		add(ib);
		add(bb);
		add(bib);
		
		group = new ButtonGroup();
		group.add(pb);
		group.add(bb);
		group.add(ib);
		group.add(bib);
		
		pf = new Font("Serif", Font.PLAIN,14);
		bf = new Font("Serif", Font.BOLD,14);
		bif = new Font("Serif", Font.BOLD+Font.ITALIC,14);
		itf = new Font("Serif", Font.ITALIC,14);
		tf.setFont(pf);
		
		pb.addItemListener(new HandlerClass(pf));
		ib.addItemListener(new HandlerClass(itf));
		bb.addItemListener(new HandlerClass(bf));
		bib.addItemListener(new HandlerClass(bif));
		
	}
	private class HandlerClass implements ItemListener{
		
		Font fonty;
		public HandlerClass(Font f){
			fonty = f;
		}
		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			tf.setFont(fonty);
		}
		
	}

}
