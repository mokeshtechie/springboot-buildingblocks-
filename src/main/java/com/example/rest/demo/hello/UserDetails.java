package com.example.rest.demo.hello;




public class UserDetails {

  

    public String firstName;
    public String lastName;
    public String city;

    // ✅ Default constructor (REQUIRED)
    public UserDetails() {
    }

    // ✅ Parameterized constructor
    public UserDetails(String firstName, String lastName, String city) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
    }

    // Getters and Setters
}