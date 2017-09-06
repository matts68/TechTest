package com.jpmc.impl.operation;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public class MultiplyOperation extends AdjustmentOperation {

    public MultiplyOperation(BigDecimal value){
        super(value);
    }

    @Override public BigDecimal applyOperation(BigDecimal otherValue) {
        return clearValue(otherValue).multiply(clearValue(getValue()));
    }

    @Override public String getType() {
        return "MULTIPLY";
    }
}
