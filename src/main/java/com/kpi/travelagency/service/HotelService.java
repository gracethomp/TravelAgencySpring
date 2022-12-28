package com.kpi.travelagency.service;

import com.kpi.travelagency.entity.Hotel;
import java.util.List;

public interface HotelService {
    Hotel findById(Long id);
    Hotel saveHotel(Hotel hotel) throws Exception;
    List<Hotel> findAll();
    void updateHotel(Hotel hotel) throws Exception;
    void deleteHotelById(Long id) throws Exception;

}
