package Hangman;

import java.util.ArrayList;

public class data {

    //String input
    private String input;
    public String getInput(){
        return this.input;
    }
    public void setInput(String string){
        this.input = string;
    }

    //ArrayList of type string, stores guesses made by the player
    private ArrayList<String> guessAL = new ArrayList<String>();
    public String getGuessALAsString(){
        return this.guessAL.toString();
    }
    public void addToGuessAL(String string){
        this.guessAL.add(string);
    }
    public ArrayList<String> getGuessAL(){
        return this.guessAL;
    }


    //String misses, contains misses made by the player
    private String misses = "";
    public String getMisses(){
        return this.misses;
    }
    public void addToMisses(String string){
        this.misses += string+" ";
    }

    //boolean to store state of valid input
    private boolean validInput;
    public boolean getValidInput(){
        return this.validInput;
    }
    public void setValidInput(boolean state){
        this.validInput = state;
    }

    //boolean to store state of game run
    private boolean run;
    public boolean getRun(){
        return this.run;
    }
    public void setRun(boolean val){
        this.run = val;
    }

    //int to store amount of player misses, game lost at 8 misses
    private int tally;
    public void setTally(int val) {
        this.tally = val;
    }
    public void resetTally(){
        this.tally = 0;
    }
    public void incrementTally(){
        this.tally++;
    }
    public int getTally() {
        return this.tally;
    }

    //String to store the answer
    private String answer;
    public void setAnswer(String val) {
        this.answer = val;
    }
    public String getAnswer(){
        return this.answer;
    }

    //char array storing answer in array form
    private char answerAsArray[];
    public void setAnswerAsArray() {
        this.answerAsArray = answer.toCharArray();
    }
    public char[] getAnswerAsArray(){
        return this.answerAsArray;
    }
    public char getAnswerAsArrayAt(int i){
        return this.answerAsArray[i];
    }

    //char array storing the answer as seen by the player
    private char playerArray[];
    public void setPlayerArray(){
        char temp[] = new char[this.answerAsArray.length];
        this.playerArray = temp;
        for (int i = 0; i < this.answerAsArray.length; i++){
            this.playerArray[i] = '_';
        }
    }
    public void setPlayerArrayAt(int pos, char c){
        this.playerArray[pos] = c;
    }
    public void printPlayerArray(){
        for(int i = 0; i < this.playerArray.length; i++){
            System.out.print(this.playerArray[i]+" ");
        }
    }
    public char[] getPlayerArray(){
        return this.playerArray;
    }
    public char getPlayerArrayAt(int i){
        return this.playerArray[i];
    }

    //compares passed input to each value in answerAsArray, if correct, updates corresponding letter in player's array
    //returns true if found a match, otherwise false
    public boolean compare(String input) {
        int counter = 0;
        for(int i = 0; i < getAnswerAsArray().length; i++){
            if(getInput().charAt(0) == getAnswerAsArrayAt(i)){
                setPlayerArrayAt(i,getInput().charAt(0));
            }
            else{
                counter++;
            }
        }
        if(counter == getAnswerAsArray().length){
            return false;
        }
        else{
            return true;
        }
    }
}
