package lldPractice.HotelManagementLLD.models;

import lldPractice.HotelManagementLLD.enums.RoomStatus;
import lldPractice.HotelManagementLLD.enums.RoomType;

public class Room {

    String id;
    RoomType roomType;
    RoomStatus roomStatus;
    String roomNumber;
    int maxCapacity;
    int currentCapacity;
    double roomPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrentCapacity() {
        return currentCapacity;
    }

    public void setCurrentCapacity(int currentCapacity) {
        this.currentCapacity = currentCapacity;
    }

    public double getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public synchronized void checkIn(){
        if(roomStatus.equals(RoomStatus.BOOKED)) setRoomStatus(RoomStatus.OCCUPIED);
        else throw new IllegalStateException("ROOM NOT BOOOKED OR IS ALREADY OCCUPIED BY SOMEONE ELSE ");
    }

    public synchronized void checkOut(){
        if(roomStatus.equals(RoomStatus.OCCUPIED)) setRoomStatus(RoomStatus.AVAILABLE);
        else throw new IllegalStateException("CAN'T CHECKOUT ON OCCUPIED ROOM ");
    }

    public synchronized void book(){
        if(roomStatus.equals(RoomStatus.AVAILABLE)) setRoomStatus(RoomStatus.BOOKED);
        else throw new IllegalStateException("ROOM ALREADY BOOKED OR OCCUPIED BY SOMEONE ELSE ");
    }

}
