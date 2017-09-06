package test.operation;

import com.jpmc.AdjustmentDto;
import com.jpmc.AdjustmentType;
import com.jpmc.impl.operation.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 06.09.2017.
 */
public class OperationBuilderTest {

    @Test
    public void testBuildOperation() {
        AdjustmentType type = AdjustmentType.MULTIPLY;
        BigDecimal value = BigDecimal.valueOf(1.1);
        AdjustmentDto dto = new AdjustmentDto(type, value);
        AdjustmentOperation result = OperationBuilder.createAdjustmentOperation(dto);
        Assert.assertNotNull("Not null operation", result);
        Assert.assertEquals("Build expected operation", result.getClass(), MultiplyOperation.class);
        Assert.assertEquals("Build known value", result.getValue(), value);
    }

    @Test
    public void testBuildUnknownOperation() {
        BigDecimal value = BigDecimal.valueOf(1.1);
        AdjustmentDto dto = new AdjustmentDto(null, value);
        AdjustmentOperation result = OperationBuilder.createAdjustmentOperation(dto);
        Assert.assertNull("Unknown operation", result);
    }

}
