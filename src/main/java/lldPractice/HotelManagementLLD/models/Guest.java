package lldPractice.HotelManagementLLD.models;

import lldPractice.HotelManagementLLD.enums.Gender;

public class Guest extends Person {

    public Guest(String id, String name, Gender gender, String emailId, int age, Address address, String contactNumber) {
        super(id, name, gender, emailId, age, address, contactNumber);
    }
}
