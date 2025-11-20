import java.util.Random;
import java.util.Scanner;

class Player {
    private String move;

    public void setMove(String move) {
        this.move = move.trim().toLowerCase();
    }

    public String getMove() {
        return move;
    }
}

class Computer {
    private String[] choices = {"rock", "paper", "scissors"};
    private Random rand = new Random();

    public String getMove() {
        return choices[rand.nextInt(choices.length)];
    }
}

class Game {
    private Player player = new Player();
    private Computer computer = new Computer();
    private int playerWins = 0;
    private int computerWins = 0;
    private int ties = 0;

    public void startGame(int totalRounds, Scanner in) {
        for (int round = 1; round <= totalRounds; round++) {
            System.out.println("\nRound " + round + " of " + totalRounds);
            System.out.print("Your move (rock, paper, scissors): ");
            String userMove = in.nextLine();
            player.setMove(userMove);

            String p = player.getMove();

            if (!(p.equals("rock") || p.equals("paper") || p.equals("scissors"))) {
                System.out.println("Invalid choice. Try again!");
                round--; 
                continue;
            }

            String c = computer.getMove();
            System.out.println("Computer chose: " + c);

            if (p.equals(c)) {
                System.out.println("It's a tie!");
                ties++;
            } else if (
                (p.equals("rock") && c.equals("scissors")) ||
                (p.equals("paper") && c.equals("rock")) ||
                (p.equals("scissors") && c.equals("paper"))
            ) {
                System.out.println("You win this round!");
                playerWins++;
            } else {
                System.out.println("Computer wins this round!");
                computerWins++;
            }
        }

        showResults();
    }

    public void showResults() {
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
        System.out.println("Thanks for playing!");
    }
}

public class RockPaperScissorsOOP {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Game game = new Game();

        System.out.println("Welcome to Rock, Paper, Scissors!");
        System.out.print("How many rounds would you like to play? ");
        int totalRounds = in.nextInt();
        in.nextLine(); 

        game.startGame(totalRounds, in);

        in.close();
    }
}
