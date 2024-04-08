package boardgame;

public class Board {

	private int[][] board = new int[3][3];
	
	public Board(){
        clearScreen();
    }
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public void showBoard(){
        System.out.println();
        for(int line=0 ; line<3 ; line++){
        
            for(int column=0 ; column<3 ; column++){
                
                if(board[line][column]==-1){
                    System.out.print(" X ");
                }
                if(board[line][column]==1){
                    System.out.print(" O ");
                }
                if(board[line][column]==0){
                    System.out.print("   ");
                }
                
                if(column==0 || column==1)
                    System.out.print("|");
            }
            System.out.println();
        }
                
    }
	
	public int getPosition(int[] trying){
        return board[trying[0]][trying[1]];
    }
	
	public void setPosition(int[] trying, int player){
        if(player == 1)
        	board[trying[0]][trying[1]] = -1;
        else
        	board[trying[0]][trying[1]] = 1;
        
        showBoard();
    }
}
