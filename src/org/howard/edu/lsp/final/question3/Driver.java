package org.howard.edu.lsp.final.question3;

public class Driver {
    public static void main(String[] args) {
        Report sales = new SalesReport();
        sales.generateReport();

        System.out.println();

        Report inventory = new InventoryReport();
        inventory.generateReport();
    }
}
