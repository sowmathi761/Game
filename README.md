# Rock Paper Scissors – OOPS with Exception Handling (Java)

## Overview

This project is an Object-Oriented Java implementation of the Rock, Paper, Scissors game.
It demonstrates the concepts of OOPS, custom exception handling, user input validation, classes, objects, and clean program structure.
The game allows the user to play multiple rounds against the computer and displays the final results at the end.

---

## Object-Oriented Structure

### 1. Player Class

* Stores and manages the player's move.
* Validates the move entered by the user.
* Throws a custom `InvalidMoveException` for invalid inputs.

### 2. Computer Class

* Generates a random move from the set {rock, paper, scissors}.
* Uses the `Random` class for random selection.

### 3. Game Class

* Contains the main logic for executing each round.
* Compares the player's move and the computer's move.
* Tracks the number of player wins, computer wins, and ties.
* Displays the final results at the end.

### 4. Main Class (RockPaperScissorsOOP)

* Handles user input for the number of rounds.
* Uses exception handling to validate numeric input.
* Starts and controls the overall flow of the game.

---

## Exception Handling Used

### InvalidMoveException

A custom exception used to handle cases where the user enters an invalid move (anything other than rock, paper, or scissors).

### InputMismatchException

Used to catch invalid round inputs when the user enters a non-numeric value.

### IllegalArgumentException

Used to ensure the user enters a positive number of rounds.

---

## How the Game Works

1. The user enters the number of rounds they want to play.
2. For each round, the user enters their move: rock, paper, or scissors.
3. The computer randomly selects a move.
4. The winner of each round is displayed immediately.
5. After all rounds are completed, the program displays:

   * Total player wins
   * Total computer wins
   * Number of tied rounds
   * Overall winner

---

## Sample Output

```
Welcome to Rock, Paper, Scissors!
How many rounds would you like to play? 3

Round 1 of 3
Your move (rock, paper, scissors): rock
Computer chose: scissors
You win this round!

Round 2 of 3
Your move (rock, paper, scissors): stone
Invalid choice. Try again!

Round 2 of 3
Your move (rock, paper, scissors): paper
Computer chose: rock
You win this round!

==============================
        FINAL RESULTS
==============================
You won 2 rounds.
Computer won 0 rounds.
Tied rounds: 0

You are the overall winner!
==============================
Thanks for playing!
```

---

## Technologies Used

* Java
* Object-Oriented Programming Concepts
* Exception Handling
* Scanner Class
* Random Class

---

## Features

* Fully object-oriented structure
* User input validation
* Custom exception handling
* Random computer move generation
* Clear and structured game output

---
