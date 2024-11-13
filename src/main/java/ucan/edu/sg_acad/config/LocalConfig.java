package ucan.edu.userapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.boot.CommandLineRunner;
import ucan.edu.userapi.domain.User;
import ucan.edu.userapi.repositories.UserRepository;

import java.util.List;

@Configuration
@Profile("local")
public class LocalConfig {

    @Autowired
    private UserRepository repository;

    @Bean
    public CommandLineRunner startDB() {
        return args -> {
            User u1 = new User(null, "Amarildo Miguel", "amarildomgl@mail.com", "password");
            User u2 = new User(null, "Célsia de Sousa", "celsiasousa@mail.com", "password");
            User u3 = new User(null, "Joseph Cipriano", "joseph@mail.com", "password");
            User u4 = new User(null, "Frank Miguel", "frankmgl@mail.com", "password");

            repository.saveAll(List.of(u1, u2, u3, u4));
        };
    }
}