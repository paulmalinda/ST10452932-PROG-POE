/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author RC_Student_lab
 */
import java.util.ArrayList;
import java.util.Scanner;

public class KanbanApp {
    private static final ArrayList<Task> tasks = new ArrayList<>();
    private static KanbanBoardGUI kanbanBoard;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            boolean isRunning = true;
            
            System.out.println("Welcome to EasyKanban");
            
            // Initialize the Kanban board GUI
            kanbanBoard = new KanbanBoardGUI(tasks);
            
            // Main menu loop
            while (isRunning) {
                System.out.println("\nChoose an option:");
                System.out.println("1. Add Task");
                System.out.println("2. Show Kanban Board");
                System.out.println("3. Quit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine();
                
                switch (choice) {
                    case 1 -> addTask(scanner);
                    case 2 -> System.out.println("Kanban Board is displayed in the GUI window.");
                    case 3 -> {
                        isRunning = false;
                        System.out.println("Exiting EasyKanban.");
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }

    private static void addTask(Scanner scanner) {
        System.out.print("Enter Task Name: ");
        String taskName = scanner.nextLine();

        System.out.print("Enter Task Description (Max 50 chars): ");
        String taskDescription = scanner.nextLine();
        if (taskDescription.length() > 50) {
            System.out.println("Error: Task description must be less than 50 characters.");
            return;
        }

        System.out.print("Enter Developer Details: ");
        String developerDetails = scanner.nextLine();

        System.out.print("Enter Task Duration (hours): ");
        int taskDuration = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Select Task Status:\n1. To Do\n2. Doing\n3. Done");
        System.out.print("Enter choice: ");
        int statusChoice = scanner.nextInt();
        scanner.nextLine();

        String taskStatus;
        switch (statusChoice) {
            case 1 -> taskStatus = "To Do";
            case 2 -> taskStatus = "Doing";
            case 3 -> taskStatus = "Done";
            default -> {
                System.out.println("Invalid status choice. Defaulting to 'To Do'.");
                taskStatus = "To Do";
            }
        }

        Task task = new Task(taskName, tasks.size(), taskDescription, developerDetails, taskDuration, taskStatus);
        tasks.add(task);
        kanbanBoard.updateBoard();
    }
}
