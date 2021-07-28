public class Drawer {


    public static void main(String[] args) {
        hangmanBoardDrawer(6);
    }

    public static void hangmanBoardDrawer(int incorrectGuesses){
        String[] hangmanDrawing = {"_______\n |    |\n      |\n      |\n      |\n",
                "_______\n |    |\n O    |\n      |\n      |\n","_______\n |    |\n O    |\n |    |\n      |\n",
                "_______\n |    |\n O    |\n/|    |\n      |\n","_______\n |    |\n O    |\n/|\\   |\n      |\n",
                "_______\n |    |\n O    |\n/|\\   |\n/     |\n",
                "_______\n |    |\n O    |\n/|\\   |\n/ \\   |\n"};
        System.out.println(hangmanDrawing[incorrectGuesses]);

    }
}
