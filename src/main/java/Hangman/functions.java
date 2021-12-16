package Hangman;

import java.util.Scanner;
import java.io.*;

public class functions {
    data d;
    public functions(data data){
         this.d = data;
    }
    public functions(){}

    public void print(String string){
        System.out.println(string);
    }

    public boolean winOrLose(boolean run){
        //run variable passed in is true
        //Set run to false, as win/lose check will set run to true if game in progress
        run = false;
        //Game is won: run = false;
        //Game is lost: run = false;
        //Game is ongoing: run = true;
        //Win check
        for (int i = 0; i < d.getPlayerArray().length; i++){ //Iterate through player's array
            if(d.getPlayerArrayAt(i) == '_'){ //If there are any blanks, game still in progress
                //Game is still in progress
                run = true;
            }
        }
        if(run){ //If game still in progress after win check, check lose
            System.out.println(states.getGallows(d.getTally()));
            if (d.getTally() == 8) {// Lose check
                print("Game over!");
                print("The word was "+d.getAnswer()+", better luck next time!");
                run = false;
            }
        }
        else{ //If game not in progress after win check, game won
            d.printPlayerArray();
            print("You win!!");
        }
        return run;
    }

    public boolean playAgain(Scanner scanner){
        boolean validReply = false;
        boolean play = false;
        do{
            System.out.println("Play again? (Yes/No)");
            String reply = scanner.next();
            if(reply.equalsIgnoreCase("yes")
                    ||reply.equalsIgnoreCase("Yes")
                    ||reply.equalsIgnoreCase("y")
                    ||reply.equalsIgnoreCase("Y")){
                play = true;
                validReply = true;
            }
            else if(reply.equalsIgnoreCase("no")
                    ||reply.equalsIgnoreCase("No")
                    ||reply.equalsIgnoreCase("n")
                    ||reply.equalsIgnoreCase("N")){
                play = false;
                validReply = true;
            }
            else{
                System.out.println("Not a valid answer, please reply with (Yes/yes/Y/y or No/no/N/n)");
            }
        }while(!validReply);
        return play;
    }
    //------------------------------------------------------------------------------------------------------------------
    public void execute(data d, Scanner scanner){
        print("Game Start!");
        //Print state of the gallows
        System.out.println(states.getGallows(d.getTally()));
        //While run is true, execute game
        while(d.getRun()){
            //Print the word as viewed by the player
            d.printPlayerArray();
            //Await input
            do{
                d.setInput(scanner.next());
                //Compare input against prior guesses
                if(d.getInput().length() != 1)
                    print("Please enter one character");
                else if(d.getGuessAL().contains(d.getInput()))
                    print("You already guessed that!");
                else
                    d.setValidInput(true);
            }while(!d.getValidInput());
            d.setValidInput(false);
            if(!d.compare(d.getInput())){
                d.incrementTally();
                d.addToMisses(d.getInput());
            }
            d.addToGuessAL(d.getInput());
            print("Misses: "+d.getMisses());
            print("Guesses: "+d.getGuessALAsString());
            //Check win/lose
            d.setRun(winOrLose(d.getRun()));
        }
    }
}
