package org.howard.edu.lsp.final.question3;

public class InventoryReport extends Report {
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    protected void printReport() {
        System.out.println("Printing inventory report.");
    }
}
