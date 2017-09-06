package com.jpmc;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public interface SaleService {

    /***
     * Notify a sale for one product
     * @param product product name
     * @param price price related to this sale
     */
    void notifyOneSale(String product, BigDecimal price);

    /***
     * Notify several sales for one product
     * @param product product name
     * @param price price related to those sales
     * @param occurences number of occurence of sales
     */
    void notifySeveralSales(String product, BigDecimal price, int occurences);

    /***
     * Notify a sale for one product and adjust price to all existing sales for this product
     * @param product product name
     * @param price price related to this sale
     * @param adjustment adjustment that has to be applied to other sales
     */
    void notifySaleAndAdjustPrice(String product, BigDecimal price, AdjustmentDto adjustment);

}
