package org.marouane.supplychainx2;

import org.marouane.supplychainx2.User.entity.enume.Role;
import org.marouane.supplychainx2.User.service.Impl.AccountServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SupplyChainX2Application {

    public static void main(String[] args) {
        SpringApplication.run(SupplyChainX2Application.class, args);
    }

    @Bean
    CommandLineRunner start(AccountServiceImpl accountService) {
        return args -> {
            accountService.addNewUser("marouane", "bichara", "marouanebichara08@gmail.com" , "12345678" , Role.ADMIN);
        };
    }

}
