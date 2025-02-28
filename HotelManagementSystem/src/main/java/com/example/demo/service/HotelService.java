package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.*;
import com.example.demo.repository.HotelRepository;



@Service
public class HotelService {

	@Autowired
	private HotelRepository hotelRepo;

	// Getting all Hotels data
	public List<Hotel> getAllHotels() {
		return hotelRepo.findAll();
	}

	public Hotel getById(Long id) {
		return hotelRepo.findById(id).orElse(null);
	}

	// Saving a Hotel
	public Hotel saveHotel(Hotel hotel) {
		return hotelRepo.save(hotel);
	}

//	 // Update a Hotel
//	 public Hotel updateHotel(Long id, Hotel hotel) {
//	 if(hotelRepo.existsById(id)) {
//	
//	 }
//	 }

	// Delete a Hotel
	public boolean deleteHotel(Long id) {

		if (hotelRepo.existsById(id)) {
			hotelRepo.deleteById(id);
			return true;
		}
		else {
			return false;
		}

}
}