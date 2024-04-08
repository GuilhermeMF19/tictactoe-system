package boardgame;

public abstract class Player {
	
	protected int[] trying = new int[2];
    protected int player;

    
    public Player(int player){
        this.player = player;
    }
    
    public abstract void jogar(Board board);
    
    public abstract void Tentativa(Board board);

    public boolean checkTrying(int[] tentativa, Board board){
        if(board.getPosition(trying) == 0)
            return true;
        else
            return false;
            
    }

}
