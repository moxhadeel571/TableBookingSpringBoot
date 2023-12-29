package com.example.table_booking_system_sb.Controller;

import com.example.table_booking_system_sb.Model.Booking;
import com.example.table_booking_system_sb.Model.Restaurant;
import com.example.table_booking_system_sb.Service.BookingService;
import com.example.table_booking_system_sb.Service.RestaurentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.cassandra.CassandraProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RequestMapping(value = "/Customer")
@Controller
public class CustomerController {
    private RestaurentService restaurentService;
    private BookingService bookingService;
@Autowired
    public CustomerController(RestaurentService restaurentService, BookingService bookingService) {
        this.restaurentService = restaurentService;
    this.bookingService = bookingService;
}

    @GetMapping("/home")
public String getCustomer(){

    return "home";
}
@GetMapping("/about")
    public String getAbout(){
    return "about";
}
@GetMapping("/blog")
    public String getBlog(){
    return "blog";
}
@GetMapping("/testimonial")
    public String getTestTimoniel()
{
    return "testimonial";
}
@GetMapping("/Restaurent_IAIDBIawai")
    public String getRestaurent(Model model){
    return "Restaurant";
}
@GetMapping("/View_fFSFAFiof/{id}")
    public String getview(@PathVariable("id") ObjectId id, @ModelAttribute("booking") Booking booking, Model model){
     Restaurant result=restaurentService.findById(id);
    model.addAttribute("view",result);
    return "RestaurentView";
}
    @PostMapping(path = "/SaveBooking_FGedtgeRTe/{id}")
    public String saveBookings(Restaurant restaurant,  @ModelAttribute("booking") Booking bookings,
                               @PathVariable("id") ObjectId id) {
        bookingService.save(bookings, restaurant,id);
        return "Restaurant";
    }

    @GetMapping("/Hyderabad_BIDKAkaa")
    public String getHyderabad(Model model){
    Page Hyderabad=restaurentService.findHyderabad();
    model.addAttribute("hyderabad",Hyderabad);
    return "Hyderabad";
}






   @GetMapping("/Delhi_NCRjsausasa")
    public String getDelhi_NCRjsausasa(Restaurant restaurant,Model model){
    Page Hyderabad=restaurentService.findDelhi();
    ObjectId ids=restaurant.getId();
    Restaurant restaurants=restaurentService.findHyderabadByID(ids);
    model.addAttribute("id",restaurants);
    model.addAttribute("delhi",Hyderabad);
    return "Delhi";
}
    @GetMapping("/ViewDelhi_fFSFAFiof/{id}")
    public String getViewDelhi_fFSFAFiof(
            @PathVariable("id") ObjectId id,
            @ModelAttribute("booking") Booking booking,
            Model model) {

        Restaurant restaurant = restaurentService.findHyderabadByID( id);
        model.addAttribute("id",id);
        model.addAttribute("Delhi", restaurant);
        return "DelhiView";
    }


    @GetMapping("/Bangalore_jsausasa")
    public String Bangalorejsausasa(Restaurant restaurant,Model model){
        Page Bangalore=restaurentService.findBangalore();
        ObjectId ids=restaurant.getId();
        model.addAttribute("Bangalore",Bangalore);
        return "Bangalore";
    }
    @GetMapping("/ViewBangalore_fFSFAFiof/{id}")
    public String getViewBangalore_fFSFAFiof(
            @PathVariable("id") ObjectId id,
            @ModelAttribute("booking") Booking booking,
            Model model) {

        Restaurant restaurant = restaurentService.findHyderabadByID( id);
        model.addAttribute("id",id);
        model.addAttribute("Bangalore", restaurant);
        return "VIewBangalore";
    }

@PostMapping("/Search_RestaurantFAsfa")
public String getSearch(Model model,@RequestParam("name") String name){
    Set<Restaurant> searchSet = new HashSet<>(restaurentService.FindRestaurants(name));
    model.addAttribute("searchList", new ArrayList<>(searchSet));
    return "Result";
}






    @GetMapping("/ViewHyderabad_fFSFAFiof/{id}")
    public String getViewHyderabad_fFSFAFiof(
            @PathVariable("id") ObjectId id,
            @ModelAttribute("booking") Booking booking,
            Model model) {

        Restaurant restaurant = restaurentService.findHyderabadByID( id);
model.addAttribute("id",id);
            model.addAttribute("Hyderabad", restaurant);
    return "HyderabadView";
    }


    @GetMapping("/Mumbai_jsausasa")
    public String Mumbaijsausasa(Restaurant restaurant,Model model){
        Page Mumbai=restaurentService.findMumbai();
        ObjectId ids=restaurant.getId();
        model.addAttribute("Mumbai",Mumbai);
        return "Mumbai";
    }
    @GetMapping("/ViewMumbai_fFSFAFiof/{id}")
    public String getViewMumbai_fFSFAFiof(
            @PathVariable("id") ObjectId id,
            @ModelAttribute("booking") Booking booking,
            Model model) {

        Restaurant Mumbai = restaurentService.findHyderabadByID( id);
        model.addAttribute("id",id);
        model.addAttribute("Mumbai", Mumbai);
        return "MumbaiView";
    }

}
