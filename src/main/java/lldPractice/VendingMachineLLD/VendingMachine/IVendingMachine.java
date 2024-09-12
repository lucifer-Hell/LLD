package lldPractice.VendingMachineLLD.VendingMachine;

import lldPractice.VendingMachineLLD.VendingMachine.states.VendingMachineState;

public interface IVendingMachine {

     void insertCoin(int coin);
     void selectRack(int rackNo);

     String getMessage();

}
