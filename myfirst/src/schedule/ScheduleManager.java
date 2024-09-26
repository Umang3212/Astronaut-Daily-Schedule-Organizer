package schedule;

import java.util.*;

public class ScheduleManager {
    private static ScheduleManager instance;
    private List<Task> tasks;

    private ScheduleManager() {
        tasks = new ArrayList<>();
    }

    public static synchronized ScheduleManager getInstance() {
        if (instance == null) {
            instance = new ScheduleManager();
        }
        return instance;
    }

    public void addTask(String description, String startTime, String endTime, String priority) {
        Task newTask = TaskFactory.createTask(description, startTime, endTime, priority);
        for (Task task : tasks) {
            if (task.conflictsWith(newTask)) {
                System.out.println("Error: Task conflicts with existing task \"" + task.getDescription() + "\".");
                return;
            }
        }
        tasks.add(newTask);
        System.out.println("Task added successfully. No conflicts.");
        Collections.sort(tasks);
    }

    public void removeTask(String description) {
        Task taskToRemove = tasks.stream()
                .filter(t -> t.getDescription().equals(description))
                .findFirst()
                .orElse(null);

        if (taskToRemove != null) {
            tasks.remove(taskToRemove);
            System.out.println("Task removed successfully.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void viewTasks() {
        if (tasks.isEmpty()) {
            System.out.println("No tasks scheduled for the day.");
        } else {
            for (Task task : tasks) {
                System.out.println(task);
            }
        }
    }

    public void editTask(String description, String newStartTime, String newEndTime, String newPriority) {
        Task taskToEdit = tasks.stream()
                .filter(t -> t.getDescription().equals(description))
                .findFirst()
                .orElse(null);

        if (taskToEdit != null) {
            Task newTask = TaskFactory.createTask(description, newStartTime, newEndTime, newPriority);
            if (tasks.stream().anyMatch(t -> t != taskToEdit && t.conflictsWith(newTask))) {
                System.out.println("Error: New task details conflict with an existing task.");
            } else {
                taskToEdit.setStartTime(newStartTime);
                taskToEdit.setEndTime(newEndTime);
                taskToEdit.setPriority(newPriority);
                Collections.sort(tasks);
                System.out.println("Task updated successfully.");
            }
        } else {
            System.out.println("Error: Task not found.");
        }
    }

    public void markTaskCompleted(String description) {
        Task taskToMark = tasks.stream()
                .filter(t -> t.getDescription().equals(description))
                .findFirst()
                .orElse(null);

        if (taskToMark != null) {
            taskToMark.setCompleted(true);
            System.out.println("Task marked as completed.");
        } else {
            System.out.println("Error: Task not found.");
        }
    }
}

