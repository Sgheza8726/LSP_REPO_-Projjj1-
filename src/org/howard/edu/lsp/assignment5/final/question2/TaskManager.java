package org.howard.edu.lspfinal.question2;

import java.util.*;

/**
 * Represents a single task with a name, priority, and status.
 */
class Task {
    private String name;
    private int priority;
    private String status;

    public Task(String name, int priority, String status) {
        this.name = name;
        this.priority = priority;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + ", status='" + status + "'}";
    }
}

/**
 * Exception thrown when a task with the same name already exists.
 */
class DuplicateTaskException extends Exception {
    public DuplicateTaskException(String message) {
        super(message);
    }
}

/**
 * Exception thrown when a requested task is not found.
 */
class TaskNotFoundException extends Exception {
    public TaskNotFoundException(String message) {
        super(message);
    }
}

/**
 * Manages a collection of unique tasks and provides methods to add, update, retrieve, and group them.
 */
public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a task to the manager.
     * 
     * @param name Task name (must be unique)
     * @param priority Task priority
     * @param status Task status: TODO, IN_PROGRESS, or DONE
     * @throws DuplicateTaskException if a task with the same name already exists
     */
    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    /**
     * Gets a task by its name.
     * 
     * @param name The name of the task to retrieve
     * @return Task object
     * @throws TaskNotFoundException if the task does not exist
     */
    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    /**
     * Updates the status of an existing task.
     * 
     * @param name Name of the task
     * @param newStatus New status to apply
     * @throws TaskNotFoundException if the task does not exist
     */
    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

    /**
     * Prints all tasks grouped by their status: TODO, IN_PROGRESS, and DONE.
     */
    public void printTasksGroupedByStatus() {
        Map<String, List<Task>> grouped = new TreeMap<>();

        for (Task task : tasks.values()) {
            grouped.computeIfAbsent(task.getStatus(), k -> new ArrayList<>()).add(task);
        }

        System.out.println("Tasks grouped by status:");
        for (String status : Arrays.asList("TODO", "IN_PROGRESS", "DONE")) {
            System.out.println(status + ":");
            List<Task> list = grouped.getOrDefault(status, new ArrayList<>());
            for (Task t : list) {
                System.out.println("  " + t);
            }
        }
    }

    /**
     * Sample driver to test the TaskManager system.
     */
    public static class Driver {
        public static void main(String[] args) {
            TaskManager manager = new TaskManager();

            try {
                manager.addTask("Fix Bug #204", 1, "TODO");
                manager.addTask("Write Docs", 3, "TODO");
                manager.addTask("Setup CI/CD", 2, "IN_PROGRESS");
                manager.addTask("Fix Bug #204", 4, "DONE");
            } catch (DuplicateTaskException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                Task t = manager.getTaskByName("Write Docs");
                System.out.println("Retrieved: " + t);
            } catch (TaskNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }

            try {
                manager.updateStatus("Write Docs", "DONE");
                manager.updateStatus("Nonexistent Task", "IN_PROGRESS");
            } catch (TaskNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }

            manager.printTasksGroupedByStatus();
        }
    }
}
