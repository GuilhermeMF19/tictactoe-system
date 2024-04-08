package boardgame;

import java.util.Scanner;

public class Human extends Player {

	public Scanner sc = new Scanner(System.in);
	
	public Human(int player){
        super(player);
        this.player = player;
        System.out.println("Jogador 'Humano' criado!");
    }
	
	@Override
    public void Play(Board board){
        Trying(board);
        board.setPosition(trying, player);
    }
	
	@Override
    public void Trying(Board board){
        do{
            do{
                System.out.print("Linha: ");
                trying[0] = sc.nextInt();
                
                if( trying[0] > 3 ||trying[0] < 1)
                    System.out.println("Linha inválida. É 1, 2 ou 3");
                
            }while( trying[0] > 3 ||trying[0] < 1);
            
            do{
                System.out.print("Coluna: ");
                trying[1] = sc.nextInt();
                
                if(trying[1] > 3 ||trying[1] < 1)
                    System.out.println("Coluna inválida. É 1, 2 ou 3");
                
            }while(trying[1] > 3 ||trying[1] < 1);
            
            trying[0]--; 
            trying[1]--;
            
            if(!checkTrying(trying, board))
                System.out.println("Esse local já foi marcado. Tente outro.");
        }while( !checkTrying(trying, board) );
    }
}
