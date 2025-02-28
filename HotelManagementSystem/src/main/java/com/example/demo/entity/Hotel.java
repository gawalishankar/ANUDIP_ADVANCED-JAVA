package com.example.demo.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Version;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name is required")
    @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
    private String name;

    private String hotelType;

    private String quality;

    @Email(message = "Invalid Email format")
    private String hotelEmail;

    @NotBlank(message = "Phone number cannot be empty")
    @Pattern(
        regexp = "^[0-9]{10}$",
        message = "Phone number must be exactly 10 digits"
    )
    private String num;

    @Version
    private int version = 0; // Initialize version to 0

    // Parameterized constructor
    public Hotel(Long id, String name, String hotelType, String quality, String hotelEmail, String num) {
        this.id = id;
        this.name = name;
        this.hotelType = hotelType;
        this.quality = quality;
        this.hotelEmail = hotelEmail;
        this.num = num;
    }

    // Default constructor
    public Hotel() {
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHotelType() {
        return hotelType;
    }

    public void setHotelType(String hotelType) {
        this.hotelType = hotelType;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }

    public String getHotelEmail() {
        return hotelEmail;
    }

    public void setHotelEmail(String hotelEmail) {
        this.hotelEmail = hotelEmail;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Hotel [id=" + id + ", name=" + name + ", hotelType=" + hotelType + ", quality=" + quality
                + ", hotelEmail=" + hotelEmail + ", num=" + num + ", version=" + version + "]";
    }
}
