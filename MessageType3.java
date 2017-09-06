package com.jpmc.impl.message;

import com.jpmc.impl.operation.AdjustmentOperation;
import com.jpmc.impl.sale.Product;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public final class MessageType3 extends MessageType {

    /**
     * AdjustmentDto to apply
     */
    private AdjustmentOperation adjustment;

    public MessageType3(String productName, BigDecimal saleValue, AdjustmentOperation adjustment) {
        super(productName, saleValue);
        this.adjustment = adjustment;
    }

    public AdjustmentOperation getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(AdjustmentOperation adjustment) {
        this.adjustment = adjustment;
    }

    @Override public void process(Product product) {
        // Process a sale and adjust sale price for a product
        super.process(product);
        product.adjustSales(adjustment);
    }
}
