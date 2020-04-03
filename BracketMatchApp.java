/**
 * @author Yurock Heo, Linh Nguyen
 * @since Mar 30, 2020
 * This class is a demonstration of BracketMatcher class
 */
import java.util.Scanner;

public class BracketMatchApp {
    public static void main(String[] args) {
        BracketMatcher check = new BracketMatcher();
        System.out.println("Write something with brackets");
        Scanner in = new Scanner(System.in);
        String s = in.next();
        if (check.checkBrackets(s))
            System.out.println("Your Bracket matches! Hooray ٩(˘◡˘)۶");
        else System.out.println("Your Bracket does not match ( ͡❛ ︹ ͡❛)");

    }
}
