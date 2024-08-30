package lldPractice.HotelManagementLLD.models;

import lldPractice.HotelManagementLLD.enums.Gender;

public class Person {
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    String id;

    String name;
    Gender gender;
    String emailId;
    int age;
    Address address;
    String contactNumber ;

    public Person(String id, String name, Gender gender, String emailId, int age, Address address, String contactNumber) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.emailId = emailId;
        this.age = age;
        this.address = address;
        this.contactNumber = contactNumber;
    }
}
