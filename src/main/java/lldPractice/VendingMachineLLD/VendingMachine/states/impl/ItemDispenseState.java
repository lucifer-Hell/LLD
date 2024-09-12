package lldPractice.VendingMachineLLD.VendingMachine.states.impl;

import lldPractice.VendingMachineLLD.VendingMachine.VendingMachine;
import lldPractice.VendingMachineLLD.VendingMachine.states.VendingMachineState;

public class ItemDispenseState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public ItemDispenseState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }


    @Override
    public void dispenseItem() {
        System.out.println("Successfully dispensed "+vendingMachine.getSelectedItem().getProductName());
        System.out.println("changing state to refund remaining balance ");
        vendingMachine.setState(vendingMachine.getRefundAmountState());
        vendingMachine.refundBalance();
    }


}
