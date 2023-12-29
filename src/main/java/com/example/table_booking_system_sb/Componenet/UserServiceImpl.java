package com.example.table_booking_system_sb.Componenet;


import com.example.table_booking_system_sb.Model.User;
import com.example.table_booking_system_sb.Repository.UserRepository;
import com.example.table_booking_system_sb.Service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    private  BCryptPasswordEncoder bcryptPasswordEncoder;
    @Autowired
    public UserServiceImpl(BCryptPasswordEncoder bcryptPasswordEncoder) {
        this.bcryptPasswordEncoder = bcryptPasswordEncoder;
    }


    @Override
    public User saveUser(User user) {
        String password = bcryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(password);
        User newUser = userRepository.save(user);
        return newUser;
    }



    @Override
    public void removeSuccessMessage() {
        ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        if (attr != null) {
            HttpSession session = attr.getRequest().getSession();
            if (session != null) {
                session.removeAttribute("msg");
            }
        }
    }





}
