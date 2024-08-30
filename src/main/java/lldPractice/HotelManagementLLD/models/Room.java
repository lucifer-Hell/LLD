package lldPractice.HotelManagementLLD.models;

import lldPractice.HotelManagementLLD.enums.RoomStatus;
import lldPractice.HotelManagementLLD.enums.RoomType;

public class Room {

    public Room(String id, RoomType roomType, String roomNumber, int maxCapacity,double roomPrice) {
        this.id = id;
        this.roomType = roomType;
        this.roomStatus = RoomStatus.AVAILABLE;
        this.roomNumber = roomNumber;
        this.maxCapacity = maxCapacity;
        this.roomPrice = roomPrice;
    }

    private String id;
    private RoomType roomType;
    private RoomStatus roomStatus;
    private String roomNumber;
    private int maxCapacity;
    private int currentCapacity;
    private double roomPrice;

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
        if(roomStatus.equals(RoomStatus.BOOKED)) {
            System.out.println("checked in at "+roomNumber);
            setRoomStatus(RoomStatus.OCCUPIED);
        }
        else throw new IllegalStateException("ROOM NOT BOOOKED OR IS ALREADY OCCUPIED BY SOMEONE ELSE ");
    }

    public synchronized void checkOut(){
        if(roomStatus.equals(RoomStatus.OCCUPIED)) {
            System.out.println("checking out room "+ roomNumber);
            setRoomStatus(RoomStatus.AVAILABLE);
        }
        else throw new IllegalStateException("CAN'T CHECKOUT ON OCCUPIED ROOM ");
    }

    public synchronized void book(){
        if(roomStatus.equals(RoomStatus.AVAILABLE)) {
            System.out.println("booked room "+roomNumber);
            setRoomStatus(RoomStatus.BOOKED);
        }
        else throw new IllegalStateException("ROOM ALREADY BOOKED OR OCCUPIED BY SOMEONE ELSE ");
    }

}
