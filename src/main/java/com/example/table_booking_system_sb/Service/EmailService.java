package com.example.table_booking_system_sb.Service;


import com.example.table_booking_system_sb.Model.Email;
import jakarta.mail.MessagingException;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;



@Service
public interface EmailService {




    void approve(Email email, ObjectId id) throws MessagingException, MessagingException;

    void disapprove(Email email, ObjectId id) throws MessagingException;
}
