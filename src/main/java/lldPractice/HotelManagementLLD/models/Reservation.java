package lldPractice.HotelManagementLLD.models;

import lldPractice.HotelManagementLLD.enums.ReservationStatus;
import lldPractice.HotelManagementLLD.enums.RoomStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Reservation {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    String id;
    public Reservation(String id ,List<Room> rooms, List<Guest> guestsStaying, Guest bookedBy, LocalDate bookedAt, LocalDate from, LocalDate to) {
        this.id=id;
        this.rooms = rooms;
        this.guestsStaying = guestsStaying;
        this.bookedBy = bookedBy;
        this.bookedAt = bookedAt;
        this.from = from;
        this.to = to;
    }

    List<Room> rooms;
    List<Guest> guestsStaying;
    Guest bookedBy;
    LocalDate bookedAt;
    LocalDate from;
    LocalDate to;
    ReservationStatus status;

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Guest> getGuestsStaying() {
        return guestsStaying;
    }

    public void setGuestsStaying(List<Guest> guestsStaying) {
        this.guestsStaying = guestsStaying;
    }

    public Guest getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(Guest bookedBy) {
        this.bookedBy = bookedBy;
    }

    public LocalDate getBookedAt() {
        return bookedAt;
    }

    public void setBookedAt(LocalDate bookedAt) {
        this.bookedAt = bookedAt;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    public synchronized void cancelReservation(){
        if(status==ReservationStatus.CONFIRMED) {
            // change the room status
            rooms.forEach(Room::checkOut);
            setStatus(ReservationStatus.CANCELLED);
        }
        else throw new IllegalStateException("Reservation already cancelled ");
    }




}
