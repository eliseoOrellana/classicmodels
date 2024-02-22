package io.eliseoorellana.classicmodels;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import io.eliseoorellana.classicmodels.CommissionCalculator.CommissionCalculator;
import io.eliseoorellana.classicmodels.CommissionCalculator.ComplexCommissionCalculator;

public class ComplexCommissionCalculatorTest {

    @Test
    void testCalculateCommission_NormalCases() {
        // Casos normales con diferentes montos de venta
        List<Integer> sales1 = Arrays.asList(5000, 10000, 15000);
        List<Integer> sales2 = Arrays.asList(20000, 30000, 40000);

        // Crear instancia de calculadora de comisiones complejas
        CommissionCalculator calculator = new ComplexCommissionCalculator();

        // Verificar el cálculo de comisiones para los casos normales
        assertEquals(2150, calculator.calculateCommission(sales1)); 
        assertEquals(8100, calculator.calculateCommission(sales2)); 
    }

    @Test
    void testCalculateCommission_EdgeCases() {
        // Casos de borde
        List<Integer> sales3 = Arrays.asList(0);

        // Crear instancia de calculadora de comisiones complejas
        CommissionCalculator calculator = new ComplexCommissionCalculator();

        // Verificar el cálculo de comisiones para los casos de borde
        assertEquals(0, calculator.calculateCommission(sales3)); 
    }
}
