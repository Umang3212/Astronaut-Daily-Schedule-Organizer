package schedule;

public class TaskConflictObserver {
    public void notifyConflict(Task newTask, Task existingTask) {
        System.out.println("Conflict with " + existingTask.getDescription());
    }
}

