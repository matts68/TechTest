package com.jpmc;

import com.jpmc.impl.SaleServiceImpl;
import static com.jpmc.AdjustmentType.ADD;
import static com.jpmc.AdjustmentType.MULTIPLY;
import static com.jpmc.AdjustmentType.SUBTRACT;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
	    SaleService saleService = new SaleServiceImpl();

	    saleService.notifyOneSale("apple", BigDecimal.valueOf(2.5));
        saleService.notifySeveralSales("banana", BigDecimal.valueOf(3.6), 5);
        saleService.notifySeveralSales("lemon", BigDecimal.valueOf(5), 2);
        saleService.notifyOneSale("coca cola", BigDecimal.valueOf(2.7));
        saleService.notifyOneSale("red wine", BigDecimal.valueOf(22));
        saleService.notifySeveralSales("apple", BigDecimal.valueOf(2.5), 2);
        saleService.notifyOneSale("banana", BigDecimal.valueOf(3.6));
        saleService.notifySaleAndAdjustPrice("lemon", BigDecimal.valueOf(5), new AdjustmentDto(SUBTRACT, BigDecimal.valueOf(2)));
        saleService.notifySaleAndAdjustPrice("coca cola", BigDecimal.valueOf(2.9), new AdjustmentDto(MULTIPLY, BigDecimal.valueOf(1.1)));
        saleService.notifySaleAndAdjustPrice("red wine", BigDecimal.valueOf(20), new AdjustmentDto(ADD, BigDecimal.valueOf(1)));

    }
}
