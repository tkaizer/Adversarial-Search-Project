/*
Tom Kaizer
CSC242 Project 1: Tic Tac Toe

*/
import java.util.Scanner;
import java.util.ArrayList;
public class Game {

	static Scanner scan = new Scanner(System.in);
	static String player;
	static String me;
	static Board test = new Board();
	
	public static void playTTT() {
		
		System.out.println("Welcome to Tic Tac Toe!!!");
		System.out.println();
		System.out.println("let me explain the format before I beat you");
		System.out.println("each turn I will print out the board, each spot on the board will have a corresponding number");
		System.out.println("use this number to pick where you want to go. The number setup looks like this");
		System.out.println();
		test.makeBoard();
		test.printBoard();
		System.out.println("Would you like to go first? (1 for yes 0 for no)");
		int response = scan.nextInt();
		
		if(response == 1) {
			System.out.println("you are X. Input the number you want to fill");
			player = "X";
			me = "O";
			while(!terminal(test,player,me)) {
				if(!terminal(test,player,me)) {
				yourMove();
				minimax(test);
				//System.out.println("comp move");
				}
				else {
					System.out.println("tie");
				}
			}
		}
		else if(response == 0){
			System.out.println("you are O");
			player = "O";
			me = "X";
			while(!terminal(test,player,me)) {
				if(!terminal(test,player,me)) {
				minimax(test);
				yourMove();
			}
			}
		}
		
	}
	
	public static void yourMove() {
		
		Scanner move = new Scanner(System.in);
		System.out.println("your move");
		int response = move.nextInt();
		test.fill(response, player);
		test.printBoard();
	}
	
	public void Comp() {
		
	}
	
	public static ArrayList<Integer> emptySpots(String[] x) {
		
		ArrayList<Integer> empty= new ArrayList<Integer>();
		
		for(int i = 0; i<x.length; i++) {
			if(!(x[i].equals("O") || x[i].equals("X"))) {
				String move = x[i];
				empty.add(Integer.parseInt(move));
			}
		}
		return empty;
	}
	
	public static boolean winning(String[] board, String player){
		 if ((board[0] == player && board[1] == player && board[2] == player) ||
		 (board[3] == player && board[4] == player && board[5] == player) ||
		 (board[6] == player && board[7] == player && board[8] == player) ||
		 (board[0] == player && board[3] == player && board[6] == player) ||
		 (board[1] == player && board[4] == player && board[7] == player) ||
		 (board[2] == player && board[5] == player && board[8] == player) ||
		 (board[0] == player && board[4] == player && board[8] == player) ||
		 (board[2] == player && board[4] == player && board[6] == player)) {
			 System.out.println(player + " Wins");
		 return true;
		 }
	    else {
		 return false;
		 }
		}
	
	public static int utility(String[] board) {
		
		if(winning(board, player)) {
			return -1;
		}
		else if(winning(board, me)) {
			return 1;
		}
		else if(full(board)){
			return 0;
		}
		return 0;
	}
	
	public static boolean full(String[] x) {
		
		int count = 0;
		for(int i =0; i<x.length; i++) {
			if(x[i].equals("X") || x[i].equals("O")) {
				count++;
			}
		}
		if(count >= 9 ) {
			return true;
		}
		return false;
	}
	
	public static boolean terminal(Board x, String y, String z) {
		
		if(winning(test.board, y) || winning(test.board, z)) {
			x.printBoard();
			return true;
		}
		else if(full(x.board)) {
			System.out.println("its a tie!");
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int min(Board x) {
		
		int v = 11;
		//x.printBoard();
		ArrayList<Integer> empty = emptySpots(x.board);
		Board z = new Board();
		z.board = copyBoard(x);
		if(terminal(x,player,me)== true) {
			System.out.println("min utility is "+ utility(z.board));
			return utility(z.board);
		}
		else {
			for(int i = 0; i < empty.size(); i++) {
				z.board = copyBoard(x);
				v = (Math.min(v, max(z.fill(empty.get(i),me)))); 
				System.out.println("min" + v);
			}
			return v;
		}
	}
	
	public static String[] copyBoard(Board x) {
		String[] newBoard = new String[x.board.length];
		for(int i =0; i<x.board.length;i++ ) {
			newBoard[i]=x.board[i];
		}
		return newBoard;
	}
	
	public static int max(Board x) {
		
		int v = -11;
		ArrayList<Integer> empty = emptySpots(x.board);
		//System.out.println("# possible moves: " + empty.size());
		Board z = new Board();
		z.board = copyBoard(x);
		if(terminal(z,player,me)==true) {
			System.err.println("max utility is "+ utility(z.board));
			return utility(z.board);
		}
		else {
			for(int i = 1; i < empty.size(); i++) {
				z.board = copyBoard(x);
				v = (Math.max(v, min(z.fill(empty.get(i),player)))); 
				System.out.println("max:" + v);
			}
			return v;
		}
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
	
	public static int heuristic(boolean x){
		if(x){
			return 0;
		}
		else{
			return 1;
		}
	}
	public static int minimax(Board x){
		
		int optUtil = Integer.MIN_VALUE;
		Board saveBoard = new Board();
		saveBoard.board = copyBoard(x);
		
		int saveMove = 5;
		ArrayList<Integer> empty = emptySpots(x.board);
		Board z = new Board();
		z.board = copyBoard(x);

		int[] utils = new int[empty.size()];

		for(int i =0; i<empty.size(); i++) {
			//System.out.println("action " + );
			z.board = copyBoard(x);
			//z.printBoard();
			int util = min(z.fill(empty.get(i),me))+ heuristic(twoRow(z.board,player,me));

			utils[i] = util;

			System.out.println(util);
			//System.out.println(util);
			if(util > optUtil ){
				optUtil = util;
				//System.out.println("better util");
				saveMove = empty.get(i);
				z.printBoard();
			}
		}
		x.makeBoard();
		x.board = saveBoard.board;
		if(!full(test.board)) {
			x.fill(saveMove, me);
		}
		//System.out.println("filled");

		for(int i=0;i<utils.length;i++){
			System.out.println("utility of move: " + empty.get(i) + " is " + utils[i]);
		}
		x.printBoard();
		return saveMove;
		
	}
	

	
}
