// 02 May 2012

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class TicTacToe extends JPanel
{
	static int gameBoard[] = new int[10];
	static Position positonDeterminar = new Position();
	
	static final int EMPTY = 0;
	static final int PLAYER = 1;
	static final int PC = 2;

	//private static JButton playButton;
	
	private static Timer timer;
	private static final ImageIcon board =  new ImageIcon("Images/Tic Tac Toe.jpg");	
	private static final ImageIcon PC_MOVE = new ImageIcon("Images/Move1.jpg");
	private static final ImageIcon PLAYER_MOVE = new ImageIcon("Images/Move2.jpg");
	private static final ImageIcon WIN = new ImageIcon("Images/You Win.jpg");
	private static final ImageIcon LOST = new ImageIcon("Images/You Lost.jpg");
	private static final ImageIcon DRAWN = new ImageIcon("Images/Game Drawn.jpg");
	
	private ImageIcon status;
	int firstPlayer = PLAYER;
	int currentPlayer;
	
	static int pcWin = 0;
	static int playerWin = 0;
	
	private int blockWidth;
	private int blockHeight;
	
	private int height;
	private int width;
	
	public TicTacToe()
	{		
		height = board.getIconHeight();
		width = board.getIconWidth();
		
		blockHeight = (int) ((board.getIconHeight() - 20) / 3.0);
		blockWidth = (int) ((board.getIconWidth() / 1.65) / 3.0);
		
		timer = new Timer(100, new TimerListener());
		
		this.addMouseListener(
				new MouseAdapter()
				{
					public void mouseClicked(MouseEvent event)
					{
						if(currentPlayer == PLAYER)
						{
							if(playerMove(event.getX(), event.getY()) == true)
							{
								return;
							}
						}
					}
				}
			);

		/*playButton = new JButton("Play");
		add(playButton, BorderLayout.SOUTH);		
		playButton.addActionListener(
				new ActionListener()
				{
					public void actionPerformed(ActionEvent event)
					{						
						playGame();						
					}
				}
			);*/
	}
	
	public void playGame() throws InterruptedException
	{
		currentPlayer = firstPlayer;
		
		if(firstPlayer == PLAYER)
			firstPlayer = PC;
		else
			firstPlayer = PLAYER;
		
		positonDeterminar.init(); 
		
		for(int i = 0; i < 10; i++)
			gameBoard[i] = EMPTY;
		
		int winner = TicTacToe.EMPTY;
		
		status = null;
		
		repaint();
		
		for(int i = 0; i < 9; i++)
		{
			
			/*for(int j = 1; j < 10; j++)
				if (TicTacToe.gameBoard[j] != TicTacToe.EMPTY)
					System.out.printf("%3d", j);
			System.out.println();*/
			
			if(currentPlayer == PLAYER)
			{
				while(currentPlayer != PC)
					Thread.sleep(300);
				repaint();
			}
			else
			{
				GameLogic.nextMove();
				currentPlayer = PLAYER;
				repaint();
			}
			
			winner = GameLogic.checkWin();
			
			if(winner != TicTacToe.EMPTY)
			{
				if(winner == TicTacToe.PLAYER)
				{
					status = WIN;
					playerWin++;
				}
				else
				{
					status = LOST;
					pcWin++;
				}
				repaint();
				return;
			}
		}
		
		status = DRAWN;
		repaint();
	}
	
	private boolean playerMove(int x, int y)
	{
		int block;
		
		for(int j = 0; j < 3; j++)
		{
			for(int i = 0; i < 3; i++)
			{
				if((x > i * blockWidth + 10 && x < (i + 1) * blockWidth) && (y > j * blockHeight + 10 && y < (j + 1) * blockWidth))
				{
					block = j * 3 + (i + 1);
					
					if(gameBoard[block] == EMPTY)
					{
						gameBoard[block] = PLAYER;
						currentPlayer = PC;
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		board.paintIcon(this, g, 0, 0);
		
		if(status != null)
			status.paintIcon(this, g, 366, 216);
		
		for(int j = 0; j < 3; j++)
		{
			for(int i = 0; i < 3; i++)
			{
				int block = j * 3 + (i + 1);
				
				if(gameBoard[block] == PLAYER)
					PLAYER_MOVE.paintIcon(this, g, i * blockWidth + 35, j * blockHeight + 35);
				else if(gameBoard[block] == PC)
					PC_MOVE.paintIcon(this, g, i * blockWidth + 35, j * blockHeight + 35);
			}
		}
		
		g.setFont(new Font("Serif", Font.BOLD + Font.ITALIC, 26));
		
		g.setColor(Color.GRAY);
		g.drawString("You : " + playerWin, 410, 140);
		
		g.setColor(Color.GRAY);
		g.drawString(" PC : " + pcWin, 410, 195);
	}
	
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(width, height);
	}
	
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			
		}
	}
}
