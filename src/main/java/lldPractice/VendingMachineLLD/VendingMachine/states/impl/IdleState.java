package lldPractice.VendingMachineLLD.VendingMachine.states.impl;

import lldPractice.VendingMachineLLD.VendingMachine.VendingMachine;
import lldPractice.VendingMachineLLD.VendingMachine.states.VendingMachineState;

public class IdleState implements VendingMachineState {
    VendingMachine vendingMachine;
    public IdleState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void insertCoin(int coin){
        if(coin<=0) {
            System.out.println("Invalid coins entered ");
            return;
        }
        System.out.println("Inserting coin "+coin);
        vendingMachine.setInsertedCoins(coin);
        System.out.println("Changing state to item selection state");
        vendingMachine.setState(vendingMachine.getItemSelectionState());
    }
}
