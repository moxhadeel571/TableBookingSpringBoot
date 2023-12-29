package com.example.table_booking_system_sb.Repository;


import com.example.table_booking_system_sb.Model.Booking;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileInfoRepository extends MongoRepository<Booking, ObjectId> {
}
