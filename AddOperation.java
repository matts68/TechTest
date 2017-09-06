package com.jpmc.impl.operation;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public class AddOperation extends AdjustmentOperation {

    public AddOperation(BigDecimal value){
        super(value);
    }

    @Override public BigDecimal applyOperation(BigDecimal otherValue) {
        return clearValue(otherValue).add(clearValue(getValue()));
    }

    @Override public String getType() {
        return "ADD";
    }
}
