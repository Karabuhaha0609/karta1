package ru.kartanerud.buba.karta.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private final UserDetailsService userDetailsService;

    public SecurityConfig(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

@Override
protected void configure(HttpSecurity http) throws Exception {
    http
            .authorizeRequests()
            // Разрешить доступ к странице регистрации
            .antMatchers("/register", "/register/new").permitAll()
            .antMatchers("/roles", "/roles/create", "/roles/*").permitAll()
            // Разрешить доступ к статическим файлам
            .antMatchers("/js/**", "/css/**", "/images/**").permitAll()
            // Запретить доступ к другим страницам, если пользователь не аутентифицирован
            .anyRequest().authenticated()
            .and()
            .formLogin()
            // Указать страницу логина
            .loginPage("/login")
            // Разрешить доступ к странице логина всем пользователям
            .permitAll()
            // Указать обработчик логина
            .defaultSuccessUrl("/profile", true)
            .and()
            .logout()
            // Указать URL для логаута
            .logoutUrl("/logout")
            // Разрешить доступ к странице логаута всем пользователям
            .permitAll()
            // Указать URL, на который нужно перенаправить после логаута
            .logoutSuccessUrl("/")
            // Удалить сессию после логаута
            .invalidateHttpSession(true)
            .and()
            // Отключить CSRF-защиту для тестирования
            .csrf().disable();
}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }


}
