
public class Position {
	public int row, col;
	
	public Position(int r, int c)
	{
		row = r;
		col = c;
	}
	
	@Override
	public String toString()
	{
		return "(" + row + "," + col + ")";
	}
}
