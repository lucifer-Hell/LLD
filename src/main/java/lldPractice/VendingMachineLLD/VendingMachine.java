package lldPractice.VendingMachineLLD;

import javax.swing.plaf.nimbus.State;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class VendingMachine {


    public HashMap<Integer, Rack> getRackMap() {
        return rackMap;
    }

    public void setRackMap(HashMap<Integer, Rack> rackMap) {
        this.rackMap = rackMap;
    }

    private HashMap<Integer,Rack> rackMap;

    private ItemDispenseState itemDispenseState;
    private BalanceCalculationState balanceCalculationState;
    private ItemSelectionState itemSelectionState;
    private  IdleState idleState;
    private  RefundAmountState refundAmountState;
    private VendingMachineState state;
    private  Rack selectedRack;

    private int insertedCoins;

    private String messsage;

    public VendingMachine(HashMap<Integer,Rack> rackMap) {
        this.rackMap = rackMap;
        ItemDispenseState itemDispenseState=new ItemDispenseState(this);
        BalanceCalculationState balanceCalculationState=new BalanceCalculationState(this);
        ItemSelectionState itemSelectionState=new ItemSelectionState(this);
        IdleState idleState=new IdleState(this);
        RefundAmountState refundAmountState=new RefundAmountState(this);
        System.out.println("Intializing default state as idle state ");
        setState(idleState);
        messsage="Insert coin to starts with it";
        insertedCoins=0;
    }

    public VendingMachineState getState() {
        return state;
    }


    public ItemDispenseState getItemDispenseState() {
        return itemDispenseState;
    }

    public BalanceCalculationState getBalanceCalculationState() {
        return balanceCalculationState;
    }

    public ItemSelectionState getItemSelectionState() {
        return itemSelectionState;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public RefundAmountState getRefundAmountState() {
        return refundAmountState;
    }

    public void setState(VendingMachineState state){
        this.state=state;
    }

    // insert coin
    public void insertCoin(int coin){
        state.insertCoin(coin);
    }
    // select rack no
    public void selectRack(int rackNo){
        state.selectRack(rackNo);
    }

    public Rack getSelectedRack() {
        return selectedRack;
    }

    public void setSelectedRack(Rack selectedRack) {
        this.selectedRack = selectedRack;
    }
    private void calculateAmount(){
        state.calculateAmount();
    }
    private void dispenseItem(){
        state.dispenseItem();
    }
    private void refundBalance(){
        state.refundBalance();
    }

    public int getInsertedCoins() {
        return insertedCoins;
    }

    public void setInsertedCoins(int insertedCoins) {
        this.insertedCoins = insertedCoins;
    }

    public String getMesssage() {
        return messsage;
    }

    public void setMesssage(String messsage) {
        this.messsage = messsage;
    }
    // calculate balance
    // dispense item
    // refund balance
}




