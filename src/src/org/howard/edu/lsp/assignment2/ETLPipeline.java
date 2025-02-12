package org.howard.edu.lsp.assignment2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ETLPipeline {
    public static void main(String[] args) {
        String inputFilePath = "data/products.csv";
        String outputFilePath = "data/transformed_products.csv";

        // (Extract)
        List<String[]> data = readCSV(inputFilePath);
        if (data == null) {
            System.out.println("Error reading input file.");
            return;
        }

        // transform the data
        List<String[]> transformedData = transformData(data);

        writeCSV(outputFilePath, transformedData);
    }

    // read CSV File (Extract)
    private static List<String[]> readCSV(String filePath) {
        List<String[]> rows = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip header
            while ((line = br.readLine()) != null) {
                rows.add(line.split(","));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + filePath);
        }
        return rows;
    }

    // transform the Data
    private static List<String[]> transformData(List<String[]> data) {
        List<String[]> transformed = new ArrayList<>();
        transformed.add(new String[] {"ProductID", "Name", "Price", "Category", "PriceRange"}); // Add header

        for (String[] row : data) {
            String productId = row[0];
            String name = capitalizeName(row[1]); 
            double price = Double.parseDouble(row[2]);
            String category = row[3];

            if (category.equals("Electronics")) {
                price = Math.round(price * 0.9 * 100.0) / 100.0;
            }

            if (category.equals("Electronics") && price > 500) {
                category = "Premium Electronics";
            }

            // determine PriceRange
            String priceRange = getPriceRange(price);

            transformed.add(new String[] {productId, name, String.valueOf(price), category, priceRange});
        }
        return transformed;
    }

    // capitalize Product Names
    private static String capitalizeName(String name) {
        String[] words = name.split(" ");
        StringBuilder capitalized = new StringBuilder();
        for (String word : words) {
            capitalized.append(word.substring(0, 1).toUpperCase())
                       .append(word.substring(1).toLowerCase())
                       .append(" ");
        }
        return capitalized.toString().trim();
    }

    // determine Price Range
    private static String getPriceRange(double price) {
        if (price <= 10) return "Low";
        else if (price <= 100) return "Medium";
        else if (price <= 500) return "High";
        else return "Premium";
    }

    // transformed Data to a CSV File (Load)
    private static void writeCSV(String filePath, List<String[]> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (String[] row : data) {
                bw.write(String.join(",", row));
                bw.newLine();
            }
            System.out.println("Transformed data written to: " + filePath);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + filePath);
        }
    }
}
