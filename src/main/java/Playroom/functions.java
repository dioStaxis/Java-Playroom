package Playroom;

import Hangman.hangmanGame;
import TicTacToe.tttGame;

import java.util.Scanner;

public class functions {
    public boolean playAgain(Scanner scanner){
        boolean validReply = false;
        boolean play = false;
        do{
            System.out.println("Play again? (Yes/No)");
            String reply = scanner.next();
            if(reply.equalsIgnoreCase("yes")
                    ||reply.equalsIgnoreCase("y")){
                play = true;
                validReply = true;
            }
            else if(reply.equalsIgnoreCase("no")
                    ||reply.equalsIgnoreCase("n")){
                play = false;
                validReply = true;
            }
            else{
                System.out.println("Not a valid answer, please reply with (Yes/y or No/n)");
            }
        }while(!validReply);
        return play;
    }

    public void playGames(Scanner scanner){
        boolean playGames = true;
        do{
            intro();
            String reply = scanner.next();
            if(reply.equalsIgnoreCase("1")){
                hangManLoop(scanner);
            }
            else if(reply.equalsIgnoreCase("2")){
                tttLoop(scanner);
            }
            else if(reply.equalsIgnoreCase("q")||reply.equalsIgnoreCase("quit")){
                playGames = false;
            }
            else{
                System.out.println("Not a valid answer, please reply with a valid game number!");
            }
        }while(playGames);
    }
    public void hangManLoop(Scanner scanner){
        do{
            hangmanGame game = new hangmanGame(scanner);
        }while(playAgain(scanner));
    }
    public void tttLoop(Scanner scanner){
        do{
            tttGame game = new tttGame(scanner);
        }while(playAgain(scanner));
    }

    public static void intro(){
        System.out.println("Welcome to the lobby!");
        System.out.println("Here are the games available, type in the corresponding number to play that game!");
        System.out.println("1. Hangman");
        System.out.println("2. Tic-tac-toe");
        System.out.println("Quit/Q to stop playing.");
    }
}
