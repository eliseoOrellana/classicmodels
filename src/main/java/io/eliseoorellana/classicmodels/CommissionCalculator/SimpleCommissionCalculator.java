package io.eliseoorellana.classicmodels.CommissionCalculator;

import java.util.List;

public class SimpleCommissionCalculator implements CommissionCalculator {

    @Override
    public int calculateCommission(List<Integer> sales) {
        int totalSales = sales.stream().mapToInt(Integer::intValue).sum();
        return totalSales > 10000 ? totalSales * 10 / 100 : totalSales * 5 / 100;
    }

}
