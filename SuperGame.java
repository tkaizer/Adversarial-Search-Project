import java.util.ArrayList;
import java.util.Scanner;
public class SuperGame extends Game{

	static superBoard bigTest = new superBoard();
	static String player;
	static String me;
	//static int nextBoard;
//	static int alpha = -10;
//	static int beta = 10;
	
	public static void main(String[] args) {

		System.out.println("Would you like to play regular Tic-Tac-Toe (0) or Ultimate Tic-Tac-Toe(1)");
		Scanner choice = new Scanner(System.in);
		int resp = choice.nextInt();
		
		if(resp == 1){
		
		System.out.println("welcome to super tic tac toe");
		System.out.println();
		System.out.println("whoever goes first picks a board then a space");
		System.out.println("from then on each player must fill a spot");
		System.out.println("in the board corresponding to the space the last player filled");
		System.out.println();
		bigTest.makeSuperBoard();
		bigTest.printSuperBoard();
		System.out.println("would you like to go first(X) or second(O)");
		System.out.println("1 for yes 0 for no");
		Scanner scan = new Scanner(System.in);
		int response  = scan.nextInt();
		if(response==1) {
			player = "X";
			me = "O";
			System.out.println("pick a board followed by a space");
			int boardChoice = scan.nextInt();
			int space = scan.nextInt();
			//nextBoard = space;
			bigTest.fillSuperBoard(boardChoice, space, player);
			while(!superTerminal(bigTest, player, me)) {
				//bigTest.printSuperBoard();
				int next = ABSearch(bigTest, space);
				superYourMove(next);
				
			}
		}
		else {
			player = "O";
			me = "X";
			//nextBoard = 5;
			// bigTest.fillSuperBoard(5,5,me);
			// bigTest.printSuperBoard();
			System.out.println("went in board 5 space 5");
			while(!superTerminal(bigTest, player, me)) {
				superYourMove(ABSearch(bigTest, 5));
			}
		}
	}
	else if(resp == 0){
		Game G = new Game();
		G.playTTT();
	}
	}
	
	
	public static int superYourMove(int b) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("your move, input board followed by space");
		System.out.println("right now you can only go on board " + (b));
		int board = scan.nextInt();
		int space = scan.nextInt();
		bigTest.fillSuperBoard(board, space, player);
		bigTest.printSuperBoard();
		ABSearch(bigTest, space);
		//nextBoard = space;
		return space;
	}
	
	public static boolean superFull(superBoard x) {
		
		int count = 0;
		
		for(int i = 0; i<9;i++) {
			for(int j = 0; j<9;j++) {
				
				if(x.superBoard[i].equals("X")||x.superBoard[i].equals("O")) {
					count++;
				}
			}
		}
		if(count >=81) {
			return true;
		}
		return false;
	}
	
	public static boolean superTerminal(superBoard x, String y, String z) {
		
		for(int i = 0; i<9; i++) {
		
			if(winning(x.superBoard[i].board, y) || winning(x.superBoard[i].board, z)) {
				//x.printSuperBoard();
				return true;
			} 
			else if(superFull(x)) {
				System.out.println("its a tie!");
				return true;
			}
		}
		//System.out.println("false");
		return false;
	}
	
	public static int superUtility(superBoard x) {
		
		for(int i=0;i<9;i++) {
			
			if(winning(x.superBoard[i].board, player)) {
				return -10;
			}
			else if(winning(x.superBoard[i].board, me)) {
				return 10;
			}
		}
		return 0;
	}
	
	public static superBoard copySuperBoard(superBoard x) {
		
		superBoard newSuper = new superBoard();
		for(int i = 0; i<9;i++) {
			
			newSuper.superBoard[i] = new Board();
			newSuper.superBoard[i].board = copyBoard(x.superBoard[i]);
		}
		return newSuper;
	}
	
	public static boolean twoRow(String[] board, String player, String other) {
		
		 if ((board[0] == player && board[1] == player && board[2] != other) ||
				 (board[3] == player && board[4] == player && board[5] != other) ||
				 (board[6] == player && board[7] == player && board[8] != other) ||
				 (board[0] == player && board[3] == player && board[6] != other) ||
				 (board[1] == player && board[4] == player && board[7] != other) ||
				 (board[2] == player && board[5] == player && board[8] != other) ||
				 (board[0] == player && board[4] == player && board[8] != other) ||
				 (board[2] == player && board[4] == player && board[6] != other) ||
				 (board[0] == player && board[1] != other && board[2] == player) ||
				 (board[3] == player && board[4] != other && board[5] == player) ||
				 (board[6] == player && board[7] != other && board[8] == player) ||
				 (board[0] == player && board[3] != other && board[7] == player) ||
				 (board[2] == player && board[5] != other && board[8] == player) ||
				 (board[0] == player && board[4] != other && board[8] == player) ||
				 (board[2] == player && board[4] != other && board[6] == player) ||
				 (board[0] != other && board[1] == player && board[2] == player) ||
				 (board[3] != other && board[4] == player && board[5] == player) ||
				 (board[6] != other && board[7] == player && board[8] == player) ||
				 (board[0] != other && board[3] == player && board[6] == player) ||
				 (board[1] != other && board[4] == player && board[7] == player) ||
				 (board[2] != other && board[5] == player && board[8] == player) ||
				 (board[0] != other && board[4] == player && board[8] == player) ||
				 (board[2] != other && board[4] == player && board[6] == player)){
			 
			 return true;
		 }
		 return false;
	}
	
	public static int heuristic(Board x) {
		
		if(twoRow(x.board, me, player)) {
			return 1;
		}
		else if(twoRow(x.board,player, me)) {
			return -1;
		}
		return 0;
	}
	
	public static int ABmin(superBoard x,int board , int a, int b, int depth) {
		
		superBoard z = new superBoard();
		z = copySuperBoard(x);
		if(superTerminal(z, player,me)) {
			System.out.println("min utility is "+ superUtility(x));
			return superUtility(x);
		}
		if(depth > 3) {
			return heuristic(x.superBoard[board-1]);
		}
		x.printSuperBoard();
		int v = Integer.MAX_VALUE;
		ArrayList<Integer> empty = emptySpots(x.superBoard[board-1].board);
		
		for(int i = 0; i<empty.size();i++) {
			z = copySuperBoard(x);
			v = Math.min(v, ABmax(z.fillSuperBoard(board, empty.get(i), me), empty.get(i), a,b, depth+1))+heuristic(x.superBoard[board-1]);
			//nextBoard = empty.get(i);
			System.out.println("abMin done");
		}
		if(v<=a) {
			return v;
		}
		else {
			b = Math.min(v, b);
			return v;
		}
	}
	
public static int ABmax(superBoard x, int board,int a, int b, int depth) {
		
		superBoard z = new superBoard();
		z  = copySuperBoard(x);
		System.out.println();
		x.printSuperBoard();
		if(superTerminal(z,player,me)) {
			System.out.println("min utility is "+ superUtility(x));
			return superUtility(x);
		}
		if(depth > 3) {
			return heuristic(x.superBoard[board-1]);
		}
		int v = Integer.MIN_VALUE;
		ArrayList<Integer> empty = emptySpots(x.superBoard[board-1].board);
		
		for(int i = 0; i<empty.size();i++) {
			z = copySuperBoard(x);
			v = Math.max(v, ABmin(z.fillSuperBoard(board, empty.get(i), player), empty.get(i), a, b, depth+1))+heuristic(x.superBoard[board-1]);
			//nextBoard = empty.get(i);
			System.out.println("ABmax done");
		}
		if(v>=b) {
			return v;
		}
		else {
			a = Math.max(v, a);
			return v;
		}
	}

// public static int ABSearch(superBoard x, int board) {
	
// 	superBoard z = new superBoard();
// 	//int optUtil = -11;
// 	int saveBoard = board;
// 	int v = Integer.MIN_VALUE;
// 	superBoard saveB;
// 	saveB = copySuperBoard(x);
// 	int saveMove = 11;
// 	ArrayList<Integer> empty = emptySpots(x.superBoard[board-1].board);
// 	for(int i = 0; i< empty.size(); i++) {
		
// 		int a  =Integer.MIN_VALUE;
// 		int b  = Integer.MAX_VALUE;
// 		z = copySuperBoard(x);
// 		System.out.println("ab search");
// 		int optUtil = ABmin(z.fillSuperBoard(board, empty.get(i), me), board ,a,b, 0);
// 		board = saveBoard;
		
// 		if(v < optUtil) {
// 			optUtil = v;
// 			saveMove = empty.get(i);
// 			z.printSuperBoard();
// 		}
// 	}
// 	x.makeSuperBoard();
// 	x = copySuperBoard(saveB);
	
// 	if(!superFull(x)) {
// 		x.fillSuperBoard(board, saveMove, me);
// 		//board = saveMove;
// 	}
// 	System.out.println();
// 	x.printSuperBoard();
// 	System.out.println("printed AB board");
// 	return saveMove;
	
// }
	public static int ABSearch(superBoard x, int board){
		
		int opUtil = -11;
		superBoard saveBoard = new superBoard();
		// for(int i = 0;i<9;i++){

		// 	saveBoard.superBoard[i].board = copyBoard(x.superBoard[i]);
		// }
		saveBoard = copySuperBoard(x);
		
		
		int saveMove = 11;
		ArrayList<Integer> empty = emptySpots(x.superBoard[board].board);
		superBoard z = new superBoard();
		saveBoard = copySuperBoard(x);
		for(int i =0; i<empty.size(); i++) {
			z = copySuperBoard(x);
			z.printSuperBoard();
			int a = Integer.MIN_VALUE;
			int b = Integer.MAX_VALUE;
			int util = ABmin(z.fillSuperBoard(board, empty.get(i),me),board, a,b,0);
			//System.out.println("fakefill minimax");
			if(util > opUtil ){
				opUtil = util;
				//System.out.println("better util");
				saveMove = empty.get(i);
				z.printSuperBoard();
			}
		}
		x.makeSuperBoard();
		for(int i = 0; i<9;i++){
			x.superBoard[i].board = copyBoard(saveBoard.superBoard[i]);
		}
		if(!superFull(bigTest)) {
			x.superBoard[board-1].fill(saveMove, me);
		}
		//System.out.println("filled");
		x.printSuperBoard();
		System.out.println("went in board " + board + " space "+ saveMove);
		for(int i = 0; i<empty.size();i++){
			System.out.print(empty.get(i));
		}
		return saveMove;
		
	}
}
