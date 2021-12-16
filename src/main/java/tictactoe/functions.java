package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class functions {
    int player1 = 1;
    int player2 = 2;

    public void executeGame(int[][] array, Scanner scanner){
        println("Game start!");
        while(playerTurn(scanner, player1, array) && playerTurn(scanner,player2, array));
    }

    public void println(String string){
        System.out.println(string);
    }
    public void print(String string){
        System.out.print(string);
    }
    public void print(int[][] array){
        printHBarLength(1);
        for(int outer = 0; outer < array.length; outer++){
            printVBar("left");
            for(int inner = 0; inner <array[outer].length; inner++){
                print(toToken(array[outer][inner])+" ");
            }
            printVBar("right");
        }
        printHBarLength(1);
    }
    public void printTutorial(int[][] array){
        int tutorialNum = 0;
        printHBarLength(2);
        for(int outer = 0; outer < array.length; outer++){
            printVBar("left");
            for(int inner = 0; inner <array[outer].length; inner++){
                print(toToken(array[outer][inner])+" ");
            }
            printVBar("middle");
            for(int secondary  = 0; secondary < array[outer].length; secondary++){
                print(++tutorialNum+" ");
            }
            printVBar("right");
        }
        printHBarLength(2);
    }
    public void printHBarLength(int length){
        if(length == 1)
            System.out.println(" -------");
        if(length == 2)
            System.out.println(" -------       -------");
    }
    public void printVBar(String location){
        if(location.equals("left"))
            System.out.print("| ");
        if(location.equals("middle"))
            System.out.print("|  -  | ");
        if(location.equals("right"))
            System.out.println("|");
    }
    public char toToken(int num){
        if(num == 1)
            return 'X';
        else if (num == 2)
            return 'O';
        else return '-';
    }

    public boolean scan(int[][] array, int player){
        return checkWin(array, player, 1, 2, 3)
        /*123*/ || checkWin(array, player, 1, 4, 7)
        /*456*/ || checkWin(array, player, 1, 5, 9)
        /*789*/ || checkWin(array, player, 2, 5, 8)
                || checkWin(array, player, 3, 5, 7)
                || checkWin(array, player, 3, 6, 9)
                || checkWin(array, player, 4, 5, 6)
                || checkWin(array, player, 7, 8, 9);
    }
    public boolean checkWin(int[][] array, int player, int location1, int location2, int location3){
        int a1 = (location1-1)/3;
        int b1 = (location1-1)%3;
        int a2 = (location2-1)/3;
        int b2 = (location2-1)%3;
        int a3 = (location3-1)/3;
        int b3 = (location3-1)%3;
        return (array[a1][b1] == player && array[a2][b2] == player && array[a3][b3] == player);
    }
    public boolean playAgain(Scanner scanner){
        boolean validReply = false;
        boolean play = false;
        do{
            println("Play again? (Yes/No)");
            String reply = scanner.next();
            switch (reply) {
                case "y":
                case "Y":
                case "yes":
                case "Yes":
                    play = true;
                    validReply = true;
                    break;
                case "n":
                case "N":
                case "no":
                case "No":
                    play = false;
                    validReply = true;
                    break;
                default:
                    println("Not a valid answer, please reply with (Yes/yes/Y/y or No/no/N/n)");
            }
        }while(!validReply);
        return play;
    }
    public boolean playerTurn(Scanner scanner, int player, int[][] array){
        println("Player "+player+"'s turn!");
        while(!getNumberInput(scanner, player, array));
        return checkRunning(array, player);
    }
    public boolean getNumberInput(Scanner scanner, int player, int[][] array){
        printTutorial(array);
        println("Where do you want to go?");
        try{
            int input = scanner.nextInt();
            if(input >=1 && input <=9)
                return setArray(array, input, player);
            else {
                println("Please input a number (1-9) that has not been picked.");
                return false;
            }
        }catch(InputMismatchException e){
            scanner.nextLine();
            println("Please input a number (1-9)");
            return false;
        }
    }
    public boolean checkRunning(int[][] array, int player){
        if(scan(array, player)){
            println("Game over! Player "+player+" wins!");
            print(array);
            return false;
        }
        else
            return true;
    }
    public boolean setArray(int[][] array, int location, int player){
        int a = (location-1)/3;
        int b = (location-1)%3;
        if(array[a][b] == 0) {
            array[a][b] = player;
            return true;
        }
        else {
            println("Spot already taken");
            return false;
        }
    }
}