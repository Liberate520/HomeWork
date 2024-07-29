package ru.gb.vending;

import ru.gb.vending.machine.VendingMachine;
import ru.gb.vending.product.Bottle;
import ru.gb.vending.product.Product;

public class Main {
    public static void main(String[] args) {

        VendingMachine vendingMachine = new VendingMachine();

        Product product = new Product("Шоколадка", 50);
        Product product2 = new Product("Чипсы", 80);
        Bottle product3 = new Bottle("Вода", 40, 0.5);

        vendingMachine.addProduct(product);
        vendingMachine.addProduct(product2);
        vendingMachine.addProduct(product3);

        System.out.println(vendingMachine);
    }
}
