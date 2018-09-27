public class superBoard {

		Board[] superBoard = new Board[9];
		
		public void makeSuperBoard() {
			
			
			for(int i = 0; i<9;i++) {
				
				superBoard[i] = new Board();
				
				for(int j = 0; j<9;j++) {
					
					superBoard[i].board[j] = Integer.toString(j+1);
				}
			}
		}
		
		public superBoard fillSuperBoard(int x, int y, String z) {
			
			if((!(superBoard[x-1].board[y-1].equals("X")||superBoard[x-1].board[y-1].equals("O")))){
				
				superBoard[x-1].fill(y,z);
			}
			return this;
		}
		
		public void printSuperBoard() {
		
			//row 1
			System.out.println("|---|---|---||---|---|---||---|---|---||");
			for(int i = 0;i<3;i++) {
				System.out.print("| "+ superBoard[0].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 0;i<3;i++) {
				System.out.print( "| "+superBoard[1].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 0;i<3;i++) {
				System.out.print("| "+ superBoard[2].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|---|---|---||---|---|---||---|---|---||");
			
			
			//row 2
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[0].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[1].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[2].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|---|---|---||---|---|---||---|---|---||");
			
			
			//row 3
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[0].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[1].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[2].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|=====================================||");
			
			//row 4
			
			for(int i = 0;i<3;i++) {
				System.out.print("| "+ superBoard[3].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 0;i<3;i++) {
				System.out.print("| "+ superBoard[4].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 0;i<3;i++) {
				System.out.print("| "+ superBoard[5].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|---|---|---||---|---|---||---|---|---||");
			
			
			//row 5
			
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[3].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[4].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[5].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|---|---|---||---|---|---||---|---|---||");
			
			//row 6
			
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[3].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[4].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[5].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|=====================================||");
			
			//row 7
			
			for(int i = 0;i<3;i++) {
				System.out.print("| "+ superBoard[6].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 0;i<3;i++) {
				System.out.print("| "+ superBoard[7].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 0;i<3;i++) {
				System.out.print("| "+ superBoard[8].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|---|---|---||---|---|---||---|---|---||");
			
			//row8
			
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[6].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[7].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 3;i<6;i++) {
				System.out.print("| "+ superBoard[8].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|---|---|---||---|---|---||---|---|---||");
			
			//row 9
			
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[6].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[7].board[i]+" ");
			}
			System.out.print("|");
			for(int i = 6;i<9;i++) {
				System.out.print("| "+ superBoard[8].board[i]+" ");
			}
			System.out.println("||");
			System.out.println("|=====================================||");
			
		}
		
	}
			
		
			
