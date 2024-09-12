package lldPractice.VendingMachineLLD.VendingMachine;

import lldPractice.VendingMachineLLD.VendingMachine.states.*;
import lldPractice.VendingMachineLLD.VendingMachine.states.impl.*;

import java.util.HashMap;

public class VendingMachine implements IVendingMachine{

    private HashMap<Integer,Rack> rackMap;

    private ItemDispenseState itemDispenseState;
    private ItemSelectionState itemSelectionState;
    private IdleState idleState;
    private RefundAmountState refundAmountState;
    private VendingMachineState state;
    private  Rack selectedRack;

    private int insertedCoins;

    private String message;
    private Product selectedItem;

    public VendingMachine(HashMap<Integer,Rack> rackMap) {
        this.rackMap = rackMap;
        itemDispenseState=new ItemDispenseState(this);
        itemSelectionState=new ItemSelectionState(this);
        idleState=new IdleState(this);
        refundAmountState=new RefundAmountState(this);
        System.out.println("Intializing default state as idle state ");
        setState(idleState);
        message ="Insert coin to starts with it";
        insertedCoins=0;
    }

    public VendingMachineState getState() {
        return state;
    }

    public HashMap<Integer, Rack> getRackMap() {
        return rackMap;
    }

    void setRackMap(HashMap<Integer, Rack> rackMap) {
        this.rackMap = rackMap;
    }


    public ItemDispenseState getItemDispenseState() {
        return itemDispenseState;
    }


    public ItemSelectionState getItemSelectionState() {
        return itemSelectionState;
    }

    IdleState getIdleState() {
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
    public void calculateAmount(){
        state.calculateAmount();
    }
    public void dispenseItem(){
        state.dispenseItem();
    }
    public void refundBalance(){
        state.refundBalance();
    }

    public int getInsertedCoins() {
        return insertedCoins;
    }

    public void setInsertedCoins(int insertedCoins) {
        this.insertedCoins = insertedCoins;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setSelectedItem(Product selectedItem) {
        this.selectedItem = selectedItem;
    }

    public Product getSelectedItem() {
        return selectedItem;
    }

    public void resetMachine() {
        setInsertedCoins(0);
        setSelectedItem(null);
        setSelectedRack(null);
        setState(idleState);
    }
}




