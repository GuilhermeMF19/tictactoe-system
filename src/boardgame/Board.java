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
	
	public int checkLine(){
        for(int line=0 ; line<3 ; line++){

            if( (board[line][0] + board[line][1] + board[line][2]) == -3)
                return -1;
            if( (board[line][0] + board[line][1] + board[line][2]) == 3)
                return 1;
        }
        
        return 0;
                
    }
	
	public int checkColumn(){
        for(int column=0 ; column<3 ; column++){

            if( (board[0][column] + board[1][column] + board[2][column]) == -3)
                return -1;
            if( (board[0][column] + board[1][column] + board[2][column]) == 3)
                return 1;
        }
        
        return 0;
                
    }
	
	public int checkDiagonals(){
        if( (board[0][0] + board[1][1] + board[2][2]) == -3)
            return -1;
        if( (board[0][0] + board[1][1] + board[2][2]) == 3)
            return 1;
        if( (board[0][2] + board[1][1] + board[2][0]) == -3)
            return -1;
        if( (board[0][2] + board[1][1] + board[2][0]) == 3)
            return 1;
        
        return 0;
    }
	
	public boolean completeBoard(){
        for(int line=0 ; line<3 ; line++)
            for(int column=0 ; column<3 ; column++)
                if( board[line][column]==0 )
                    return false;
        return true;
    }
}
