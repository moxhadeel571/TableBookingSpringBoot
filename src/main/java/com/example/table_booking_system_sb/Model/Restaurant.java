package com.example.table_booking_system_sb.Model;

import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document(collection = "Restaurant")
public class Restaurant {
    @MongoId
    private ObjectId id;
    private Long res_id;
   private String name;
    private String    establishment;
    private String url;
    private String address;
    private String city;
private Integer city_id;
    private String locality;
    private Double latitude;
    private Double longitude;
    private String zipcode;
    private Integer     country_id;
    private String locality_verbose;
    private String cuisines;
    private String timings;
    @DBRef
    private List<Booking> bookings;
    private Integer average_cost_for_two;
    private Integer price_range;
    private String currency;
    private String highlights;
    private Double aggregate_rating;
    private String rating_text;
    private Integer votes;
    private Integer    photo_count;
    private Integer            opentable_support;
    private Integer delivery;
    private Integer takeaway;

}
