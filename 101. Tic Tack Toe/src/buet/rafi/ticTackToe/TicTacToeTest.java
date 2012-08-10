package buet.rafi.ticTackToe;
// 02 May 2012

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import javax.swing.JButton;
import javax.swing.JFrame;

public class TicTacToeTest 
{
	private static JFrame ticTackToeFrame;
	private static TicTacToe gamePanel;
	
	public static void main(String args[]) throws InterruptedException
	{
		ticTackToeFrame = new JFrame("Tic Tack Toe");;
		gamePanel = new TicTacToe();
		
		ticTackToeFrame.setLayout(new BorderLayout());
		ticTackToeFrame.add(gamePanel, BorderLayout.CENTER);
		
		ticTackToeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ticTackToeFrame.pack();
		ticTackToeFrame.setLocation(350, 200);
		ticTackToeFrame.setVisible(true);
		
		while(true)
		{			
			gamePanel.playGame();
			Thread.sleep(2000);
		}
	}
}
