import java.util.*;

public class GuessGame {

    public static void main(String[] args) {
        System.out.println("J'ai généré un nombre entre [1, 100]");
        System.out.println("Essaye de le trouver");
        int randomNumber = (int) (Math.random() * 100) + 1;
        boolean hasWon = false;

        Scanner scanner = new Scanner(System.in);

        for (int i = 10; i > 0; i--) {
            System.out.println("Il vous reste " + i + " essaie(s): ");
            int guess = scanner.nextInt();

            if (guess > randomNumber) {
                System.out.println("Plus petit que " + guess);
            } else if (guess < randomNumber) {
                System.out.println("Plus grand que " + guess);
            } else {
                hasWon = true;
                break;
            }
        }
        if (hasWon) {
            System.out.println("Vous avez gagné. Le nombre correct est: " + randomNumber);
        } else {
            System.out.println("Vous avez perdu. Le nombre correct était: " + randomNumber);
        }
    }

}
