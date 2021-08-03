public class Drawer {
    static String[] hangmanDrawing = {
            "_______\n |    |\n      |\n      |\n      |\n",
            "_______\n |    |\n O    |\n      |\n      |\n",
            "_______\n |    |\n O    |\n |    |\n      |\n",
            "_______\n |    |\n O    |\n/|    |\n      |\n",
            "_______\n |    |\n O    |\n/|\\   |\n      |\n",
            "_______\n |    |\n O    |\n/|\\   |\n/     |\n",
            "_______\n |    |\n O    |\n/|\\   |\n/ \\   |\n"
    };
    public static void hangmanBoardDrawer(int incorrectGuesses){
        System.out.println(hangmanDrawing[incorrectGuesses]);
    }

}
