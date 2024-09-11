package lldPractice.HotelManagementLLD.service;

import lldPractice.HotelManagementLLD.enums.Gender;
import lldPractice.HotelManagementLLD.enums.RoomStatus;
import lldPractice.HotelManagementLLD.enums.RoomType;
import lldPractice.HotelManagementLLD.models.Guest;
import lldPractice.HotelManagementLLD.models.Reservation;
import lldPractice.HotelManagementLLD.models.Room;

import java.time.LocalDate;
import java.util.*;

public class HotelManagementService {
    private static HotelManagementService instance;
    private final Map<String,Reservation> reservations;
    private final Map<String,Room> rooms;
    private final Map<String,Guest> guests;
    // whenver making a single ton instance should use private constructor
    private HotelManagementService(){
        reservations=new HashMap<>();
        rooms=new HashMap<>();
        guests=new HashMap<>();
    }

    // room crud
    public Room addRoom(RoomType roomType,String roomNumber,int roomCapacity,double roomPrice){
        String roomId=generateRandomId("ROOM-");
        Room room=new Room(
                roomId,roomType,roomNumber,roomCapacity,roomPrice
        );
        rooms.put(roomId,room);
        return room;
    }

    // guest crud
    public Guest addGuest(String name, Gender gender,int age){
        String guestId=generateRandomId("GUEST-");
        Guest guest=new Guest(
                guestId,name,
                gender,null,age,null,null
        );
        guests.put(guestId,guest);
        System.out.println("New guest entered in system : "+name);
        return guest;
    }
    // createReservation()
    public Reservation createReservation(List<Guest> guests, List<Room> rooms, Guest bookedBy,LocalDate from, LocalDate to){
        String reservationId=generateRandomId("RES-");
        // check if possible to book rooms
        isReservationPossible(rooms);
        rooms.forEach(Room::book);
        Reservation reservation=new Reservation(
                reservationId,
                rooms,
                guests,
                bookedBy,
                LocalDate.now(),
                from,
                to
        );
        reservations.put(reservationId,reservation);
        System.out.println("Created reservation for "+guests.size()+ " booked by : "+bookedBy.getName());
        return reservation;
    }

    private void isReservationPossible(List<Room> rooms) {
        for (Room room : rooms) {
            if (room.getRoomStatus() == RoomStatus.BOOKED || room.getRoomStatus() == RoomStatus.OCCUPIED)
                throw new IllegalStateException("Rooms already booked or occupied ");
        }
    }

    // cancelReservation()
    public void cancelReservation(String reservationId){
        Reservation reservation=reservations.getOrDefault(reservationId,null);
        if(reservation==null) throw new NoSuchElementException("Reservation not found for given id ");
        else cancelReservation(reservation);
    }
    private void cancelReservation(Reservation reservation){
        reservation.cancelReservation();
        // update in reservation map
        reservations.put(reservation.getId(),reservation);
    }
    // checkIn()
    public void checkIn(Guest guest){
        // find reservation related to guest
        Reservation reservation=null;
        for (Reservation r: reservations.values()) {
            if(r.getBookedBy()==guest){
                System.out.println("found reservation for guest booked at "+r.getBookedAt());
                reservation=r;
                break;
            }
        }
        if(reservation==null) throw new NoSuchElementException("No reservation booked by guest "+guest.getName()+" is present");
        reservation.getRooms().forEach(Room::checkIn);
    }
    // checkOut()
    public void checkOut(Guest guest){
        // find reservation related to guest
        Reservation reservation=null;
        for (Reservation r: reservations.values()) {
            if(r.getBookedBy()==guest){
                System.out.println("found reservation for guest booked at "+r.getBookedAt());
                reservation=r;
                break;
            }
        }
        if(reservation==null) throw new NoSuchElementException("No reservation booked by guest "+guest.getName()+" is present");
        reservation.getRooms().forEach(Room::checkOut);
    }


     // SINGLETON PATTERN
    public static synchronized HotelManagementService getInstance(){
        if(instance ==null){
            System.out.println("Created new instance of hotel mgmt service ");
            instance =new HotelManagementService();
        }
        return instance;
    }

    private String generateRandomId(String prefix){
        return prefix+"-"+ UUID.randomUUID().toString().substring(0,8);
    }

}
