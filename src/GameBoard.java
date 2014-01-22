import java.util.ArrayList;


public class GameBoard {
	public int[][] currentMoves;
	
	public GameBoard(int row, int col)
	{
		currentMoves = new int[5][5];
		//set all to 1
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				currentMoves[i][j] = 1;
			}
		}
		//set invalid moves to -1, triangle will look like this
		//0 -1 -1 -1 -1
		//1  1 -1 -1 -1
		//1  1  1 -1 -1
		//1  1  1  1 -1
		//1  1  1  1  1
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(j > i)
					currentMoves[i][j] = -1;
			}
		}
		currentMoves[row][col] = 0;	//starting empty hole
	}
	
	//copy constructor
	public GameBoard(GameBoard gb)
	{
		currentMoves = new int[5][5];
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
				currentMoves[i][j] = gb.getCurrentMoves()[i][j];
		}
	}
	
	public boolean isOpen(Position p)
	{
		if(currentMoves[p.row][p.col] == 0)
			return true;
		else
			return false;
	}
	
	public void printBoard()
	{
		String lineString = "";
		for(int i = 0; i < 5; i++)
		{
			lineString = "";
			for(int j = 0; j < 5; j++)
			{
				if(i == 0)
				{
					if(lineString.isEmpty())
						lineString = "    ";
				}
				else if(i == 1)
				{
					if(lineString.isEmpty())
						lineString = "   ";
				}
				else if(i == 2)
				{
					if(lineString.isEmpty())
						lineString = "  ";
				}
				else if(i == 3)
				{
					if(lineString.isEmpty())
						lineString = " ";
				}
				else
				{
					if(lineString.isEmpty())
						lineString = "";
				}
				
				if(currentMoves[i][j] == 1)
					lineString += "1 ";
				else if(currentMoves[i][j] == 0)
					lineString += "0 ";
			}
			if(!lineString.isEmpty())
				System.out.println(lineString);
		}
	}
	
	public ArrayList<GameBoard> getChildren()
	{
		ArrayList<GameBoard> list = new ArrayList<GameBoard>();
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(currentMoves[i][j] == 1)
				{
					Position thisPosition = new Position(i,j);
					ArrayList<Position> validMoves = Move.validMoves(this, thisPosition);
					for(int k = 0; k < validMoves.size(); k++)
					{
						list.add(Move.jump(this, thisPosition, validMoves.get(k)));
					}
				}
			}
		}
		return list;
	}
	
	public void printValidMoves()
	{
		ArrayList<GameBoard> list = new ArrayList<GameBoard>();
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(currentMoves[i][j] == 1)
				{
					Position thisPosition = new Position(i,j);
					ArrayList<Position> validMoves = Move.validMoves(this, thisPosition);
					Move.printValidMoves(validMoves, thisPosition);
				}
			}
		}
	}
	
	

	public int[][] getCurrentMoves()
	{
		return currentMoves;
	}
	
	public void setCurrentMoves(int[][] setMoves)
	{
		currentMoves = setMoves;
	}
	
	public int numberOfMovesLeft()
	{
		ArrayList<Position> validMoves = new ArrayList<Position>();
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(currentMoves[i][j] == 1)
				{
					Position thisPosition = new Position(i,j);
					ArrayList<Position> thisPegValMoves = Move.validMoves(this, thisPosition);
					for(int k = 0; k < thisPegValMoves.size(); k++)
						validMoves.add(thisPegValMoves.get(k));
				}
			}
		}
		return validMoves.size();
	}
	
	public boolean isSinglePeg()
	{
		int pegCounter = 0;
		
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				if(currentMoves[i][j] == 1)
					pegCounter++;
			}
		}
		return pegCounter == 1;
	}
	
	//dont have to check that there's one peg on whole board, as it is only called if isSinglePeg() is already met, this is for efficiency
	public boolean isSingleCornerPeg()
	{ 
		int pegCounter = 0;
		if(currentMoves[0][0] == 1)
			pegCounter++;
		if(currentMoves[4][0] == 1)
			pegCounter++;
		if(currentMoves[4][4] == 1)
			pegCounter++;
		
		return pegCounter == 1;
	}
}
