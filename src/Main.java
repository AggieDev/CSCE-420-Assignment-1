
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		boolean[][] startMoves = new boolean[5][5];
		for(int i = 0; i < 5; i++)
		{
			for(int j = 0; j < 5; j++)
			{
				startMoves[i][j] = true;
			}
		}
		startMoves[0][0] = false;	//empty hole
		GameBoard board = new GameBoard(startMoves);
		System.out.println("Starting board:");
		board.print();
		
		Game game = new Game(board);
		game.start();
	}

}
