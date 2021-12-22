//package ru.kartanerud.buba.karta.models;
//
//import lombok.Data;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import ru.kartanerud.buba.karta.models.enamy.Role;
//
//import java.util.Collections;
//
//@Data
//public class RegistrationForm {
//
//    private String username;
//    private String password;
//    private String email;
//    private String phoneNumber;
//
//    public User toUser(PasswordEncoder passwordEncoder){
//        User user = new User();
//        user.setEmail(email);
//        user.setPassword(passwordEncoder.encode(password));
//        user.setPhoneNumber(phoneNumber);
//        user.setRoles(Collections.singleton(Role.USER));
//        user.setUsername(username);
//        return user;
//    }
//
//}
