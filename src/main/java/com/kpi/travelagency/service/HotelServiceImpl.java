package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Hotel;
import com.kpi.travelagency.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    private boolean existsById(Long id){
        return hotelRepository.existsById(id);
    }

    @Override
    public Hotel findById(Long id) {
        Hotel hotel = hotelRepository.findById(id).orElse(null);
        return hotel;
    }

    @Override
    public Hotel saveHotel(Hotel hotel) throws Exception {
        if(hotel.getId()!=null && existsById(hotel.getId())) {
            throw new Exception("Hotel with id: " + hotel.getId() + " already exists");
        }
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        List<Hotel> hotels = new ArrayList<>(hotelRepository.findAll());
        return hotels;
    }

    @Override
    public void updateHotel(Hotel hotel) throws Exception {
        if (!existsById(hotel.getId())) {
            throw new Exception("Cannot find hotel with id: " + hotel.getId());
        }
        hotelRepository.save(hotel);

    }

    @Override
    public void deleteHotelById(Long id) throws Exception {
        if (!existsById(id)) {
            throw new Exception("Cannot find hotel with id: " + id);
        }
        else {
            hotelRepository.deleteById(id);
        }
    }


}
