package com.example.table_booking_system_sb.Componenet;


import com.example.table_booking_system_sb.Model.Booking;
import com.example.table_booking_system_sb.Model.Email;
import com.example.table_booking_system_sb.Repository.BookingRepo;
import com.example.table_booking_system_sb.Repository.ResturentRepo;
import com.example.table_booking_system_sb.Service.EmailService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import java.util.Optional;


@Service
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender javaMailSender;
@Autowired
private BookingRepo restaurentRepository;
@Autowired
private ResturentRepo restaurantService;

        @Autowired
        public EmailServiceImpl(JavaMailSender javaMailSender) {
            this.javaMailSender = javaMailSender;
        }


    @Override
    public void approve(Email email, ObjectId id) throws  MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            // Obtain the necessary data for email and ID
            Optional<Booking> booking = restaurentRepository.findById(id);
            String toEmail = booking.get().getEmailAddress();  // Make sure your Email object contains a valid 'to' address

            String getSubject = "Table Booking Status ";
            String htmlContent = "<html><body>" +
                    "<h2>" + getSubject + "</h2>" +
                    "<p>Booking Details:</p>" +
                    "<ul>" +
                    "<li >Number of Persons: " + booking.get().getNumberPersons() + "</li>" +
                    "<li>Booking Date: " + booking.get().getBookingDate() + "</li>" +
                    "<li>Booking Time: " + booking.get().getBookingTime() + "</li>" +
                    "<li>Restaurant: " + booking.get().getRestaurant().getName() + "</li>" +
                    "</ul>" +
                    "<p>Additional Information:</p>" +
                    "<ul>" +
                    "<li>Name: " + booking.get().getName() + "</li>" +
                    "<li>Email Address: " + booking.get().getEmailAddress() + "</li>" +
                    "<li>Approval Status: " + booking.get().getSupervisor_approval() + "</li>" +
                    "</ul>" +
                    "<p>We are excited to have you at " + booking.get().getRestaurant().getName() + "!</p>" +
                    "<p>Special Instructions:</p>" +
                    "<p>" + booking.get().getRestaurant().getHighlights() + "</p>" +
                    "<p>Enjoy a delightful dining experience with us. Our team is ready to make your visit memorable!</p>" +
                    "<p>If you have any dietary preferences or special requests, please let us know in advance.</p>" +
                    "<p>We look forward to serving you!</p>" +
                    "<p>Thank you for choosing us!</p>" +
                    "</body></html>";

            String displayName = "Anonymous"; // Set the desired display name
            String fromEmail = "noreply@example.com"; // Set your actual email address

            helper.setFrom(new InternetAddress(fromEmail, displayName));
            helper.setTo(toEmail);
            helper.setSubject(getSubject);
            helper.setText(htmlContent, true);

            javaMailSender.send(mimeMessage);
        } catch (Exception e) {
            // Handle other exceptions
            // For example, you may log the error or display a custom error message
            e.printStackTrace();
        }
    }

    @Override
    public void disapprove(Email email, ObjectId id) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

        try {
            Optional<Booking> booking = restaurentRepository.findById(id);

            // Check if the booking exists
            if (booking.isPresent()) {
                String toEmail = email.getTo();
                var name = booking.get().getName();
                Integer numberPersons = booking.get().getNumberPersons();
                String subject = "Booking Disapproval";

                String htmlContent = "<html><body>" +
                        "<h2>" + subject + "</h2>" +
                        "<p>Booking Details:</p>" +
                        "<ul>" +
                        "<li>Number of Persons: " + numberPersons + "</li>" +
                        "<li>Booking Date: " + booking.get().getBookingDate() + "</li>" +
                        "<li>Booking Time: " + booking.get().getBookingTime() + "</li>" +
                        "<li>Restaurant: " + booking.get().getRestaurant().getName() + "</li>" +
                        "</ul>" +
                        "<p>Additional Information:</p>" +
                        "<ul>" +
                        "<li>Name: " + name + "</li>" +
                        "<li>Email Address: " + booking.get().getEmailAddress() + "</li>" +
                        "<li>Approval Status: " + booking.get().getSupervisor_approval() + "</li>" +
                        "</ul>" +
                        "<p>We're sorry to inform you that your booking has been disapproved.</p>" +
                        "<p>If you have any concerns or questions, please contact us.</p>" +
                        "<p>Thank you for your understanding.</p>" +
                        "</body></html>";

                String displayName = "Anonymous";
                String fromEmail = "noreply@example.com";

                helper.setFrom(new InternetAddress(fromEmail, displayName));
                helper.setTo(booking.get().getEmailAddress());
                helper.setSubject(subject);
                helper.setText(htmlContent, true);

                javaMailSender.send(mimeMessage);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}




