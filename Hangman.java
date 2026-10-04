
import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Random random = new Random();

        String[] words = {"PROGRAM", "COMPUTER", "PICKLES", "GAMING", "KIDKAT"};
        String secretWord = words[random.nextInt(words.length)].toUpperCase();
//Game variables
        int maxAttempts = 6;
        int incorrectGuesses = 0;
//Storing all guessed letters
        String guessedLetters = "";
// Keeps track of whether gamer has won

        boolean wordGuessed = false;

        System.out.println("Welcome to Hangman!");

        //Game Loop

        while (incorrectGuesses < maxAttempts && !wordGuessed) {
            System.out.println("\nWord: ");
            for (int i = 0; i < secretWord.length(); i++) {

                char letter = secretWord.charAt(i);
                if (guessedLetters.indexOf(letter) >= 0) {
                System.out.print(letter+" ");
                } else {
                    System.out.print("_ ");
                }
            }
        int remainingAttempts =Math.max(0, maxAttempts - incorrectGuesses);

            System.out.printf("%n Incorrect guesses: %d\n", incorrectGuesses);
            System.out.printf("Remaining attempts: %d\n", remainingAttempts);

            System.out.print("Guess a letter!:");
            String guess = input.nextLine().toUpperCase();
            if(guess.length() !=1){
             System.out.println("Please enter only one letter!");
}

            char guessedLetter =guess.charAt(0);

            if (guessedLetters.indexOf(guessedLetter) >= 0){
            System.out.println("You already guessed the letter!");
        }
            guessedLetters += guessedLetter;
            if (secretWord.indexOf(guessedLetter) >= 0) {
            System.out.println("Correct!");
        } else {
             System.out.println("Incorrect!");
             incorrectGuesses++;
            }

            wordGuessed = true;
            for (int i = 0; i < secretWord.length(); i++){
                if (guessedLetters.indexOf(secretWord.charAt(i)) < 0) {
                   wordGuessed = false;
                   break;

                }
            }
    }

        if (wordGuessed) {
            System.out.println("\nEpico!");
            System.out.printf("\nYou guessed the word: %s\n!",secretWord);
        } else {
            System.out.println("\n Game Over!");
            System.out.printf("The word was: %s",secretWord);
        }
        input.close();
}
}