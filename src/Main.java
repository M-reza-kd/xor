import javax.swing.*;
import java.util.Scanner;

public class Main {
        public static void main(String[] args) {
                Scanner input = new Scanner(System.in);
                int n, m, numberOfPlayer;
                n = input.nextInt();
                m = input.nextInt();
                numberOfPlayer = input.nextInt();
                Game game = new Game(numberOfPlayer, n, m);
        }
}
