package ru.kartanerud.buba.karta.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.kartanerud.buba.karta.exception.InvalidUserException;
import ru.kartanerud.buba.karta.models.Company;
import ru.kartanerud.buba.karta.models.Role;
import ru.kartanerud.buba.karta.models.User;
import ru.kartanerud.buba.karta.repo.UserRepository;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.security.Principal;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;
    private final NotificationService notificationService;
    private final CompanyService companyService;



    public void save(User user) {
        log.info("Сохранение пользователя: {}", user);
        if (!user.getPassword().equals(user.getMatchingPassword())) {
            throw new InvalidUserException("Пароль не совпадает");
        }

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setMatchingPassword(null); // удаляем временное поле

        User savedUser = userRepository.save(user);
        if (savedUser == null) {
            throw new RuntimeException("Не удалось сохранить пользователя");
        }

        // Перенаправляем пользователя на буферную страницу
        // TODO: Реализовать перенаправление на буферную страницу
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


    @Transactional
    public void updateUser(User user, MultipartFile photo, Principal principal) throws IOException {
        log.info("Обновление пользователя: {}", user);

        User existingUser = userRepository.findById(user.getId())
                .orElseThrow(() -> new InvalidUserException("Пользователь не найден"));

        if (!user.getEmail().equals(existingUser.getEmail())) {
            // проверяем, что новый email не занят другим пользователем
            if (userRepository.findByEmail(user.getEmail()) != null) {
                throw new InvalidUserException("Email уже зарегистрирован");
            }
        }
        // перебираем поля объекта User и устанавливаем только измененные поля
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Object newValue = field.get(user);
                Object oldValue = field.get(existingUser);
                if (newValue != null && !newValue.equals(oldValue)) {
                    field.set(existingUser, newValue);
                }
            } catch (IllegalAccessException e) {
                // обрабатываем исключение
            }
        }

        // Сохраняем фото в файловую систему
        if (photo != null && !photo.isEmpty()) {
            String fileName = photo.getOriginalFilename();
            File photoFile = new File("src/main/resources/static/img/" + fileName);

            // Если в базе уже есть фото, принадлежащее этому пользователю, то его заменить на новое с тем же именем
            if (existingUser.getPhoto() != null) {
                File existingPhotoFile = new File("src/main/resources/static/img/" + existingUser.getPhoto());
                if (existingPhotoFile.exists()) {
                    existingPhotoFile.delete();
                }
            }

            try (OutputStream os = new FileOutputStream(photoFile)) {
                os.write(photo.getBytes());
            }

            existingUser.setPhoto(fileName);
        }

        User savedUser = userRepository.save(existingUser);
        if (savedUser == null) {
            throw new RuntimeException("Не удалось обновить пользователя");
        }
        else {
            // если фото не загружено, то не меняем поле "photo"
            existingUser.setPhoto(existingUser.getPhoto());

        // Отправляем уведомление пользователю
        notificationService.notifyUser(savedUser, "Ваши данные были обновлены");
    }
    }


        @Transactional
        public void updateUserWithCompanyAndRole(User user, Company company, Role role) {
            // Обновление пользователя
            user.setCompany(company);
            user.setRole(role);
            userRepository.save(user);
        }


    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return new User();
        return userRepository.findByEmail(principal.getName());
    }
}
