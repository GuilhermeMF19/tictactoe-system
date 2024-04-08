package boardgame;

import java.util.Scanner;
import boardgame.Board;

public class Game {

	private Board tabuleiro;
    private int rodada=1, vez=1;
    private Player jogador1;
    private Player jogador2;
    public Scanner entrada = new Scanner(System.in);
    
    public Game(){
        board = new Board();
        initPlayers();
        
        while( Play() );
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
            option = entrada.nextInt();
            
            if(option != 1 && option != 2)
                System.out.println("Opção inválida! Tente novamente");
        }while(option != 1 && option != 2);
        
        return option;
    }
    
    public boolean Jogar(){
        if(winner() == 0 ){
            System.out.println("----------------------");
            System.out.println("\nRodada "+ round);
            System.out.println("É a vez do jogador " + turn() );
            
            if(turn()==1)
                player1.play(board);
            else
                player2.play(board);
            
            
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
        if(tabuleiro.checkLine() == 1)
            return 1;
        if(tabuleiro.checkColumn() == 1)
            return 1;
        if(tabuleiro.checkDiagonals() == 1)
            return 1;
        
        if(tabuleiro.checkLine() == -1)
            return -1;
        if(tabuleiro.checkColumn() == -1)
            return -1;
        if(tabuleiro.checkDiagonals() == -1)
            return -1;
        
        return 0;
    }
}
