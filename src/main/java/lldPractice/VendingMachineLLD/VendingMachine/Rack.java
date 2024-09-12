package lldPractice.VendingMachineLLD.VendingMachine;

import java.util.Stack;

public class Rack {
    public Stack<Product> getProducts() {
        return products;
    }

    public void setProducts(Stack<Product> products) {
        this.products = products;
    }

    Stack<Product> products;
    public Rack(Stack<Product> products){
        this.products=products;
    };
}
