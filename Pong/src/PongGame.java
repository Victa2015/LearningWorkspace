import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class PongGame extends JComponent implements ActionListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int ballX = 400;
	private int ballY = 150;
	private int paddleX = 0;
	private int ballYSpeed =20;
	private int ballXSpeed = 15;

	public static void main(String[] args) {
		JFrame window = new JFrame("Pong Game by Victor");
		PongGame game =new PongGame();
		window.add(game);
		window.pack();
		window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
		
		Timer t = new Timer(100, game);
		t.start();
		
		window.addMouseMotionListener(game);
		

	}

	public Dimension getPreferredSize() {
		return new Dimension(800, 600);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// Draw the sky
		g.setColor(new Color(178, 233, 224));
		g.fillRect(00, 0, 800, 600);
		// Draw the paddle
		g.setColor(new Color(110, 65, 13));
		g.fillRect(paddleX, 550, 150, 16);
		// Draw the ball
		g.setColor(new Color(155, 93, 169));
		g.fillOval(ballX, ballY, 30, 30);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ballX = ballX + ballXSpeed;
		ballY = ballY+ballYSpeed;
		if(ballX >= paddleX && ballX <=paddleX + 150 && ballY >= 510){
			ballYSpeed = -7;
		}
		if (ballX >=800-30){
			ballXSpeed = ballXSpeed * -1;
		}
		if(ballY <=0){
			ballYSpeed = ballYSpeed;
		}
		if(ballX<=0){
			ballXSpeed =ballXSpeed;
		}
		repaint();
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		paddleX = e.getX() - 75;
		repaint();
		
	}

}
