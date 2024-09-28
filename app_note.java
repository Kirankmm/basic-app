import java.util.ArrayList;
import java.util.Scanner;

public class NoteTakingApp {

    // List to store the notes
    private static ArrayList<String> notes = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            // Display the menu
            System.out.println("\n*** Note-Taking App ***");
            System.out.println("1. Create a Note");
            System.out.println("2. View All Notes");
            System.out.println("3. Delete a Note");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1:
                    createNote(scanner);
                    break;
                case 2:
                    viewNotes();
                    break;
                case 3:
                    deleteNote(scanner);
                    break;
                case 4:
                    System.out.println("Exiting the app. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Method to create a new note
    private static void createNote(Scanner scanner) {
        System.out.print("Enter your note: ");
        String note = scanner.nextLine();
        notes.add(note);
        System.out.println("Note added successfully.");
    }

    // Method to display all notes
    private static void viewNotes() {
        if (notes.isEmpty()) {
            System.out.println("No notes available.");
        } else {
            System.out.println("\nYour Notes:");
            for (int i = 0; i < notes.size(); i++) {
                System.out.println((i + 1) + ". " + notes.get(i));
            }
        }
    }

    // Method to delete a note
    private static void deleteNote(Scanner scanner) {
        if (notes.isEmpty()) {
            System.out.println("No notes to delete.");
            return;
        }

        viewNotes();
        System.out.print("Enter the number of the note you want to delete: ");
        int noteIndex = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        if (noteIndex > 0 && noteIndex <= notes.size()) {
            notes.remove(noteIndex - 1);
            System.out.println("Note deleted successfully.");
        } else {
            System.out.println("Invalid note number.");
        }
    }
}
