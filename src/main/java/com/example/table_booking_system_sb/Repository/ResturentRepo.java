package com.example.table_booking_system_sb.Repository;

import com.example.table_booking_system_sb.Model.Restaurant;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Repository
public interface ResturentRepo extends MongoRepository<Restaurant, ObjectId> {
    @Query("{'city':'Hyderabad'}")
    Page<Restaurant> findHyderabad(Pageable pageable);
    @Query("{'city':'New Delhi'}")
    Page<Restaurant> findDelhi(Pageable pageable);
    @Query("{'city':'Bangalore'}")
    Page<Restaurant> findBangalore(Pageable pageable);
    @Query("{ '_id' : ?0 }")
    Optional<Restaurant> findRestaurantByCityAndId(ObjectId id);
    @Query("{city:'Mumbai'}")
    Page<Restaurant> findMumbai(Pageable pageable);
    @Query("{ 'name' : ?0 }")
    List<Restaurant> findBYName(String name);
}
