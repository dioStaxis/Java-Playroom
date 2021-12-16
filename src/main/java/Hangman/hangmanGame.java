package Hangman;

import java.util.Scanner;

public class hangmanGame {
    //------------------------------------------------------------------------------------------------------------------
    public hangmanGame(Scanner input){
        data data = new data();
        functions functions = new functions(data);
        data.setRun(true);
        data.resetTally();
        data.setAnswer(dictionary.getWord());
        data.setAnswerAsArray();
        data.setPlayerArray();
        data.setValidInput(false);
        //execute(data, functions, input);
        functions.execute(data, input);
    }
    //------------------------------------------------------------------------------------------------------------------
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        functions functions = new functions();
        do{
            hangmanGame game = new hangmanGame(input);
        }while(functions.playAgain(input));
    }
}