import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessMovie {
    public static void main(String[] args) {
        System.out.println("----------- Guess Movie ---------------");
        File file = new File("movies.txt");

        Scanner scan = new Scanner(System.in);

        List<String> movies = new ArrayList<String>();
        int numberOfMovies = 0;
        if (file.exists()) {
            try {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine();
                    movies.add(line);
                    numberOfMovies++;
                }
            } catch (FileNotFoundException e) {
                System.out.println("Le fichier n'existe pas!");
            }
        }

        int randomNumber = (int) (Math.random() * numberOfMovies) + 1;
        String randomMovie = movies.get(23);
        System.out.println(randomMovie);
        StringBuilder movieMask = new StringBuilder();

        List<String> wrongLetters = new ArrayList<>();

        for (int i = 0; i < randomMovie.length(); i++) {
            movieMask.append("_");
        }

        boolean hasWon = false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Your are guessing: " + movieMask);
            System.out.println("You have guessed (" + wrongLetters.size() + ") wrong letters: " + wrongLetters.toString() + " ");
            System.out.println("Guess a letter: ");

            String guess = scan.nextLine();
            int index = 0;

            if (randomMovie.contains(guess)) {
                while ((index = randomMovie.indexOf(guess, index)) != -1) {
                    index = randomMovie.indexOf(guess, index);
                    movieMask.setCharAt(index, guess.charAt(0));
                    index++;
                }
            } else {
                if (!wrongLetters.contains(guess)) {
                    wrongLetters.add(guess);
                }
            }

            if (!movieMask.toString().contains("_")) {
                hasWon = true;
                break;
            }
        }

        if (hasWon) {
            System.out.println("Congras you won the game!!!!!!");
        } else {
            System.out.println("You loose the game!!!!");
        }
    }
}
