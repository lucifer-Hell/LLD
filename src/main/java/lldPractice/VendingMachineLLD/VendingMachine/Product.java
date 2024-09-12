package lldPractice.VendingMachineLLD.VendingMachine;

public class Product {
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    String productName;

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    int productPrice;
    public Product(String productName,int productPrice ){
        this.productPrice=productPrice;
        this.productName=productName;
    }
}
