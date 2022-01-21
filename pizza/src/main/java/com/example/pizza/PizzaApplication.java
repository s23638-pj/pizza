package com.example.pizza;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PizzaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
		Pizza Capriciossa = new Pizza("Capriciosa", 30, "szynka", "pieczarki",
				"ser", true, false, 15, 2);
		Capriciossa.toString();
	}

}
