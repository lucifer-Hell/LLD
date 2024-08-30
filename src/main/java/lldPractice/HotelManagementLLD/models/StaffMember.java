package lldPractice.HotelManagementLLD.models;

import lldPractice.HotelManagementLLD.enums.Gender;

public class StaffMember extends Person{
    public StaffMember(String id, String name, Gender gender, String emailId, int age, Address address, String contactNumber) {
        super(id, name, gender, emailId, age, address, contactNumber);
    }
}
