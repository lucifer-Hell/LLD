package lldPractice.VendingMachineLLD;

public class ItemSelectionState implements VendingMachineState {
    VendingMachine vendingMachine;
    public ItemSelectionState(VendingMachine vendingMachine) {
        this.vendingMachine=vendingMachine;
    }

    @Override
    public void selectRack(int rackNo) {
        System.out.println("selecting rack no: "+rackNo);
        vendingMachine.setSelectedRack(vendingMachine.getRackMap().get(rackNo));
        if(vendingMachine.getSelectedRack().products.empty()){
            // refund coin and prompt rack empty

        }
    }
}
