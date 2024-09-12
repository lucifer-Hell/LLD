package lldPractice.VendingMachineLLD;

import lldPractice.VendingMachineLLD.VendingMachine.IVendingMachine;
import lldPractice.VendingMachineLLD.VendingMachine.Product;
import lldPractice.VendingMachineLLD.VendingMachine.Rack;
import lldPractice.VendingMachineLLD.VendingMachine.VendingMachine;

import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class VendingMachineDemo {
    public static void main(String[] args) {
        IVendingMachine vendingMachine =new VendingMachine(new HashMap<Integer, Rack>(){{
            put(1,new Rack(
                    new Stack<Product>(){{
                        push(  new Product("THUMBS UP",30));
                        push(  new Product("FRUTI",30));
                        push(  new Product("MAZA",30));
                    }}
            ));
            put(2,new Rack(
                    new Stack<Product>(){{
                        push(  new Product("THUMBS UP",30));
                    }}
            ));
            put(3,new Rack(
                    new Stack<Product>(){{
                        push(  new Product("MAZA",30));
                        push(  new Product("MAZA",30));
                        push(  new Product("THUMBS UP",30));
                        push(  new Product("FRUTI",30));
                        push(  new Product("MAZA",30));
                    }}
            ));
        }});
        vendingMachine.insertCoin(20);
        vendingMachine.selectRack(1);
        vendingMachine.insertCoin(30);
        vendingMachine.selectRack(1);
        vendingMachine.insertCoin(100);
        vendingMachine.selectRack(1);
        vendingMachine.insertCoin(100);
        vendingMachine.selectRack(1);
        vendingMachine.insertCoin(100);
        vendingMachine.selectRack(1);

    }
}
