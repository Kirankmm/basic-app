import random

class Flashcard:
    def __init__(self, question, answer):
        self.question = question
        self.answer = answer

class FlashcardQuizApp:
    def __init__(self):
        self.flashcards = []

    def add_flashcard(self, question, answer):
        flashcard = Flashcard(question, answer)
        self.flashcards.append(flashcard)
        print("Flashcard added successfully!")

    def quiz(self):
        if not self.flashcards:
            print("No flashcards available. Please add some flashcards first.")
            return

        random.shuffle(self.flashcards)  # Shuffle the flashcards for randomness

        print("\nStarting the quiz...")
        score = 0
        for flashcard in self.flashcards:
            print("\nQuestion: " + flashcard.question)
            user_answer = input("Your answer: ")

            if user_answer.strip().lower() == flashcard.answer.strip().lower():
                print("Correct!")
                score += 1
            else:
                print(f"Wrong! The correct answer is: {flashcard.answer}")

        print(f"\nQuiz finished! Your score: {score}/{len(self.flashcards)}")

    def display_menu(self):
        print("\n*** Flashcard Quiz App ***")
        print("1. Add Flashcard")
        print("2. Start Quiz")
        print("3. Exit")

def main():
    app = FlashcardQuizApp()

    while True:
        app.display_menu()
        choice = input("Choose an option: ")

        if choice == '1':
            question = input("Enter the question: ")
            answer = input("Enter the answer: ")
            app.add_flashcard(question, answer)
        elif choice == '2':
            app.quiz()
        elif choice == '3':
            print("Exiting the app. Goodbye!")
            break
        else:
            print("Invalid choice. Please try again.")

if __name__ == "__main__":
    main()
