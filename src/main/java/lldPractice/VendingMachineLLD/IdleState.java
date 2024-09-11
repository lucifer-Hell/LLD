package lldPractice.VendingMachineLLD;

public class IdleState implements VendingMachineState {
    VendingMachine vendingMachine;
    IdleState(VendingMachine vendingMachine){
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void insertCoin(int coin){
        System.out.println("Inserting coin "+coin);
        vendingMachine.setInsertedCoins(coin);
        System.out.println("Chaning state to item selection");
        vendingMachine.setState(vendingMachine.getItemSelectionState());
    }
}
