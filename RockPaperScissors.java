import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        String[] choices = { "rock", "paper", "scissors" };

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.print("How many rounds would you like to play? ");
        int totalRounds = in.nextInt();
        in.nextLine(); // consume the leftover newline

        int playerWins = 0;
        int computerWins = 0;
        int ties = 0;

        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\nRound " + round + " of " + totalRounds);
            System.out.print("Your move (rock, paper, scissors): ");
            String player = in.nextLine().trim().toLowerCase();

            if (!(player.equals("rock") || player.equals("paper") || player.equals("scissors"))) {
                System.out.println("Invalid choice. Try again!");
                round--; // repeat this round
                continue;
            }

            String computer = choices[rand.nextInt(choices.length)];
            System.out.println("Computer chose: " + computer);

            if (player.equals(computer)) {
                System.out.println("It's a tie!");
                ties++;
            } else if (
                (player.equals("rock") && computer.equals("scissors")) ||
                (player.equals("paper") && computer.equals("rock")) ||
                (player.equals("scissors") && computer.equals("paper"))
            ) {
                System.out.println("You win this round!");
                playerWins++;
            } else {
                System.out.println("Computer wins this round!");
                computerWins++;
            }
        }

        System.out.println("\n==============================");
        System.out.println("        FINAL RESULTS");
        System.out.println("==============================");
        System.out.println("You won " + playerWins + " rounds.");
        System.out.println("Computer won " + computerWins + " rounds.");
        System.out.println("Tied rounds: " + ties);

        if (playerWins > computerWins) {
            System.out.println("\nYou are the overall winner!");
        } else if (computerWins > playerWins) {
            System.out.println("\nComputer wins overall!");
        } else {
            System.out.println("\nIt's an overall tie!");
        }

        System.out.println("==============================");
        System.out.println("Thanks for playing! ");
        in.close();
    }
}
