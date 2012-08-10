package buet.rafi.ticTackToe;
// Determines the next move

public class GameLogic 
{
	public static int checkWin()
	{
		for(int i = 0; i < 3; i++)
		{
			if((TicTacToe.gameBoard[3 * i + 1] == TicTacToe.gameBoard[3 * i + 2]) && (TicTacToe.gameBoard[3 * i + 2] == TicTacToe.gameBoard[3 * i + 3]))
			{
				if(TicTacToe.gameBoard[3 * i + 1] == TicTacToe.PLAYER)
					return TicTacToe.PLAYER;
				else if(TicTacToe.gameBoard[3 * i + 1] == TicTacToe.PC)
					return TicTacToe.PC;
			}
			
			if((TicTacToe.gameBoard[i + 1] == TicTacToe.gameBoard[i + 4]) && (TicTacToe.gameBoard[i + 4] == TicTacToe.gameBoard[i + 7]))
			{
				if(TicTacToe.gameBoard[i + 1] == TicTacToe.PLAYER)
					return TicTacToe.PLAYER;
				else if(TicTacToe.gameBoard[i + 1] == TicTacToe.PC)
					return TicTacToe.PC;
			}
		}
		
		if((TicTacToe.gameBoard[1] == TicTacToe.gameBoard[5]) && (TicTacToe.gameBoard[5] == TicTacToe.gameBoard[9]))
		{
			if(TicTacToe.gameBoard[1] == TicTacToe.PLAYER)
				return TicTacToe.PLAYER;
			else if(TicTacToe.gameBoard[1] == TicTacToe.PC)
				return TicTacToe.PC;
		}
		
		if((TicTacToe.gameBoard[3] == TicTacToe.gameBoard[5]) && (TicTacToe.gameBoard[5] == TicTacToe.gameBoard[7]))
		{
			if(TicTacToe.gameBoard[3] == TicTacToe.PLAYER)
				return TicTacToe.PLAYER;
			else if(TicTacToe.gameBoard[3] == TicTacToe.PC)
				return TicTacToe.PC;
		}
		
		return TicTacToe.EMPTY;
	}
	
	public static void nextMove()
	{
		int movePosition = 0;
		
		for(int i = 0; i < 3; i++)
		{
			if(TicTacToe.gameBoard[3 * i + 1] != TicTacToe.EMPTY && (TicTacToe.gameBoard[3 * i + 1] == TicTacToe.gameBoard[3 * i + 2]))
			{
				movePosition = 3 * i + 3;
				
				if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
				{
					TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
					return;
				}
			}
			
			if(TicTacToe.gameBoard[3 * i + 1] != TicTacToe.EMPTY && (TicTacToe.gameBoard[3 * i + 1] == TicTacToe.gameBoard[3 * i + 3]))
			{
				movePosition = 3 * i + 2;
				
				if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
				{
					TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
					return;
				}
			}
			
			if(TicTacToe.gameBoard[3 * i + 3] != TicTacToe.EMPTY && (TicTacToe.gameBoard[3 * i + 3] == TicTacToe.gameBoard[3 * i + 2]))
			{
				movePosition = 3 * i + 1;
				
				if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
				{
					TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
					return;
				}
			}
			
			/**********************************************************************************************************************************************/			
			
			if(TicTacToe.gameBoard[i + 1] != TicTacToe.EMPTY && (TicTacToe.gameBoard[i + 1] == TicTacToe.gameBoard[i + 4]))
			{
				movePosition = i + 7;
				
				if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
				{
					TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
					return;
				}
			}
			
			if(TicTacToe.gameBoard[i + 1] != TicTacToe.EMPTY && (TicTacToe.gameBoard[i + 1] == TicTacToe.gameBoard[i + 7]))
			{
				movePosition = i + 4;
				
				if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
				{
					TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
					return;
				}
			}
			
			if(TicTacToe.gameBoard[i + 4] != TicTacToe.EMPTY && (TicTacToe.gameBoard[i + 7] == TicTacToe.gameBoard[i + 4]))
			{
				movePosition = i + 1;
				
				if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
				{
					TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
					return;
				}
			}			
		}
		
		if(TicTacToe.gameBoard[1] != TicTacToe.EMPTY && (TicTacToe.gameBoard[1] == TicTacToe.gameBoard[5]))
		{
			movePosition = 9;
			
			if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
			{
				TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
				return;
			}
		}
		
		if(TicTacToe.gameBoard[1] != TicTacToe.EMPTY && (TicTacToe.gameBoard[1] == TicTacToe.gameBoard[9]))
		{
			movePosition = 5;
			
			if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
			{
				TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
				return;
			}
		}
		
		if(TicTacToe.gameBoard[5] != TicTacToe.EMPTY && (TicTacToe.gameBoard[5] == TicTacToe.gameBoard[9]))
		{
			movePosition = 1;
			
			if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
			{
				TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
				return;
			}
		}
		
		/***********************************************************************************************************************************/
		
		if(TicTacToe.gameBoard[3] != TicTacToe.EMPTY && (TicTacToe.gameBoard[3] == TicTacToe.gameBoard[5]))
		{
			movePosition = 7;
			
			if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
			{
				TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
				return;
			}
		}
		
		if(TicTacToe.gameBoard[3] != TicTacToe.EMPTY && (TicTacToe.gameBoard[3] == TicTacToe.gameBoard[7]))
		{
			movePosition = 5;
			
			if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
			{
				TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
				return;
			}
		}
		
		if(TicTacToe.gameBoard[5] != TicTacToe.EMPTY && (TicTacToe.gameBoard[5] == TicTacToe.gameBoard[7]))
		{
			movePosition = 3;
			
			if(TicTacToe.gameBoard[movePosition] == TicTacToe.EMPTY)
			{
				TicTacToe.gameBoard[movePosition] = TicTacToe.PC;
				return;
			}
		}
		
		int randomPosition;
		
		do
		{
			randomPosition = TicTacToe.positonDeterminar.getNext();
			
		} while(TicTacToe.gameBoard[randomPosition] != TicTacToe.EMPTY);
		
		TicTacToe.gameBoard[randomPosition] = TicTacToe.PC;
	}
}
