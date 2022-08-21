import java.io.File;
import java.util.Scanner;

public class WordCount {
    public static void main(String[] args) throws Exception {
        File file = new File("book.txt");

        Scanner scanner = new Scanner(file);
        int count = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            count += line.split(" ").length;
        }
        System.out.println("Ce livre contient approximativement " + count + " Mots");
    }
}
