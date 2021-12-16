package Hangman;

import java.io.*;
import java.util.Random;

public class dictionary {
    private static String word;


    public static String getWord(){

        Random rand = new Random();
        int num = rand.nextInt(127142)+1;
        File dict = new File("./src/main/resources/wordDictionary");
        System.out.println(num);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(dict));
            if(num == 0){
                word = reader.readLine();
            }
            else {
                for (int i = 0; i < num; i++)
                    reader.readLine();
                word = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException exception) {
            exception.printStackTrace();
        }

        return word;
    }
}
