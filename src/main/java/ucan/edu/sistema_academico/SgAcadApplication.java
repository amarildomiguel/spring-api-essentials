package ucan.edu.sistema_academico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SgAcadApplication {
    public static void main(String[] args) {
        SpringApplication.run(SgAcadApplication.class, args);
    }
}
