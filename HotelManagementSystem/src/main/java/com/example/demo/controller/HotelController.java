package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Hotel;
import com.example.demo.service.*;



@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    // Get all hotels
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels() {
        List<Hotel> hotels = hotelService.getAllHotels();
        return ResponseEntity.ok(hotels);
    }

    // Get hotel by ID
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable Long id) {
        Hotel hotel = hotelService.getById(id);
        if (hotel != null) {
            return ResponseEntity.ok(hotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Create a new hotel
    @PostMapping("/add")
    public ResponseEntity<Hotel> createHotel(@Validated @RequestBody Hotel hotel) {
        Hotel savedHotel = hotelService.saveHotel(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedHotel);
    }

    // Update an existing hotel
    @PutMapping("/{id}")
    public ResponseEntity<Hotel> updateHotel(@PathVariable Long id, @Validated @RequestBody Hotel updatedHotel, BindingResult result) {
       

    	Hotel existingHotel = hotelService.getById(id);
        if (existingHotel != null) {
            existingHotel.setName(updatedHotel.getName());
            existingHotel.setHotelType(updatedHotel.getHotelType());
            existingHotel.setQuality(updatedHotel.getQuality());
            existingHotel.setHotelEmail(updatedHotel.getHotelEmail());
            
            Hotel savedHotel = hotelService.saveHotel(existingHotel);
            return ResponseEntity.ok(savedHotel);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a hotel by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHotel(@PathVariable Long id) {
        boolean isDeleted = hotelService.deleteHotel(id);
        if (isDeleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}