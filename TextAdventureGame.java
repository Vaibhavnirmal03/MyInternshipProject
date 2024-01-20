import java.util.Scanner;

public class TextAdventureGame {

    public static void main(String[] args) {
        startGame();
    }

    public static void startGame() {
        System.out.println("Welcome to the Text Adventure Game!");
        System.out.println("You find yourself in a mysterious forest...");

        // Start the story
        playIntroduction();

        // Continue the story with decision points
        makeDecision1();

        endGame();
    }

    public static void playIntroduction() {
        System.out.println("As you walk deeper into the forest, you encounter a fork in the path.");
        System.out.println("To the left is a dark cave, and to the right is a narrow bridge.");

        System.out.print("Which way do you choose? (left/right): ");
        String decision = getUserInput();

        // Handle the user's decision
        if (decision.equalsIgnoreCase("left")) {
            System.out.println("You enter the dark cave...");
            // Continue the story based on the left decision
        } else if (decision.equalsIgnoreCase("right")) {
            System.out.println("You cautiously cross the narrow bridge...");
            // Continue the story based on the right decision
        } else {
            System.out.println("Invalid input. Please enter 'left' or 'right'.");
            playIntroduction(); // Restart this part of the story
        }
    }

    public static void makeDecision1() {
        System.out.println("After a short journey, you reach a clearing with two paths.");
        System.out.println("One path leads to a magical garden, and the other leads to a haunted mansion.");

        System.out.print("Which path will you take? (garden/mansion): ");
        String decision = getUserInput();

        // Handle the user's decision
        if (decision.equalsIgnoreCase("garden")) {
            System.out.println("You enter the enchanting garden...");
            continueStoryFromGarden();
            // Continue the story based on the garden decision
        } else if (decision.equalsIgnoreCase("mansion")) {
            System.out.println("You approach the creepy mansion...");
            continueStoryFromMansion();
            // Continue the story based on the mansion decision
        } else {
            System.out.println("Invalid input. Please enter 'garden' or 'mansion'.");
            makeDecision1(); // Restart this decision point
        }
    }

    // You can continue adding more methods for each decision point and outcome

    // ... (previous code)

    public static void continueStoryFromGarden() {
        System.out.println("In the magical garden, you discover a talking tree that offers you a quest.");
        System.out.println("The tree asks you to find a hidden treasure in the depths of the forest.");

        System.out.print("Will you accept the quest? (yes/no): ");
        String decision = getUserInput();

        // Handle the user's decision
        if (decision.equalsIgnoreCase("yes")) {
            System.out.println("You bravely accept the quest and set off on an adventurous journey.");
            // Continue the story based on the quest acceptance
        } else if (decision.equalsIgnoreCase("no")) {
            System.out.println("You decide to decline the quest and explore the garden further.");
            // Continue the story based on declining the quest
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            continueStoryFromGarden(); // Restart this decision point
        }
    }

    public static void continueStoryFromMansion() {
        System.out.println("As you approach the haunted mansion, you hear eerie noises and see flickering lights.");
        System.out.println("A mysterious figure appears at the entrance and invites you inside.");

        System.out.print("Do you enter the haunted mansion? (yes/no): ");
        String decision = getUserInput();

        // Handle the user's decision
        if (decision.equalsIgnoreCase("yes")) {
            System.out.println("You enter the mansion, and strange things start happening...");
            // Continue the story based on entering the mansion
        } else if (decision.equalsIgnoreCase("no")) {
            System.out.println("You decide to stay outside and cautiously observe the mansion.");
            // Continue the story based on staying outside the mansion
        } else {
            System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            continueStoryFromMansion(); // Restart this decision point
        }
    }

// ... (continue adding more methods for additional decision points)

    public static void endGame() {
        System.out.println("Congratulations! You've reached the end of the Text Adventure Game.");
        System.out.println("Thank you for playing!");
    }

// ... (rest of the code remains the same)



    public static String getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine().trim(); // Trim to remove leading/trailing spaces
    }
}