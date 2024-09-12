package lldPractice.VendingMachineLLD.VendingMachine.states.impl;

import lldPractice.VendingMachineLLD.VendingMachine.Product;
import lldPractice.VendingMachineLLD.VendingMachine.Rack;
import lldPractice.VendingMachineLLD.VendingMachine.VendingMachine;
import lldPractice.VendingMachineLLD.VendingMachine.states.VendingMachineState;

import java.util.Map;

public class ItemSelectionState implements VendingMachineState {
    VendingMachine vendingMachine;
    public ItemSelectionState(VendingMachine vendingMachine) {
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void selectRack(int rackNo) {
        System.out.println("selecting rack no: "+rackNo);
        Map<Integer, Rack> map=vendingMachine.getRackMap();
        if(map.containsKey(rackNo)){
            Rack rack=map.get(rackNo);
            if(rack.getProducts().empty()){
                System.out.println("Rack is empty ");
                vendingMachine.setState(vendingMachine.getRefundAmountState());
                vendingMachine.refundBalance();
            }
            else {
                Product product =rack.getProducts().pop();
                System.out.println("You selected product "+product.getProductName());
                if(product.getProductPrice()>vendingMachine.getInsertedCoins()){
                    // refund coins
                    vendingMachine.setState(vendingMachine.getRefundAmountState());
                    vendingMachine.refundBalance();
                }else {
                    vendingMachine.setInsertedCoins( vendingMachine.getInsertedCoins()-product.getProductPrice());
                    vendingMachine.setState(vendingMachine.getItemDispenseState());
                    vendingMachine.setSelectedItem(product);
                    System.out.println("Dispensing item ... ");
                    vendingMachine.dispenseItem();
                }
            }
        }else{
            throw new IllegalStateException("Invalid rack no selected");
        }
    }
}
