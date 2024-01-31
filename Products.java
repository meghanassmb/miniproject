package miniproject;

import java.util.HashMap;

public class Products {

    private HashMap<String, Double> productMap = new HashMap<String, Double>();

    public void buyProduct(String productName, double productPrice) {
        productMap.put(productName, productPrice);
        System.out.print("---------------------------------- \n");
        System.out.println("Product bought: \n" + productName);
        System.out.print("---------------------------------- \n");
    }

    public void cancelProduct(String productName) {
        if (productMap.containsKey(productName)) {
            productMap.remove(productName);
            System.out.print("---------------------------\n ");
            System.out.println("Product canceled: \n " + productName);
        }
        else 
        {
            System.out.println("Product not found");
            System.out.print("-----------------------------\n ");
        }
    }

    public void displayAllProducts() {
        for (String productName : productMap.keySet()) {
            System.out.println(productName + ": " + productMap.get(productName));
        }
    }
}

