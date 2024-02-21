package io.eliseoorellana.classicmodels.CommissionCalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ConsoleDemo {

public static void main(String[] args) {


    List<Integer> sales = generateRandomSales(5);
    System.out.println("-----------------------------------------------");
    System.out.println("Demostracion Calculadora de Comisiones de venta");
    System.out.println("-----------------------------------------------");
    System.out.println();
    System.out.println("Tomando 5 montos de venta aleatorios..." + sales);


    CommissionCalculator simpleCalculator = new SimpleCommissionCalculator();
    CommissionCalculator complexCalculator = new ComplexCommissionCalculator();

    // Calcular comisiones
    int simpleCommission = simpleCalculator.calculateCommission(sales);
    int complexCommission = complexCalculator.calculateCommission(sales);

    // Mostrar resultados
    System.out.println("Descuento con Algoritmo Simple: " + simpleCommission);
    System.out.println("Descuento con Algoritmo Complejo: " + complexCommission);
}

// Método para generar ventas aleatorias entre $1000 y $20000
private static List<Integer> generateRandomSales(int count) {
    Random random = new Random();
    List<Integer> sales = new ArrayList<>();
    for (int i = 0; i < count; i++) {
        int sale = random.nextInt(19001) + 1000;
        sales.add(sale);
    }
    return sales;
}
}