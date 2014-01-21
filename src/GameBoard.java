
public class GameBoard {
	public boolean[][] currentMoves = new boolean[5][5];
	
	public GameBoard(boolean[][] moves)
	{
		currentMoves = moves;
	}
	
	public void print()
	{
		String lineString = "";
		for(int i = 0; i < 5; i++)
		{
			lineString = "";
			for(int j = 0; j < 5; j++)
			{
				int rowNum;
				if(i == 0)
				{
					if(lineString.isEmpty())
						lineString = "    ";
					rowNum = 1;
				}
				else if(i == 1)
				{
					if(lineString.isEmpty())
						lineString = "   ";
					rowNum = 2;
				}
				else if(i == 2)
				{
					if(lineString.isEmpty())
						lineString = "  ";
					rowNum = 3;
				}
				else if(i == 3)
				{
					if(lineString.isEmpty())
						lineString = " ";
					rowNum = 4;
				}
				else
				{
					if(lineString.isEmpty())
						lineString = "";
					rowNum = 5;
				}
				
				if(j <= i)
				{
					if(currentMoves[i][j])
						lineString += "1 ";
					else
						lineString += "0 ";
				}
			}
			if(!lineString.isEmpty())
				System.out.println(lineString);
		}
	}
}
