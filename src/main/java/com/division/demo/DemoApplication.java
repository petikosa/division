package com.division.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		printNumbers();
		SpringApplication.run(DemoApplication.class, args);
	}

	public static void printNumbers() {
		for (int i = 1; i <= 100; i++) {
			if (i % 4 == 0) {
				System.out.println("foofuu");
			} else if (i % 2 == 0) {
				System.out.println("foo");
			}
			if (i % 2 != 0) {
				System.out.println(i);
			}
		}
	}

}
