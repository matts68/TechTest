package com.jpmc.impl;

import com.jpmc.impl.message.MessageType;
import com.jpmc.impl.sale.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public final class SaleManagerImpl implements SaleManager {

    private static SaleManagerImpl instance = null;

    /***
     * List of products
     */
    private final List<Product> products = new ArrayList<>();

    /***
     * Is application paused?
     */
    private boolean paused = false;

    /***
     * Message counter
     */
    private static Long MESSAGE_COUNT = Long.valueOf(0);

    /***
     * Return only one instance of manager (Singleton pattern)
     * @return instance of manager that is running
     */
    public static SaleManagerImpl getInstance() {
        if (instance == null) {
            instance = new SaleManagerImpl();
        }
        return instance;
    }

    @Override public void processMessage(MessageType message) {
        if (paused) {
            // Message is not allowed
            System.out.println("System is paused, message is rejected");
            return;
        }
        // Increment message counter
        MESSAGE_COUNT++;
        // Get product details or add it if it does not exist
        Product productDetails = retrieveProduct(message);
        // Add sale information for this product
        message.process(productDetails);
        // 10th message?
        if (MESSAGE_COUNT % 10 == 0) {
            // Print sales for each product
            for (Product product : products) {
                product.printSales();
            }
        }
        // 50th message?
        else if (MESSAGE_COUNT % 50 == 0) {
            // Pause application
            paused = true;
            // Print adjustments for each sale type
            for (Product product : products) {
                product.printAdjustments();
            }
            paused = false;
        }
    }

    /***
     * Retrieve product, or create if if needed
     * @param message message related to sale
     * @return product
     */
    private Product retrieveProduct(MessageType message) {
         Product productFromList = null;
         String productName = message.getProductName();
         // Retrieve product
         List<Product> filteredList = products.stream()
             .filter(product -> product.getName().equals(productName))
             .collect(Collectors.toList());
         if (filteredList.isEmpty()) {
             // Product does not exist - create it and add it to list
             productFromList = new Product(productName);
             products.add(productFromList);
         } else {
             // Product already exists
             productFromList = filteredList.get(0);
         }

         return productFromList;
    }
}
