package com.monnet.challenge.car;

import com.monnet.challenge.car.caractions.CarService;
import com.monnet.challenge.car.caractions.model.CarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class CarApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(CarApplication.class, args);

		CarService carService = context.getBean(CarService.class);
		carService.getActionDay().execute(new CarDTO());
	}

}
