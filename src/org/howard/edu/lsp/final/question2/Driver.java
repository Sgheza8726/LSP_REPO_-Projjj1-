package org.howard.edu.lsp.final.question2;

public class Driver {
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
