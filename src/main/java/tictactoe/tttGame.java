package tictactoe;

import java.util.Scanner;

public class tttGame {
    int[][] state;
    public tttGame(Scanner scanner){
        functions functions = new functions();
        state = new int[][]{
                {0,0,0},
                {0,0,0},
                {0,0,0},
        };
        functions.executeGame(state, scanner);
    }
    public static void main(String[]args) {
        functions f = new functions();
        Scanner scanner = new Scanner(System.in);
        do {
            tttGame game = new tttGame(scanner);
        } while (f.playAgain(scanner));
    }
}
