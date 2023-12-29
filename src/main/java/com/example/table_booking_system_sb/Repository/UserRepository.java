package com.example.table_booking_system_sb.Repository;

import com.example.table_booking_system_sb.Model.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends MongoRepository<User, ObjectId> {

//    @Query(value = "SELECT u FROM users u WHERE u.email = ?")
    User findFirstByEmail(@Param("email") String email);

}