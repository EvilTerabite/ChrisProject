package me.chris.project4;

import java.util.Random;
import java.util.Scanner;

public class P4Main {

    private static final Random random = new Random();

    public static void main(String[] args) {
        double secret = random.nextInt(10);
        while(true) {
            System.out.print("Guess: ");
            Scanner scanner = new Scanner(System.in);
            int guess = scanner.nextInt();
            if(guess == secret) {
                break;
            }
            if(guess < secret) {
                System.out.println("Your guess is less than the secret number, choose again.");
            }
            if(guess > secret) {
                System.out.println("Your guess is greater than the secret number, choose again.");
            }
        }

        System.out.println("Congratulations, you have guessed the secret number!");

    }
}
