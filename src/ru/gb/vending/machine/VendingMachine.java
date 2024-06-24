package ru.gb.vending.machine;

import ru.gb.vending.product.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {

    private List<Product> productList;

    public VendingMachine() {
        productList = new ArrayList<>();
    }

    public void addProduct(Product product) {
        productList.add(product);
    }

    public Product findProductByName(String nameFind) {
        for (Product product : productList) {
            if(product.getName().equalsIgnoreCase(nameFind)) {
                return product;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Список продуктов:\n");
        for (Product product : productList) {
            stringBuilder.append(product);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
