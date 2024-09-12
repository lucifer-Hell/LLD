package lldPractice.VendingMachineLLD.VendingMachine.states.impl;

import lldPractice.VendingMachineLLD.VendingMachine.VendingMachine;
import lldPractice.VendingMachineLLD.VendingMachine.states.VendingMachineState;

public class RefundAmountState implements VendingMachineState {
    private VendingMachine vendingMachine;

    public RefundAmountState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void refundBalance() {
        System.out.println("Refunding remained balance "+vendingMachine.getInsertedCoins());
        System.out.println("Returning to idle state");
        vendingMachine.resetMachine();

    }


}
