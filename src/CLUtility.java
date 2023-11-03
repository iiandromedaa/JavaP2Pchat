import java.io.IOException;
import java.util.Scanner;

public class CLUtility {

    //private constructor so u dont end trying to instantiate this
    private CLUtility() {}

    /**
     * @param prompt String that prompts the user to enter an integer input
     * @param bound Highest value that can be inputted
     * @param scanscan The scanner that will be used (duh)
     * @return valid input for switch statement
     */
    public static int switchValidator(String prompt, int bound, Scanner scanscan) {
        System.out.println(prompt);
        while(true){
            try {
                int inty = Integer.parseInt(scanscan.next());
                if (inty <= bound)
                    return inty;
                System.out.println("Invalid input.\n"+prompt);
            } catch(NumberFormatException ne) {
                System.out.println("Invalid f input.\n"+prompt);
            }
        }
    }

    /**
     * @param os that string that we grab at the start of the runtime
     */
    public static void clear(String os) {
        try {
            if (os.contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }  
    }

}
