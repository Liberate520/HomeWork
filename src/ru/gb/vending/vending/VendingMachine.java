package ru.gb.vending.vending;

import ru.gb.vending.product.Product;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private List<Product> productList;

    public VendingMachine(){
        productList = new ArrayList<>();
    }

    public void addProduct(Product product){
        productList.add(product);
    }
    public Product findByName(String nameProduct){
        for (Product product: productList) {
            if (product.getName().equalsIgnoreCase(nameProduct)){
                return product;
            }
            
        }
        return null;
    }


    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        strB.append("Список товаров:\n");
        for (Product product : productList){
            strB.append(product);
            strB.append("\n");
        }
        return strB.toString();
    }
}
