package test.operation;

import com.jpmc.impl.operation.AddOperation;
import com.jpmc.impl.operation.MultiplyOperation;
import com.jpmc.impl.operation.OperationBuilder;
import com.jpmc.impl.operation.SubtractOperation;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 06.09.2017.
 */
public class OperationTest {

    @Test
    public void testAddOperation() {
        BigDecimal value = BigDecimal.valueOf(10);
        BigDecimal otherValue = BigDecimal.valueOf(3);
        AddOperation operation = new AddOperation(value);
        BigDecimal result = operation.applyOperation(otherValue);
        Assert.assertEquals("Add operation", result, otherValue.add(value));
    }

    @Test
    public void testMultiplyOperation() {
        BigDecimal value = BigDecimal.valueOf(2);
        BigDecimal otherValue = BigDecimal.valueOf(5);
        MultiplyOperation operation = new MultiplyOperation(value);
        BigDecimal result = operation.applyOperation(otherValue);
        Assert.assertEquals("Multiply operation", result, otherValue.multiply(value));
    }

    @Test
    public void testSubtractOperation() {
        BigDecimal value = BigDecimal.valueOf(2.5);
        BigDecimal otherValue = BigDecimal.valueOf(8);
        SubtractOperation operation = new SubtractOperation(value);
        BigDecimal result = operation.applyOperation(otherValue);
        Assert.assertEquals("Subtract operation", result, otherValue.subtract(value));
    }

}
