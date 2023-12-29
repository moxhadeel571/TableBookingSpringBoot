package com.example.table_booking_system_sb.Service;

import com.example.table_booking_system_sb.Model.Booking;
import com.example.table_booking_system_sb.Model.Restaurant;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface RestaurentService {

    Restaurant findById(ObjectId id);

    void saveRestaurent(Restaurant restaurant);

    Page findHyderabad();

    Restaurant findHyderabadByID(ObjectId id);


    List<Restaurant> FindRestaurants(String name);

    Page findDelhi();

    Page findBangalore();

    Page findMumbai();
}
