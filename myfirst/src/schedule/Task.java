package schedule;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public class Task implements Comparable<Task> {
    private String description;
    private LocalTime startTime;
    private LocalTime endTime;
    private String priority;
    private boolean isCompleted;

    public Task(String description, String startTime, String endTime, String priority) {
        this.description = description;
        try {
            this.startTime = LocalTime.parse(startTime);
            this.endTime = LocalTime.parse(endTime);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid time format. Please use HH:MM.");
        }
        this.priority = priority;
        this.isCompleted = false;
    }

    public boolean conflictsWith(Task other) {
        return !this.endTime.isBefore(other.startTime) && !this.startTime.isAfter(other.endTime);
    }

    @Override
    public int compareTo(Task other) {
        return this.startTime.compareTo(other.startTime);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStartTime() {
        return startTime.toString();
    }

    public void setStartTime(String startTime) {
        this.startTime = LocalTime.parse(startTime);
    }

    public String getEndTime() {
        return endTime.toString();
    }

    public void setEndTime(String endTime) {
        this.endTime = LocalTime.parse(endTime);
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public String toString() {
        return startTime + " - " + endTime + ": " + description + " [" + priority + "]" + (isCompleted ? " (Completed)" : "");
    }
}

