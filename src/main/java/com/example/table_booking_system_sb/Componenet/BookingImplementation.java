package com.example.table_booking_system_sb.Componenet;

import com.example.table_booking_system_sb.Model.Booking;
import com.example.table_booking_system_sb.Model.Restaurant;
import com.example.table_booking_system_sb.Repository.BookingRepo;
import com.example.table_booking_system_sb.Repository.ResturentRepo;
import com.example.table_booking_system_sb.Service.BookingService;
import com.example.table_booking_system_sb.Service.EmailService;
import com.example.table_booking_system_sb.Service.RestaurentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookingImplementation implements BookingService {
    private BookingRepo bookingService;
    private RestaurentService restaurentService;
    private ResturentRepo resturentRepo;
    private EmailService emailService;
@Autowired
    public BookingImplementation(BookingRepo bookingService, RestaurentService restaurentService, ResturentRepo resturentRepo, EmailService emailService) {
        this.bookingService = bookingService;
    this.restaurentService = restaurentService;
    this.resturentRepo = resturentRepo;
    this.emailService = emailService;
}

    @Override
    public void save(Booking booking, Restaurant restaurant, ObjectId id) {
        if (id != null) {
            // Make sure the Restaurant exists before proceeding
            Restaurant existingRestaurant = restaurentService.findHyderabadByID(id);

            // Check if the Restaurant exists
            if (existingRestaurant != null) {
                // Create a new Booking object and set its properties
                Booking newBooking = new Booking();
                newBooking.setNumberPersons(booking.getNumberPersons());
                newBooking.setId(booking.getId());
                newBooking.setBookingDate(booking.getBookingDate());
                newBooking.setBookingTime(booking.getBookingTime());
                newBooking.setName(booking.getName());
                newBooking.setEmailAddress(booking.getEmailAddress());
                newBooking.setRestaurant(existingRestaurant);

                // Initialize the bookings list if null
                if (existingRestaurant.getBookings() == null) {
                    existingRestaurant.setBookings(new ArrayList<>());
                }

                // Save the new Booking entity
                bookingService.save(newBooking);

                // Before save
                System.out.println("Saving booking: " + newBooking);

                // After save
                System.out.println("Booking saved successfully!");

                // Add the new booking to the bookings list in Restaurant entity
                existingRestaurant.getBookings().add(newBooking);

                // Save the updated Restaurant entity with the new booking
                restaurentService.saveRestaurent(existingRestaurant);
            } else {
                System.out.println("Restaurant not found for id: " + id);
            }
        } else {
            System.out.println("Invalid id provided");
        }
    }



    @Override
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @Override
    public void approveStatus(Booking booking, ObjectId id) {
        if (id != null) {
            Booking appoint = bookingService.findById(id).orElse(null);

            if (appoint != null) {
                // Log the current status before update
                System.out.println("Current supervisor_approval status: " + appoint.getSupervisor_approval());

                // Update supervisor_approval status
                appoint.setSupervisor_approval("Approved");
                // Save the updated entity
                bookingService.save(appoint);

                // Log the updated status
                System.out.println("Updated supervisor_approval status: " + appoint.getSupervisor_approval());
            } else {
                System.out.println("Restaurant not found for id: " + id);
            }
        } else {
            System.out.println("Invalid id provided");
        }
    }
    @Override
    public void DisapproveStatus(Booking booking, ObjectId id) {
        if (id != null) {
            Booking appoint = bookingService.findById(id).orElse(null);

            if (appoint != null) {
                // Log the current status before update
                System.out.println("Current supervisor_approval status: " + appoint.getSupervisor_approval());

                // Update supervisor_approval status
                appoint.setSupervisor_approval("Disapprove");

                // Save the updated entity
                bookingService.save(appoint);

                // Log the updated status
                System.out.println("Updated supervisor_approval status: " + appoint.getSupervisor_approval());
            } else {
                System.out.println("Restaurant not found for id: " + id);
            }
        } else {
            System.out.println("Invalid id provided");
        }
    }

}
