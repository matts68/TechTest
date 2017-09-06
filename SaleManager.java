package com.jpmc.impl;

import com.jpmc.impl.message.MessageType;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public interface SaleManager {

    /***
     * Process a message that notifies a sale
     * @param message message that has to be processed
     */
    void processMessage(MessageType message);

}
