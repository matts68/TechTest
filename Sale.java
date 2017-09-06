package com.jpmc.impl.sale;

import com.jpmc.impl.operation.AdjustmentOperation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public final class Sale {

    /***
     * Last sale identifier
     */
    private static Long LAST_SALE_ID = Long.valueOf(0);

    /***
     * Sale identifier
     */
    private Long id;

    /***
     * Sale value
     */
    private BigDecimal value;

    /***
     * Product
     */
    private Product product;

    /***
     * Adjustments applied to sale
     */
    private List<AdjustmentOperation> adjustments = new ArrayList<>();

    public Sale(BigDecimal value, Product product) {
        this.id = ++LAST_SALE_ID;
        this.value = value;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<AdjustmentOperation> getAdjustments() {
        return adjustments;
    }

    public void setAdjustments(List<AdjustmentOperation> adjustments) {
        this.adjustments = adjustments;
    }

    /***
     * Adjust price value
     * @param adjustment adjustment to be applied
     */
    public void adjustValue(AdjustmentOperation adjustment) {
        // Add adjustment to list of operations done
        this.adjustments.add(adjustment);
        // Apply adjustment to current value
        value = adjustment.applyOperation(value);
    }

    /***
     * Print adjustments
     * @return value printed
     */
    public void printAdjustments() {
        StringBuilder result = new StringBuilder();
        result.append("Sale [id : " + this.id + "]\n");
        for (AdjustmentOperation adjustment : this.adjustments) {
            result.append("-> adjustment [type : " + adjustment.getType() + ", value : " + adjustment.getValue() + "]");
        }
        System.out.println(result.toString());
    }

    @Override public int hashCode() {
        return id.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Sale sale = (Sale) o;

        if (id != null ? !id.equals(sale.id) : sale.id != null)
            return false;

        return true;
    }
}
