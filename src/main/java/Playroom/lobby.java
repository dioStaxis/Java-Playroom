package Playroom;

import java.util.Scanner;

public class lobby {
    public lobby() {
        Scanner scanner = new Scanner(System.in);
        functions functions = new functions();
        functions.playGames(scanner);
    }

    public static void main(String[]args){
        //Lobby for the game collection
        //starts a game based on user scanner
        //return here after game ends?
        lobby room = new lobby();
    }
}
