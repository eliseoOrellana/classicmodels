package io.eliseoorellana.classicmodels.CommissionCalculator;

import java.util.List;

public class ComplexCommissionCalculator implements CommissionCalculator {
   
    private static final double BASE_COMMISSION_RATE = 0.05;
    private static final double ADDITIONAL_RATE_1 = 0.02;
    private static final double ADDITIONAL_RATE_2 = 0.03;
    private static final double ADDITIONAL_RATE_3 = 0.01;
    private static final double THRESHOLD_1 = 5000;
    private static final double THRESHOLD_2 = 10000;
    private static final double THRESHOLD_3 = 50000;

    @Override
    public int calculateCommission(List<Integer> sales) {
        if (sales.isEmpty()) {
            return 0; // Si no hay ventas, la comisión es 0
        }

        int totalSales = sales.stream().mapToInt(Integer::intValue).sum();
        double commission = totalSales * BASE_COMMISSION_RATE;

        // Verificar si alguna venta está en el rango de U$ 5000 y U$ 10000
        for (int sale : sales) {
            if (sale > THRESHOLD_1 && sale <= THRESHOLD_2) {
                commission += sale * ADDITIONAL_RATE_1;
            }
        }

        // Verificar si alguna venta es mayor a U$ 10000
        for (int sale : sales) {
            if (sale > THRESHOLD_2) {
                commission += sale * ADDITIONAL_RATE_2;
            }
        }

        // Verificar si la suma de todas las ventas es superior a U$ 50000
        if (totalSales > THRESHOLD_3) {
            commission += totalSales * ADDITIONAL_RATE_3;
        }

        return (int) Math.round(commission);
    }
    }