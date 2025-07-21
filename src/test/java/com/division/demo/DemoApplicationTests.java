package com.division.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	@Autowired
	private NumberPrinter numberPrinter;

    @Test
	void printNumbersToConsole() {
		System.out.println(numberPrinter.printNumbers(1, 100));
	}

	@Test
	void everyOtherNumberIsOdd() {
		// given
		int from = 1;
		int to = 100;

		// when
		StringBuilder numberStrings = numberPrinter.printNumbers(from, to);

		// then
		String[] stringArray = splitStrings(numberStrings);
		for (int i = from; i <= to; i+=2) {
			assertThat(stringArray[i-1]).isEqualTo(String.valueOf(i));
		}
	}

	@Test
	void everyFourthNumberIsFoo() {
		// given
		int from = 1;
		int to = 100;

		// when
		StringBuilder numberStrings = numberPrinter.printNumbers(from, to);

		// then
		String[] stringArray = splitStrings(numberStrings);
		for (int i = from; i <= to; i+=4) {
			assertThat(stringArray[i]).isEqualTo(Words.foo.toString());
		}
	}

	@Test
	void everyFourthNumberIsFooFuu() {
		// given
		int from = 1;
		int to = 100;

		// when
		StringBuilder numberStrings = numberPrinter.printNumbers(from, to);

		// then
		String[] stringArray = splitStrings(numberStrings);
		for (int i = from; i <= to; i+=4) {
			assertThat(stringArray[i+2]).isEqualTo(Words.foofuu.toString());
		}
	}

	@Test
	void worksForNegativeNumbers() {
		// given
		int from = -10;
		int to = 10;

		// when
		StringBuilder numberStrings = numberPrinter.printNumbers(from, to);

		// then
		String[] stringArray = splitStrings(numberStrings);
		System.out.println(numberStrings);
		for (int i = from; i < to; i+=2) {
			assertThat(stringArray[i+11]).isEqualTo(String.valueOf(i+1));
		}
	}

	private String[] splitStrings(StringBuilder numberStrings) {
		return numberStrings.toString().split("\n");
	}
}
