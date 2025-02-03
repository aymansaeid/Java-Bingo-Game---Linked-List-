
import java.util.Random;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author 2A04
 */
public class AymanSaeidBingoClass {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
           System.out.print("Enter name for Player 1: ");
        String player1name = s.nextLine();
        
        System.out.print("Enter name for Player 2: ");
        String player2name = s.nextLine();
        
        AymanSaeidDoubleLinklistClass player1 = new AymanSaeidDoubleLinklistClass();
        AymanSaeidDoubleLinklistClass player2 = new AymanSaeidDoubleLinklistClass();

        int[][] card1 = { 
            {5, -1, 21, -1, 41, 51, -1, -1, 81},
            {-1, 12, -1, 33, -1, 55, 63, 72, -1},
            {9, -1, 27, -1, 48, -1, 66, -1, 89}
        };
      
        player1.convertintolist(card1);
        System.out.println("-----------------------------------------");
              

        int[][] card2 = AymanSaeidDoubleLinklistClass.generateCard1(); // using the gerenating functionn.
        
        /*
        int[][] card2 = {
            {5, 2, 22, -1, -1, -1, 60, 73, -1},
            {-1, 88, -1, 31, 47, 58, 55, -1, -1},
            {9, 4, -1, 28, -1, -1, -1, 11, 7}
        };
*/
        player2.convertintolist(card2);

        boolean end = false;
        while (!end) {
            System.out.println(player1name + " cards: ");
            player1.printlist();
            System.out.println("-----------------");
            System.out.println(player2name + " cards: ");
            player2.printlist();
            System.out.println("-----------------");
            System.out.println("press enter to draw a numbers .");
            s.nextLine();
            int randomPermutation = randomNumbers(90);
            System.out.println("the random numbers : ");
            System.out.println();
                System.out.print("    " + randomPermutation + "  ");
            System.out.println();
            System.out.println();
            player1.Checknum(randomPermutation);
            player2.Checknum(randomPermutation);
            System.out.println("----------------------------------------------------------------");

            if (player1.checkBINGO()) {
                System.out.println("     " + player1name + "    W O N  !!");
                end = true;
            } else if (player2.checkBINGO()) {
                System.out.println("     " + player2name + "    W O N  !!");
                end = true;
            }

        }
    }

    public static int randomNumbers(int num) {
    Random r = new Random();
    return r.nextInt(num) + 1;
}
}
