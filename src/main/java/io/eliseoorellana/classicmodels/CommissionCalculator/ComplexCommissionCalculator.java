package io.eliseoorellana.classicmodels.CommissionCalculator;

import java.util.List;

public class ComplexCommissionCalculator implements CommissionCalculator{

    @Override
    public int calculateCommission(List<Integer> sales) {
        int totalSales = sales.stream().mapToInt(Integer::intValue).sum();
        int commission = totalSales * 5 / 100;

        for (int sale : sales) {
            if (sale > 10000) {
                commission += sale * 3 / 100;
            } else if (sale > 5000) {
                commission += sale * 2 / 100;
            }
        }

        if (totalSales > 50000) {
            commission += totalSales * 1 / 100;
        }

        return commission;
    }

}
