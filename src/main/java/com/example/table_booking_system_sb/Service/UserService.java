package com.example.table_booking_system_sb.Service;


import com.example.table_booking_system_sb.Model.User;
import org.springframework.stereotype.Service;

public interface UserService {



 User saveUser(User User);


 void removeSuccessMessage();
}