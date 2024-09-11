package lldPractice.VendingMachineLLD;

public interface VendingMachineState {
    default void insertCoin(int coin){
        throw new IllegalStateException("Illegal action triggered");
    }
    default void selectRack(int rackNo){
        throw new IllegalStateException("Illegal action triggered");
    };
    default void calculateAmount(){
        throw new IllegalStateException("Illegal action triggered");
    };
    default void dispenseItem(){
        throw new IllegalStateException("Illegal action triggered");
    };
    default void refundBalance(){
        throw new IllegalStateException("Illegal action triggered");
    };
}

