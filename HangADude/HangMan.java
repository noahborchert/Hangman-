import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.Scanner;
import java.io.*;
/**
 * The central hub of hanging dudes.
 *
 * @Noah Borchert
 * @v1
 */
public class HangMan
{
    public static String leftArm = "\\";
    public static String rightArm = "/";
    public static String leftLeg = "\\";
    public static String rightLeg = "/";
    public static String door = "================";
    public static String noDoor = "                ";
    public static boolean isLeftArm = true;
    public static boolean isRightArm = true;
    public static boolean isLeftLeg = true;
    public static boolean isrightLeg = true;
    public static String under = "";
    public static int count = 0;
    
    public static void main() throws InterruptedException
    {
        titleIntro();
        System.out.println("What phrase would you like to play?");
        Scanner in = new Scanner(System.in);
        String text =  in.nextLine();
        text = text.toLowerCase();
        clearScreen();
        printHang();
        System.out.println("");
        System.out.println("");
        System.out.println("Player, here's your empty phrase \n");
        System.out.print("");
        for(int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) == ' ')
            {
                under += " ";
            }
            else
            {
                under += "_";
            }

        }
        char[] answer = under.toCharArray();
        System.out.println(answer);
        System.out.println("");
        System.out.println("");
        System.out.println("");

        System.out.print("Can you guess a few letters to save a man's life?");
        delayDots(3);
        System.out.println("Let's find out");
        delayDots(3);

        while(underscoreCheck(answer) && count < 7)
        {
            System.out.println("Please enter a character: ");
            String guess1 = in.next();
            char guess = guess1.charAt(0);
            boolean right = false;

            for(int i = 0; i < text.length(); i++)
            {
                if(text.charAt(i) == guess)
                {
                    answer[i] = guess;
                    right = true;
                }
            }
            if(right == false)
            {
                clearScreen();
                printHang();
                System.out.println("Wrong move, buddy...");
                count++;
            }
            if(count >= 6)
            {
                clearScreen();
                printHang();
                System.out.println("game over");
            }
            System.out.println(answer);
        }
    }

    public static boolean underscoreCheck(char[] u)
    {
        for(char c: u)
        {
            if(c == '_')
            {
                return true;
            }
        }
        return false;
    }

    public static String titleIntro() throws InterruptedException
    {
        System.out.println("");
        System.out.print("booting");
        delayDots(3);
        System.out.println("");
        System.out.print("welcome to");
        delayDots(3);
        System.out.println("\n \n");
        System.out.println("  ▄         ▄  ▄▄▄▄▄▄▄▄▄▄▄  ▄▄        ▄  ▄▄▄▄▄▄▄▄▄▄▄        ▄▄▄▄▄▄▄▄▄▄▄        ▄▄▄▄▄▄▄▄▄▄   ▄         ▄  ▄▄▄▄▄▄▄▄▄▄   ▄▄▄▄▄▄▄▄▄▄▄       ▄ ");
        System.out.println(" ▐░▌       ▐░▌▐░░░░░░░░░░░▌▐░░▌      ▐░▌▐░░░░░░░░░░░▌      ▐░░░░░░░░░░░▌      ▐░░░░░░░░░░▌ ▐░▌       ▐░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░▌");
        System.out.println(" ▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀█░▌▐░░░▌     ▐░▌▐░█▀▀▀▀▀▀▀▀▀       ▐░█▀▀▀▀▀▀▀█░▌      ▐░█▀▀▀▀▀▀▀█░▌▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░▌");
        System.out.println(" ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌▐░▌    ▐░▌▐░▌                ▐░▌       ▐░▌      ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌               ▐░▌");
        System.out.println(" ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░▌ ▐░▌   ▐░▌▐░▌ ▄▄▄▄▄▄▄▄  ▄▄▄  ▐░█▄▄▄▄▄▄▄█░▌  ▄▄▄ ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░█▄▄▄▄▄▄▄▄▄      ▐░▌");
        System.out.println(" ▐░░░░░░░░░░░▌▐░░░░░░░░░░░▌▐░▌  ▐░▌  ▐░▌▐░▌▐░░░░░░░░▌ █▄█  ▐░░░░░░░░░░░▌  █▄█ ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░░░░░░░░░░░▌     ▐░▌");
        System.out.println(" ▐░█▀▀▀▀▀▀▀█░▌▐░█▀▀▀▀▀▀▀█░▌▐░▌   ▐░▌ ▐░▌▐░▌ ▀▀▀▀▀▀█░▌      ▐░█▀▀▀▀▀▀▀█░▌      ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░█▀▀▀▀▀▀▀▀▀      ▐░▌");
        System.out.println(" ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌    ▐░▌▐░▌▐░▌       ▐░▌      ▐░▌       ▐░▌      ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌       ▐░▌▐░▌                ▀ ");
        System.out.println(" ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌     ▐░▐░▌▐░█▄▄▄▄▄▄▄█░▌      ▐░▌       ▐░▌      ▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄█░▌▐░█▄▄▄▄▄▄▄▄▄       ▄ ");
        System.out.println(" ▐░▌       ▐░▌▐░▌       ▐░▌▐░▌      ▐░░▌▐░░░░░░░░░░░▌      ▐░▌       ▐░▌      ▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌▐░░░░░░░░░░▌ ▐░░░░░░░░░░░▌     ▐░▌");
        System.out.println("  ▀         ▀  ▀         ▀  ▀        ▀▀  ▀▀▀▀▀▀▀▀▀▀▀        ▀         ▀        ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀  ▀▀▀▀▀▀▀▀▀▀   ▀▀▀▀▀▀▀▀▀▀▀       ▀ ");
        System.out.println("+=========================================================================================================================================+");
        System.out.println("|Rules:                                                                                                                                   | \n");
        System.out.println("| ---------> You will be asked for a phrase to be used in the game                                                                        | \n");
        System.out.println("| ---------> The player will be given chances to guess a character in the mystery phrase                                                  | \n");
        System.out.println("| ---------> If the player guesses wrong, a stone will be thrown by the crowd at the innocently convicted man in the noose                |");
        System.out.println("|            which will damage a limb/body part                                                                                           | \n");
        System.out.println("| ---------> If the player guesses correctly, the letter will replace a dash as many times as it appears in the given phrase              | \n");
        System.out.println("| ---------> Once the entirety of the man has been damaged by the crowd, he will be hanged                                                | \n");
        System.out.println("| ---------> Don't let this man down                                                                                                      | \n");
        System.out.println("+=========================================================================================================================================+");
        return "";
    }

    public static String printHang()
    {
        if(count == 0)
        {
            System.out.println("");
            System.out.println("++===================== ]");
            System.out.println("|| //            |");
            System.out.println("||//             |");
            System.out.println("||            (⌣ ⌒ ⌣)");
            System.out.println("||               ⏌ ⎿");
            System.out.println("||             " + rightArm  + " || " + leftArm );
            System.out.println("||               ||             ⚪️");
            System.out.println("||               ++             |");
            System.out.println("||              " + rightLeg  + "  " + leftLeg + "            |");
            System.out.println("++--------" + door + "------⏜---++");
            System.out.println("||                                  ||");
            System.out.println("||                                  ||");
            System.out.println("||                                  ||");
            System.out.println("||\\\\                              //||");
            System.out.println("|| \\\\                            // ||");
            System.out.println("||  \\\\                          //  ||");
        }
        if(count == 1)
        {
            System.out.println("");
            System.out.println("++===================== ]");
            System.out.println("|| //            |");
            System.out.println("||//             |");
            System.out.println("||            (⌣ ⌒ ⌣)");
            System.out.println("||               ⏌ ⎿");
            System.out.println("||             " + rightArm  + " || " + leftArm );
            System.out.println("||               ||             ⚪️");
            System.out.println("||               ++             |");
            System.out.println("||              " + rightLeg  + "|");
            System.out.println("++--------" + door + "------⏜---++");
            System.out.println("||                                  ||");
            System.out.println("||                                  ||");
            System.out.println("||                                  ||");
            System.out.println("||\\\\                              //||");
            System.out.println("|| \\\\                            // ||");
            System.out.println("||  \\\\                          //  ||");
        }
        if(count == 3)
        {
            System.out.println("");
            System.out.println("++===================== ]");
            System.out.println("|| //            |");
            System.out.println("||//             |");
            System.out.println("||            (⌣ ⌒ ⌣)");
            System.out.println("||               ⏌ ⎿");
            System.out.println("||               || " + leftArm );
            System.out.println("||               ||             ⚪️");
            System.out.println("||               ++             |");
            System.out.println("||              " + rightLeg  + "  " + leftLeg + "            |");
            System.out.println("++--------" + door + "------⏜---++");
            System.out.println("||                                  ||");
            System.out.println("||                                  ||");
            System.out.println("||                                  ||");
            System.out.println("||\\\\                              //||");
            System.out.println("|| \\\\                            // ||");
            System.out.println("||  \\\\                          //  ||");
        }
        return "";
    }

    public static void delayDots(int dotAmount) throws InterruptedException
    {
        for(int i=0; i<dotAmount; i++)
        {
            TimeUnit.MILLISECONDS.sleep(350);
            System.out.print(".");
        }
        TimeUnit.MILLISECONDS.sleep(350);
        System.out.println();
    }

    public static void delayDots() throws InterruptedException
    {
        delayDots(0);
    } 

    public static void clearScreen() 
    {  
        System.out.print('\u000C');
    }  
}
