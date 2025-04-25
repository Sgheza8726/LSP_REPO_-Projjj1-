package org.howard.edu.lsp.final.question2;

import java.util.*;

public class TaskManager {
    private Map<String, Task> tasks = new HashMap<>();

    public void addTask(String name, int priority, String status) throws DuplicateTaskException {
        if (tasks.containsKey(name)) {
            throw new DuplicateTaskException("Task '" + name + "' already exists.");
        }
        tasks.put(name, new Task(name, priority, status));
    }

    public Task getTaskByName(String name) throws TaskNotFoundException {
        if (!tasks.containsKey(name)) {
            throw new TaskNotFoundException("Task '" + name + "' not found.");
        }
        return tasks.get(name);
    }

    public void updateStatus(String name, String newStatus) throws TaskNotFoundException {
        Task task = getTaskByName(name);
        task.setStatus(newStatus);
    }

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
}
