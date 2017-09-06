package test.message;

import com.jpmc.impl.message.MessageType1;
import com.jpmc.impl.operation.AddOperation;
import com.jpmc.impl.operation.MultiplyOperation;
import com.jpmc.impl.operation.SubtractOperation;
import com.jpmc.impl.sale.Product;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

/**
 * Created by M. Schittly on 06.09.2017.
 */
public class MessageTypeTest {

    @Test
    public void testProcess() {
        String productName = "lemon";
        BigDecimal value = BigDecimal.valueOf(2);
        MessageType1 messageType = new MessageType1(productName, value);
        Product product = new Product(productName);
        messageType.process(product);
        Assert.assertNotNull("Sales not null", product.getSales());
        Assert.assertEquals("Sale added to product", product.getSales().size(), 1);
    }

}
