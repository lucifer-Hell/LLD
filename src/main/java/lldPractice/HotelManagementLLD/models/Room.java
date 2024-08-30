package lldPractice.HotelManagementLLD.models;

import lldPractice.HotelManagementLLD.enums.RoomStatus;
import lldPractice.HotelManagementLLD.enums.RoomType;

public class Room {
    RoomType roomType;
    RoomStatus roomStatus;
    String roomNumber;
    int maxCapacity;
    int currentCapacity;
}
