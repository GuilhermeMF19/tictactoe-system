package boardgame;

import java.util.Random;

public class Computer extends Player {

	public Computer(int player){
        super(player);
        System.out.println("Jogador 'Computador' criado!");
    }
    
    @Override
    public void Play(Board board){
    	Trying(board);
        board.setPosition(trying, player);
    }
    
    @Override
    public void Trying(Board board){
    	Random random = new Random();
        do {
            trying[0] = random.nextInt(3);
            trying[1] = random.nextInt(3);
        } while (!checkTrying(trying, board));
    }
}
