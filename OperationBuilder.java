package com.jpmc.impl.operation;

import com.jpmc.AdjustmentDto;
import com.jpmc.impl.message.MessageType;
import com.jpmc.impl.message.MessageType1;
import com.jpmc.impl.message.MessageType2;
import com.jpmc.impl.message.MessageType3;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 05.09.2017.
 */
public class OperationBuilder {

    /***
     * Create an operation from an adjustment dto
     * @param dto dto
     * @return operation
     */
    public static AdjustmentOperation createAdjustmentOperation(AdjustmentDto dto) {
        if (dto.getType() != null) {
            switch (dto.getType()) {
                case ADD:
                    return new AddOperation(dto.getValue());
                case MULTIPLY:
                    return new MultiplyOperation(dto.getValue());
                case SUBTRACT:
                    return new SubtractOperation(dto.getValue());
            }
        }
        return null;
    }

}
