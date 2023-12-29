package com.example.table_booking_system_sb.Componenet;

import com.example.table_booking_system_sb.Model.Restaurant;
import com.example.table_booking_system_sb.Repository.ResturentRepo;
import com.example.table_booking_system_sb.Service.RestaurentService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.NoSuchElementException;

@Component
public class RestaurentComponenet implements RestaurentService {
    private ResturentRepo resturentRepo;
@Autowired
    public RestaurentComponenet(ResturentRepo resturentRepo) {
        this.resturentRepo = resturentRepo;
    }

    @Override
    public Page<Restaurant> findHyderabad() {
        return resturentRepo.findHyderabad(Pageable.ofSize(20));
    }



    @Override
    public Restaurant findById(ObjectId id) {
        return resturentRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Restaurant not found with id: " + id));
    }

    @Override
    public void saveRestaurent(Restaurant restaurant) {
    Restaurant restaurant1=new Restaurant();
    restaurant1.setId(restaurant.getId());
    restaurant1.setName(restaurant.getName());
    restaurant1.setAddress(restaurant.getAddress());
        resturentRepo.save(restaurant);
    }



    @Override
    public Restaurant findHyderabadByID(ObjectId id) {
    Restaurant res=resturentRepo.findRestaurantByCityAndId(id).orElse(null);
        System.out.println("here is the info :       "+res);

        return  res;
       }

    @Override
    public List<Restaurant> FindRestaurants(String name) {
        return resturentRepo.findBYName(name);
    }



    @Override
    public Page findDelhi() {
        return resturentRepo.findDelhi(Pageable.ofSize(20));
    }

    @Override
    public Page findBangalore() {
        return resturentRepo.findBangalore(Pageable.ofSize(20));    }

    @Override
    public Page findMumbai() {
        return resturentRepo.findMumbai(Pageable.ofSize(20)); }
    }



