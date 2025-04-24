package org.howard.edu.lspfinal.question3;

abstract class Report {
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}

class SalesReport extends Report {
    protected void loadData() {
        System.out.println("Loading sales data...");
    }

    protected void formatData() {
        System.out.println("Formatting sales data...");
    }

    protected void printReport() {
        System.out.println("Printing sales report.\n");
    }
}

class InventoryReport extends Report {
    protected void loadData() {
        System.out.println("Loading inventory data...");
    }

    protected void formatData() {
        System.out.println("Formatting inventory data...");
    }

    protected void printReport() {
        System.out.println("Printing inventory report.\n");
    }
}

public class Driver {
    public static void main(String[] args) {
        Report sales = new SalesReport();
        Report inventory = new InventoryReport();

        sales.generateReport();
        inventory.generateReport();
    }
}
