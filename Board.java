public class Board {

	 String[] board = new String[9];
	 
	
	public void makeBoard() {
		
		for(int i = 0; i< 9; i++) {
			
			board[i] = Integer.toString(i+1);
		}
	}
	
	public void printBoard() {
		
		System.out.println("-------------");
		for(int i = 0; i<3; i++) {
			System.out.print("| "+ board[i]+" ");
		}
		System.out.println("|");
		System.out.println("-------------");
		
		for(int i=3;i<6; i++) {
			System.out.print("| "+ board[i]+" ");
		}
		System.out.println("|");
		System.out.println("-------------");
		
		for(int i=6;i<9; i++) {
			System.out.print("| "+ board[i]+" ");
		}
		System.out.println("|");
		System.out.println("-------------");
	}
	
	public Board fill(int x, String y){
		if(board[x-1]!="X" && board[x-1]!= "O") {
		board[x-1] = y;
		}
		return this;
}
}

