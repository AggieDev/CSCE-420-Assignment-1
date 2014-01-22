import java.util.ArrayList;

public class Move {
	
	public static ArrayList<Position> validMoves(GameBoard board, Position from)
	{
		ArrayList<Position> returnList = new ArrayList<Position>();
		//move 2 up
		try
		{
			Position move = new Position(from.row - 2, from.col);
			//make sure peg 2 away is open and that the one you're jumping isnt
			if(board.isOpen(move) && !board.isOpen(new Position(from.row - 1, from.col)))
				returnList.add(move);
		}catch(Exception e)
		{}
		//move 2 down
		try
		{
			Position move = new Position(from.row + 2, from.col);
			//make sure peg 2 away is open and that the one you're jumping isnt
			if(board.isOpen(move) && !board.isOpen(new Position(from.row + 1, from.col)))
				returnList.add(move);
		}catch(Exception e)
		{}
		//move 2 left
		try
		{
			Position move = new Position(from.row, from.col - 2);
			//make sure peg 2 away is open and that the one you're jumping isnt
			if(board.isOpen(move) && !board.isOpen(new Position(from.row, from.col - 1)))
				returnList.add(move);
		}catch(Exception e)
		{}
		//move 2 right
		try
		{
			Position move = new Position(from.row, from.col + 2);
			//make sure peg 2 away is open and that the one you're jumping isnt
			if(board.isOpen(move) && !board.isOpen(new Position(from.row, from.col + 1)))
				returnList.add(move);
		}catch(Exception e)
		{}
		//move 2 diagonal up-left
		try
		{
			Position move = new Position(from.row - 2, from.col - 2);
			//make sure peg 2 away is open and that the one you're jumping isnt
			if(board.isOpen(move) && !board.isOpen(new Position(from.row - 1, from.col - 1)))
				returnList.add(move);
		}catch(Exception e)
		{}
		//move 2 diagonal down-right
		try
		{
			Position move = new Position(from.row + 2, from.col + 2);
			//make sure peg 2 away is open and that the one you're jumping isnt
			if(board.isOpen(move) && !board.isOpen(new Position(from.row + 1, from.col + 1)))
				returnList.add(move);
		}catch(Exception e)
		{}
		
		return returnList;
	}
	
	public static void printValidMoves(ArrayList<Position> list, Position p)
	{
		System.out.println("Open moves from " + p.toString() + ":" + list.toString());
	}
	
	public static GameBoard jump(GameBoard gb, Position from, Position to)
	{
		//copy the board to a new board
		GameBoard returnBoard = new GameBoard(gb);
		int[][] boardMoves = returnBoard.getCurrentMoves();
		boardMoves[from.row][from.col] = 0;	//from peg: now empty
		boardMoves[to.row][to.col] = 1;		//to peg: now has pin in it
		//position between the jump should now be empty
		boardMoves[(from.row + to.row)/2][(from.col + to.col)/2] = 0;
		returnBoard.setCurrentMoves(boardMoves);
		return returnBoard;
	}
}
