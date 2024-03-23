package com.kobanina.cardatabase;

import com.kobanina.cardatabase.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(CardatabaseApplication.class);

	@Autowired
	private CarRepository repository;

	@Autowired
	private OwnerRepository orepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Owner owner1 = new Owner("Ivan","Ivanov");
		Owner owner2 = new Owner("Nikolai","Kolaivech");
		orepository.saveAll(Arrays.asList(owner1, owner2));

		Car car1 = repository.save(new Car("Lada", "Granta", "Shit", "ab123bb", 2022, 30000000, owner1));
		Car car2 = repository.save(new Car("UAZ", "Dodik", "Poopie", "ab456bb", 2022, 40000000, owner2));
		Car car3 = repository.save(new Car("GAZ", "Tormoz", "Black", "db234fg", 2022, 50000000, owner2));
		repository.saveAll(Arrays.asList(car1,car2,car3));
		for (Car car : repository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
		userRepository.save(new User("admin","$2y$10$vUxswtnL.kzxJ6ZUbudUvu0sddsymGWdz2fv5lqguhviOkJF2g5gS","ADMIN"));
		userRepository.save(new User("user","$2y$10$D6F23jlFpe2g2T06mnOSM.qQFCDhuvqKTcaWYqTMzKkDs17DVOQfG","USER"));
	}

}
