package Hangman;


public class states {
    public static String gallows;

    public static String getGallows(Integer num) {
        if (num == 0) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        \n" +
                    "     |       \n" +
                    "     |       \n" +
                    "     |       \n" +
                    "-------------------\n" +
                    "|                 |\n" +
                    "/                 \\";
        } else if (num == 1) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        O\n" +
                    "     |       \n" +
                    "     |        \n" +
                    "     |       \n" +
                    "-------------------\n" +
                    "|                 |\n" +
                    "/                 \\";
        } else if (num == 2) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        O\n" +
                    "     |        |\n" +
                    "     |        \n" +
                    "     |       \n" +
                    "-------------------\n" +
                    "|                 |\n" +
                    "/                 \\";
        } else if (num == 3) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        O\n" +
                    "     |       /|\n" +
                    "     |        \n" +
                    "     |       \n" +
                    "-------------------\n" +
                    "|                 |\n" +
                    "/                 \\";
        } else if (num == 4) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        O\n" +
                    "     |       /|\\\n" +
                    "     |        \n" +
                    "     |       \n" +
                    "-------------------\n" +
                    "|                 |\n" +
                    "/                 \\";
        } else if (num == 5) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        O\n" +
                    "     |       /|\\\n" +
                    "     |        ^\n" +
                    "     |            \n" +
                    "-------------------\n" +
                    "|                 |\n" +
                    "/                 \\";
        } else if (num == 6) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        O\n" +
                    "     |       /|\\\n" +
                    "     |        ^\n" +
                    "     |       / \n" +
                    "-------------------\n" +
                    "|                 |\n" +
                    "/                 \\";
        } else if (num == 7) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        O\n" +
                    "     |       /|\\\n" +
                    "     |        ^\n" +
                    "     |       / \\\n" +
                    "-------------------\n" +
                    "|                 |\n" +
                    "/                 \\";
        } else if (num == 8) {
            gallows = "     ----------\n" +
                    "     |        |\n" +
                    "     |        |\n" +
                    "     |        |\n" +
                    "     |        |\n" +
                    "     |        O\n" +
                    "     |       /|\\\n" +
                    "------------  ^  --\n" +
                    "|            / \\  |\n" +
                    "/                 \\ ";
        } else {
            //gallows = "Game over!";
        }
        return gallows;
    }
}