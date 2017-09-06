package com.jpmc.impl;

import com.jpmc.AdjustmentDto;
import com.jpmc.SaleService;
import com.jpmc.impl.message.MessageTypeBuilder;
import com.jpmc.impl.operation.OperationBuilder;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public final class SaleServiceImpl implements SaleService {



    @Override public void notifyOneSale(String product, BigDecimal price) {
        SaleManagerImpl.getInstance().processMessage(MessageTypeBuilder.createMessageType(product, price));
    }

    @Override public void notifySeveralSales(String product, BigDecimal price, int occurences) {
        SaleManagerImpl.getInstance().processMessage(MessageTypeBuilder.createMessageType(product, price, occurences));
    }

    @Override public void notifySaleAndAdjustPrice(String product, BigDecimal price, AdjustmentDto adjustment) {
        SaleManagerImpl.getInstance().processMessage(MessageTypeBuilder.createMessageType(product, price, OperationBuilder.createAdjustmentOperation(adjustment)));

    }
}
