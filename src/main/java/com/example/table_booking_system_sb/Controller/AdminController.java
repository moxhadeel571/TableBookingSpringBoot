package com.example.table_booking_system_sb.Controller;

import com.example.table_booking_system_sb.Model.Booking;
import com.example.table_booking_system_sb.Model.Email;
import com.example.table_booking_system_sb.Model.Restaurant;
import com.example.table_booking_system_sb.Service.BookingService;
import com.example.table_booking_system_sb.Service.EmailService;
import com.example.table_booking_system_sb.Service.RestaurentService;
import jakarta.mail.MessagingException;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RequestMapping("/Restaurant_")
@Controller

public class AdminController {
    private RestaurentService restaurentService;
    private BookingService bookingService;
    private EmailService emailService;
@Autowired
    public AdminController(RestaurentService restaurentService, BookingService bookingService, EmailService emailService) {
        this.restaurentService = restaurentService;
        this.bookingService = bookingService;
    this.emailService = emailService;
}

    @GetMapping("/admin")
    public String getAdmin(Model model) {
        List<Booking> booking =bookingService.findAll();
        model.addAttribute("bookings", booking);
        return "admin";
    }
    @PostMapping("/SaveRestaurent")
    public String saveRestaurent(Restaurant restaurant) {
    restaurentService.saveRestaurent(restaurant);
    return "redirect:/Restaurant_/admin";
    }

    @PostMapping(value ="/Approve_dwajvAWV/{id}")
    public String getAppro(@PathVariable("id") ObjectId id,  Email email, Booking booking) throws MessagingException {
    emailService.approve(email, id);

        bookingService.approveStatus(booking,id);
        return "redirect:/Restaurant_/admin";


}
@PostMapping(value ="/Disapprove_dwajvAWV/{id}")
    public String getDisappro(Email email,@PathVariable("id") ObjectId id, Booking booking) throws MessagingException {
        bookingService.DisapproveStatus(booking,id);
    emailService.disapprove(email, id);

        return "redirect:/Restaurant_/admin";

    }


}
