package lldPractice.HotelManagementLLD;

import lldPractice.HotelManagementLLD.enums.Gender;
import lldPractice.HotelManagementLLD.enums.RoomType;
import lldPractice.HotelManagementLLD.models.Guest;
import lldPractice.HotelManagementLLD.models.Reservation;
import lldPractice.HotelManagementLLD.models.Room;
import lldPractice.HotelManagementLLD.service.HotelManagementService;

import java.time.LocalDate;
import java.util.List;

public class HotelMgmtDemo {
    public static void main(String[] args) {
        HotelManagementService hotelManagementService=HotelManagementService.getInstance();
        // add guests
        Guest pankaj = hotelManagementService.addGuest("PANKAJ SHUKLA", Gender.MALE,24);
        Guest anita = hotelManagementService.addGuest("ANITA VERMA", Gender.FEMALE, 30);
        Guest rahul = hotelManagementService.addGuest("RAHUL MEHRA", Gender.MALE, 28);
        Guest priya = hotelManagementService.addGuest("PRIYA KAPOOR", Gender.FEMALE, 25);
        Guest arjun = hotelManagementService.addGuest("ARJUN SINGH", Gender.MALE, 35);

        // add Rooms
        Room a100 = hotelManagementService.addRoom(RoomType.SINGLE_BED, "A100", 20, 1000);
        Room a101 = hotelManagementService.addRoom(RoomType.SINGLE_BED, "A101", 18, 950);
        Room b200 = hotelManagementService.addRoom(RoomType.DOUBLE_BED, "B200", 25, 1500);
        Room c300 = hotelManagementService.addRoom(RoomType.QUEEN_SIZE, "C300", 30, 2500);
        Room d400 = hotelManagementService.addRoom(RoomType.KING_SIZE, "D400", 35, 4000);
        // book rooms
        Reservation reservation=hotelManagementService.createReservation(List.of(
                pankaj,anita,rahul),List.of(a100,a101),pankaj, LocalDate.now(),LocalDate.now().plusDays(10)
        );
        // check in
        hotelManagementService.checkIn(pankaj);
        // cancel reservation
//        hotelManagementService.cancelReservation(reservation.getId());
        hotelManagementService.checkOut(pankaj);
    }
}
