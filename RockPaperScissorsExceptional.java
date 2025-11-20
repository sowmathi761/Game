import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;


class InvalidMoveException extends Exception {
    public InvalidMoveException(String msg) {
        super(msg);
    }
}

class Player {
    private String move;

    public void setMove(String move) throws InvalidMoveException {
        move = move.trim().toLowerCase();
        if (!(move.equals("rock") || move.equals("paper") || move.equals("scissors"))) {
            throw new InvalidMoveException("Invalid choice. Try again!");
        }
        this.move = move;
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

            String inputMove = in.nextLine();

            try {
                player.setMove(inputMove);
            } catch (InvalidMoveException e) {
                System.out.println(e.getMessage());
                round--;
                continue;
            }

            String p = player.getMove();
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

        showFinalResults();
    }

    public void showFinalResults() {
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
        int totalRounds = 0;

        System.out.println("Welcome to Rock, Paper, Scissors!");


        while (true) {
            try {
                System.out.print("How many rounds would you like to play? ");
                totalRounds = in.nextInt();

                if (totalRounds <= 0) {
                    throw new IllegalArgumentException("Rounds must be greater than 0!");
                }

                in.nextLine(); 
                break;

            } catch (InputMismatchException e) {
                System.out.println("Invalid number! Enter a valid integer.");
                in.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        game.startGame(totalRounds, in);
        in.close();
    }
}
