import java.util.Scanner;
import schedule.*;

public class Main {

    private static boolean validateTime(String time) {
        if (time.matches("\\d{2}:\\d{2}")) {
            String[] parts = time.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            return (hours >= 0 && hours < 24) && (minutes >= 0 && minutes < 60);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ScheduleManager scheduleManager = ScheduleManager.getInstance();
        int choice = 0;

        while (choice != 6) {
            System.out.println("\nAstronaut Daily Schedule Organizer");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. View All Tasks");
            System.out.println("4. Edit Task");
            System.out.println("5. Mark Task as Completed");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter description: ");
                        String description = scanner.nextLine();

                        boolean isValidTime = false;
                        String startTime = "";
                        while (!isValidTime) {
                            System.out.print("Enter start time (HH:MM): ");
                            startTime = scanner.nextLine();
                            isValidTime = validateTime(startTime);
                            if (!isValidTime) {
                                System.out.println(
                                        "Error: Invalid time format or time out of range. Please use HH:MM (00:00 to 23:59).");
                            }
                        }

                        isValidTime = false;
                        String endTime = "";
                        while (!isValidTime) {
                            System.out.print("Enter end time (HH:MM): ");
                            endTime = scanner.nextLine();
                            isValidTime = validateTime(endTime);
                            if (!isValidTime) {
                                System.out.println(
                                        "Error: Invalid time format or time out of range. Please use HH:MM (00:00 to 23:59).");
                            }
                        }

                        System.out.print("Enter priority (Low, Medium, High): ");
                        String priority = scanner.nextLine();
                        scheduleManager.addTask(description, startTime, endTime, priority);
                        break;
                    case 2:
                        System.out.print("Enter description of the task to remove: ");
                        description = scanner.nextLine();
                        scheduleManager.removeTask(description);
                        break;
                    case 3:
                        scheduleManager.viewTasks();
                        break;
                    case 4:
                        System.out.print("Enter description of the task to edit: ");
                        description = scanner.nextLine();

                        isValidTime = false;
                        startTime = "";
                        while (!isValidTime) {
                            System.out.print("Enter start time (HH:MM): ");
                            startTime = scanner.nextLine();
                            isValidTime = validateTime(startTime);
                            if (!isValidTime) {
                                System.out.println(
                                        "Error: Invalid time format or time out of range. Please use HH:MM (00:00 to 23:59).");
                            }
                        }

                        isValidTime = false;
                        endTime = "";
                        while (!isValidTime) {
                            System.out.print("Enter end time (HH:MM): ");
                            endTime = scanner.nextLine();
                            isValidTime = validateTime(endTime);
                            if (!isValidTime) {
                                System.out.println(
                                        "Error: Invalid time format or time out of range. Please use HH:MM (00:00 to 23:59).");
                            }
                        }

                        System.out.print("Enter new priority (Low, Medium, High): ");
                        priority = scanner.nextLine();
                        scheduleManager.editTask(description, startTime, endTime, priority);
                        break;
                    case 5:
                        System.out.print("Enter description of the task to mark as completed: ");
                        description = scanner.nextLine();
                        scheduleManager.markTaskCompleted(description);
                        break;
                    case 6:
                        System.out.println("Exiting program.");
                        break;
                    default:
                        System.out.println("Invalid choice, please choose again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
