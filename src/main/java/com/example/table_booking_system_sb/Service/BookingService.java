package com.example.table_booking_system_sb.Service;

import com.example.table_booking_system_sb.Model.Booking;
import com.example.table_booking_system_sb.Model.Restaurant;
import org.bson.types.ObjectId;

import java.util.List;

public interface BookingService {

    void save(Booking booking, Restaurant restaurant, ObjectId id);

    List<Booking> findAll();

    void approveStatus(Booking booking, ObjectId id);

    void DisapproveStatus(Booking booking, ObjectId id);
}
