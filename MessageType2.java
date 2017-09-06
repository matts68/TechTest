package com.jpmc.impl.message;

import com.jpmc.impl.sale.Product;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public final class MessageType2 extends MessageType {

    /***
     * Number of occurences of a sale
     */
    private int nbOccurences;

    public MessageType2(String productName, BigDecimal saleValue, int nbOccurences) {
        super(productName, saleValue);
        this.nbOccurences = nbOccurences;
    }

    public int getNbOccurences() {
        return nbOccurences;
    }

    public void setNbOccurences(int nbOccurences) {
        this.nbOccurences = nbOccurences;
    }

    @Override public void process(Product product) {
        // Process n times a sale
        for (int i = 0; i < nbOccurences; i++) {
            super.process(product);
        }
    }
}
