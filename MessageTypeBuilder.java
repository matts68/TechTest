package com.jpmc.impl.message;

import com.jpmc.impl.operation.AdjustmentOperation;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public class MessageTypeBuilder {

    /***
     * Build a message type 1
     * @param product product name
     * @param price sale value
     * @return message
     */
    public static MessageType createMessageType(String product, BigDecimal price) {
        return new MessageType1(product, price);
    }
    /***
     * Build a message type 2
     * @param product product name
     * @param price sale value
     * @param occurences number of occurences
     * @return message
     */
    public static MessageType createMessageType(String product, BigDecimal price, int occurences) {
        return new MessageType2(product, price, occurences);
    }
    /***
     * Build a message 3
     * @param product product name
     * @param price sale value
     * @param adjustment adjustment
     * @return message
     */
    public static MessageType createMessageType(String product, BigDecimal price, AdjustmentOperation adjustment) {
        return new MessageType3(product, price, adjustment);
    }

}
