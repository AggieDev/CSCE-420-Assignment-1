import java.util.ArrayList;

public class Main {

	private static int singlePegGame;
	private static int singlePegCornerGame;
	
	public static void main(String[] args) {
		
		//make sure to increase heap size
		//to print a board, call board.printBoard();
		//to print moves list for a board, call board.printValidMoves();
		
		singlePegGame = 0;
		singlePegCornerGame = 0;
		
		GameBoard board = new GameBoard(0, 0);
//		board.printBoard();
//		board.printValidMoves();
		
		BoardTree top = new BoardTree(board);		
		System.out.println("Running....");
		runGames(top);

		System.out.println("===============================================");
		System.out.println("Final Statistics:");
		System.out.println("Games with single peg at finish: " + singlePegGame);		//should be 29760
		System.out.println("Games with single peg at corner: " + singlePegCornerGame);
	}
	
	public static void runGames(BoardTree node)
	{
		node.populateTree();
		//node.getBoard().printBoard();
		ArrayList<BoardTree> thisNodeChildTrees = node.getChildTrees();
		if(thisNodeChildTrees.size() > 0)
		{
			for(int i = 0; i < thisNodeChildTrees.size(); i++)
				runGames(thisNodeChildTrees.get(i));
		}
		else	//game is complete
		{
			if(node.getBoard().isSinglePeg())
			{
				singlePegGame++;
				if(node.getBoard().isSingleCornerPeg())
					singlePegCornerGame++;
			}
		}
	}
}
