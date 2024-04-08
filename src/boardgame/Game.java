package boardgame;

import java.util.Scanner;

public class Game {

	private Board board;
    private int round=1, turn=1;
    private Player player1;
    private Player player2;
    public Scanner sc = new Scanner(System.in);
    
    public Game(){
        board = new Board();
        initPlayers();
        
        while( Playing() );
    }
    
    public void initPlayers(){
        System.out.println("Quem vai ser o Jogador 1 ?");
        if(choosePlayer() == 1)
            this.player1 = new Human(1);
        else
            this.player1 = new Computer(1);
        
        System.out.println("----------------------");
        System.out.println("Quem vai ser o Jogador 2 ?");
        
        if(choosePlayer() == 1)
            this.player2 = new Human(2);
        else
            this.player2 = new Computer(2);
        
    }
    
    public int choosePlayer(){
        int option=0;
        
        do{
            System.out.println("1. Humano");
            System.out.println("2. Computador\n");
            System.out.print("Opção: ");
            option = sc.nextInt();
            
            if(option != 1 && option != 2)
                System.out.println("Opção inválida! Tente novamente");
        }while(option != 1 && option != 2);
        
        return option;
    }
    
    public boolean Playing(){
        if(winner() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nRodada "+ round);
            System.out.println("É a vez do jogador " + turn() );
            
            if(turn()==1)
                player1.Play(board);
            else
                player2.Play(board);
            
            
            if(board.completeBoard()){
                System.out.println("Tabuleiro Completo. Jogo empatado");
                return false;
            }
            turn++;
            round++;

            return true;
        } else{
            if(winner() == -1 )
                System.out.println("Jogador 1 ganhou!");
            else
                System.out.println("Jogador 2 ganhou!");
            
            return false;
        }
            
    }
    
    public int turn(){
        if(turn%2 == 1)
            return 1;
        else
            return 2;
    }
    
    public int winner(){
        if(board.checkLine() == 1)
            return 1;
        if(board.checkColumn() == 1)
            return 1;
        if(board.checkDiagonals() == 1)
            return 1;
        
        if(board.checkLine() == -1)
            return -1;
        if(board.checkColumn() == -1)
            return -1;
        if(board.checkDiagonals() == -1)
            return -1;
        
        return 0;
    }
}
