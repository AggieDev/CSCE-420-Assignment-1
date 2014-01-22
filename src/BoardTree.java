import java.util.ArrayList;


public class BoardTree {

	private GameBoard thisNodeBoard;
	private ArrayList<BoardTree> childTrees = new ArrayList<BoardTree>();
	
	public BoardTree(GameBoard gb)
	{
		thisNodeBoard = gb;
	}
	
	public void populateTree()
	{
		childTrees = new ArrayList<BoardTree>();
		ArrayList<GameBoard> boardChildren = thisNodeBoard.getChildren();
		for(int i = 0; i < boardChildren.size(); i++)
			childTrees.add(new BoardTree(boardChildren.get(i)));
	}
	
	public ArrayList<BoardTree> getChildTrees()
	{
		return childTrees;
	}
	
	public GameBoard getBoard()
	{
		return thisNodeBoard;
	}
	
	public boolean hasChildren()
	{
		return childTrees.size() > 0;
	}
}
