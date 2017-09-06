package com.jpmc.impl.operation;

import com.jpmc.AdjustmentType;
import static com.jpmc.AdjustmentType.ADD;
import static com.jpmc.AdjustmentType.MULTIPLY;
import static com.jpmc.AdjustmentType.SUBTRACT;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public abstract class AdjustmentOperation {

    private BigDecimal value;

    public AdjustmentOperation(BigDecimal value){
        this.value = value;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    /***
     * Apply current adjustment on other value
     * @param otherValue
     * @return value ajusted
     */
    public abstract BigDecimal applyOperation(BigDecimal otherValue);

    /***
     * Initialize value if needed
     * @param value value to be cleared
     * @return value
     */
    public BigDecimal clearValue(BigDecimal value) {
        return value != null ? value : BigDecimal.ZERO;
    }

    /**
     * Get type of operation
     * @return operation type
     */
    public abstract String getType();

}
