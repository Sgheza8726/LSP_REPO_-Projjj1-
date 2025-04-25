package org.howard.edu.lsp.final.question3;

public abstract class Report {
    public final void generateReport() {
        loadData();
        formatData();
        printReport();
    }

    protected abstract void loadData();
    protected abstract void formatData();
    protected abstract void printReport();
}
