package test.message;

import com.jpmc.AdjustmentDto;
import com.jpmc.AdjustmentType;
import com.jpmc.impl.message.*;
import com.jpmc.impl.operation.AddOperation;
import com.jpmc.impl.operation.AdjustmentOperation;
import com.jpmc.impl.operation.MultiplyOperation;
import com.jpmc.impl.operation.OperationBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 06.09.2017.
 */
public class MessageTypeBuilderTest {

    @Test
    public void testBuildMessageType1() {
        String product = "apple";
        BigDecimal price = BigDecimal.valueOf(1.1);
        MessageType result = MessageTypeBuilder.createMessageType(product, price);
        Assert.assertNotNull("Not null message", result);
        Assert.assertEquals("Build expected message", result.getClass(), MessageType1.class);
        Assert.assertEquals("Build expected product name", result.getProductName(), product);
        Assert.assertEquals("Build expected price", result.getSaleValue(), price);
    }

    @Test
    public void testBuildMessageType2() {
        String product = "banana";
        BigDecimal price = BigDecimal.valueOf(12);
        int occurences = 2;
        MessageType result = MessageTypeBuilder.createMessageType(product, price, occurences);
        Assert.assertNotNull("Not null message", result);
        Assert.assertEquals("Build expected message", result.getClass(), MessageType2.class);
        Assert.assertEquals("Build expected product name", result.getProductName(), product);
        Assert.assertEquals("Build expected price", result.getSaleValue(), price);
    }

    @Test
    public void testBuildMessageType3() {
        String product = "lemon";
        BigDecimal price = BigDecimal.valueOf(7.5);
        AdjustmentOperation operation = new AddOperation(BigDecimal.valueOf(1));
        MessageType result = MessageTypeBuilder.createMessageType(product, price, operation);
        Assert.assertNotNull("Not null message", result);
        Assert.assertEquals("Build expected message", result.getClass(), MessageType3.class);
        Assert.assertEquals("Build expected product name", result.getProductName(), product);
        Assert.assertEquals("Build expected price", result.getSaleValue(), price);
    }

}
