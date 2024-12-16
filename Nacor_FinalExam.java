import java.util.Stack;

class Creature {
    String name;
    int power;

    Creature(String name, int power) {
        this.name = name;
        this.power = power;
    }

    @Override
    public String toString() {
        return name + " - " + power;
    }
}

public class Nacor_FinalExam {

    // Bubble Sort: Sort creatures in descending order of power
    public static void bubbleSortDescending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (creatures[j].power < creatures[j + 1].power) {
                    // Swap adjacent elements if out of order
                    Creature temp = creatures[j];
                    creatures[j] = creatures[j + 1];
                    creatures[j + 1] = temp;
                }
            }
        }
    }

    // Selection Sort: Sort creatures in ascending order of power
    public static void selectionSortAscending(Creature[] creatures) {
        int n = creatures.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (creatures[j].power < creatures[minIndex].power) {
                    minIndex = j;
                }
            }
            // Swap the current element with the smallest element found
            Creature temp = creatures[minIndex];
            creatures[minIndex] = creatures[i];
            creatures[i] = temp;
        }
    }

    // Display the array of creatures with a descriptive message
    public static void displayCreatures(Creature[] creatures, String message) {
        System.out.println("* " + message + " *");
        for (Creature c : creatures) {
            System.out.println(c);
        }
        System.out.println();
    }

    // Stack Implementation: Demonstrate LIFO behavior using creatures
    public static void stackImplementation(Creature[] creatures) {
        Stack<Creature> creatureStack = new Stack<>();

        // Push all creatures onto the stack
        for (Creature c : creatures) {
            creatureStack.push(c);
        }

        // Pop all creatures from the stack and display them
        System.out.println("* Stack Implementation: Popping Creatures *");
        while (!creatureStack.isEmpty()) {
            System.out.println("Popped: " + creatureStack.pop());
        }
    }

    public static void main(String[] args) {
        // Input data: Initialize an array of creatures
        Creature[] creatures = {
                new Creature("Dragon", 95),
                new Creature("Griffin", 88),
                new Creature("Unicorn", 78),
                new Creature("Phoenix", 92),
                new Creature("Centaur", 85)
        };

        // Perform Bubble Sort in descending order and display the result
        bubbleSortDescending(creatures);
        displayCreatures(creatures, "Bubble Sort: Descending Order by Power Level");

        // Perform Selection Sort in ascending order and display the result
        selectionSortAscending(creatures);
        displayCreatures(creatures, "Selection Sort: Ascending Order by Power Level");

        // Perform Stack operations after sorting creatures in descending order
        bubbleSortDescending(creatures); // Sort again in descending order
        stackImplementation(creatures);
    }
}
