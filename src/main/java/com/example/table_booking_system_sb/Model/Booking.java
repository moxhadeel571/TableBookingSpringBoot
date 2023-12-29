package com.example.table_booking_system_sb.Model;

import com.mongodb.internal.connection.Time;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;  // Change the import to use java.util.Date
import java.util.*;  // Change the import to use java.util.Date
import java.time.LocalTime;  // Import the LocalTime class


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "booking")
public class Booking {
    @MongoId
    private ObjectId id;
    private Integer NumberPersons;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate BookingDate;
    private String BookingTime;
    private String Name;
    private String EmailAddress;
    @DBRef
    private Restaurant restaurant;
    private String Supervisor_approval;

}
