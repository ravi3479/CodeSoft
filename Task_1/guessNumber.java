package Task_1;

import java.util.Scanner;

class GuessTheNumber {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);//to take input from user
        boolean playAgain= true;
        int totalScore=0;
        int no_0f_rounds=0;
        System.out.println("------------------------------------------------------------------");
        System.out.println("             Welcome to the guessing number game !      ");
        System.out.println("------------------------------------------------------------------");
        while (playAgain) {
            int min = 1;
            int max = 100;
            int numberToGuess = (int) (Math.random() * (max - min + 1)) + min;
            int maxAttempts = 10;
            boolean hasWon = false;
            System.out.println("-> {computer has generated random number between " + min + " and " + max + ".}");
            System.out.println("------------------------------------------------------------------");
            System.out.println("    ->you have total "+ maxAttempts + " attempts to guess the number ");
            System.out.println("------------------------------------------------------------------");

            while (no_0f_rounds < maxAttempts && !hasWon) {
                System.out.print("         Enter your guess: ");
                int guess_number = sc.nextInt();
                no_0f_rounds++;

                if (guess_number < min || guess_number > max) {
                    System.out.println("Please enter a number between " + min + " and " + max + ".");
                } else if (guess_number < numberToGuess) {
                    System.out.println("                                       --->Too low!");
                } else if (guess_number > numberToGuess) {
                    System.out.println("                                      --->Too high!");
                } else {
                    hasWon = true;
                    int score=maxAttempts-no_0f_rounds+1;
                    totalScore +=score;
                    System.out.println("Congratulations! You've guessed the number in " + no_0f_rounds + " rounds.");
                    System.out.println("you have scored " +score+ " in this round " );
                }
            }
            if (!hasWon) {
                System.out.println("---------------------------------------------------------------");
                System.out.println("      Oops! your attempts are over. The number was: " + numberToGuess);
                System.out.println("---------------------------------------------------------------");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            sc.nextLine();
            String response = sc.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        }
        System.out.println("-------------------------------------------------");
        System.out.println("              Thanks for playing!");
        System.out.println("--------------------------------------------------");
        System.out.println("You played " + no_0f_rounds + " rounds.");
        System.out.println("Your total score is: " + totalScore);

        sc.close();
    }
}

