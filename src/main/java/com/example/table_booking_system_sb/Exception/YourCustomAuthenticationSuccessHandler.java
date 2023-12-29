package com.example.table_booking_system_sb.Exception;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Set;
@Service
public class YourCustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(jakarta.servlet.http.HttpServletRequest request, jakarta.servlet.http.HttpServletResponse response, Authentication authentication) throws IOException, jakarta.servlet.ServletException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        if (roles.contains("ROLE_ADMIN")) {
            response.sendRedirect("/Restaurant_/admin"); // Redirect recruiter to recruiter profile page
        } else if (roles.contains("ROLE_USERS")) {
            response.sendRedirect("/Customer/Restaurent_IAIDBIawai"); // Redirect candidate to job listing page
        } else {
            // If the user doesn't have any of the specified roles, redirect to a default page.
            response.sendRedirect("/error");
        }

    }

}

