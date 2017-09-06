package com.jpmc;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public class AdjustmentDto {

    private AdjustmentType type;

    private BigDecimal value;

    public AdjustmentDto(AdjustmentType type, BigDecimal value) {
        this.type = type;
        this.value = value;
    }

    public AdjustmentType getType() {
        return type;
    }

    public void setType(AdjustmentType type) {
        this.type = type;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

}
