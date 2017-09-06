package com.jpmc.impl.sale;

import com.jpmc.impl.operation.AdjustmentOperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public final class Product {

    /***
     * Product name
     */
    private String name;

    /***
     * List of sales
     */
    private List<Sale> sales = new ArrayList<>();

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Sale> getSales() {
        return sales;
    }

    public void setSales(List<Sale> sales) {
        this.sales = sales;
    }

    /***
     * Add a sale to this product
     * @param sale sale that has to be added
     */
    public void addSale(Sale sale) {
        this.sales.add(sale);
        sale.setProduct(this);
    }

    /***
     * Adjust price value to all existing sales related to this product
     * @param adjustment adjustment that has to be applied
     */
    public void adjustSales(AdjustmentOperation adjustment) {
        for (Sale sale : sales) {
            sale.adjustValue(adjustment);
        }
    }

    /***
     * Calculate total value of sales related to this product
     * @return total value
     */
    public BigDecimal calculateSalesTotal() {
        BigDecimal result = BigDecimal.ZERO;
        for (Sale sale : sales) {
            result = result.add(sale.getValue());
        }
        return result;
    }

    /***
     * Retrieve number of sales related to this product
     * @return number of sales
     */
    public int retrieveNumberOfSales() {
        return this.sales != null ? this.sales.size() : 0;
    }

    /***
     * Print sales
     * @return value printed
     */
    public void printSales() {
        System.out.println("Product [name : " + name + ", number of sales : " + retrieveNumberOfSales() + ", total value : " + calculateSalesTotal() + "]");
    }

    /***
     * Print sales
     * @return value printed
     */
    public void printAdjustments() {
        for (Sale sale : sales) {
            sale.printAdjustments();
        }
    }

    @Override public int hashCode() {
        return name != null ? name.hashCode() : "".hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Product product = (Product) o;

        if (name != null ? !name.equals(product.name) : product.name != null)
            return false;

        return true;
    }
}
