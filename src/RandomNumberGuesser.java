import java.util.Scanner;

public class RandomNumberGuesser {

    public static void main(String[] args) {
        // write your code here
//        resetCount, getCount and inputValidation
        System.out.println("Welcome to the random number guessing game!");
        boolean tryAgain = true;
        while (tryAgain == true) {
            int lowGuess = 0;
            int highGuess = 100;
            int randNum = RNG.rand();
            System.out.println("The random number is " + randNum);
            System.out.println("Enter a number between 0 and 100");

            Scanner scanned = new Scanner(System.in);
            int nextGuess;
            do {
                nextGuess = scanned.nextInt();
                scanned.nextLine();

                if (RNG.inputValidation(nextGuess, lowGuess, highGuess)) {

                    if (nextGuess == randNum) {
                        System.out.println("Number of guesses is "+ RNG.getCount());
                        System.out.println("You guessed correctly with " + nextGuess);
                        System.out.println("Would you like to tray again? enter y for yes and n for no");

                        String response = scanned.nextLine();
//                        scanned.next();
                        if (response.equals("y")) {
                            tryAgain = true;
                        } else if (response.equals("n")) {
                            tryAgain = false;
                        } else {
                            System.out.println("Invalid Response! enter y for yes and n for no");
                            tryAgain = false;
                        }

                    } else if (nextGuess < randNum) {
                        lowGuess = nextGuess;
                        System.out.println("Number of guesses is "+ RNG.getCount());
                        System.out.println("Your guess of " + nextGuess + " is too low! ");
                        System.out.println("Enter your next guess between " + lowGuess + " and " +highGuess);

                    } else if (nextGuess > randNum) {
                        System.out.println("Number of guesses is "+ RNG.getCount());
                        System.out.println("Your guess of " + nextGuess + " is too high! ");
                        System.out.println("Enter your next guess between " + lowGuess + " and " +highGuess);
                        highGuess = nextGuess;
                    }

                }

            }while (nextGuess != randNum) ;
            //else if (!RNG.inputValidation(nextGuess, lowGuess, highGuess));

            RNG.resetCount();
        }

    }
}
