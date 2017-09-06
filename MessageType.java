package com.jpmc.impl.message;

import com.jpmc.impl.sale.Product;
import com.jpmc.impl.sale.Sale;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public abstract class MessageType {

    /***
     * Product name
     */
    private String productName;

    /***
     * Sale value
     */
    private BigDecimal saleValue;

    public MessageType(String productName, BigDecimal saleValue) {
        this.productName = productName;
        this.saleValue = saleValue;
    }

    public BigDecimal getSaleValue() {
        return saleValue;
    }

    public void setSaleValue(BigDecimal saleValue) {
        this.saleValue = saleValue;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    /***
     * Process a product
     * @param product product
     */
    public void process(Product product) {
        product.addSale(new Sale(saleValue, product));
    }
}
