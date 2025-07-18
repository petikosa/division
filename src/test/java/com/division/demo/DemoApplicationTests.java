package com.division.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class DemoApplicationTests {

	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	@Test
	void simpleTest() {
		System.setOut(new PrintStream(outputStreamCaptor));
		DemoApplication.printNumbers();

		assertThat("1").isEqualTo(outputStreamCaptor.toString().substring(0, 1).trim());
		assertThat("foo").isEqualTo(outputStreamCaptor.toString().substring(2, 6).trim());
		assertThat("3").isEqualTo(outputStreamCaptor.toString().substring(7, 9).trim());
		assertThat("foofuu").isEqualTo(outputStreamCaptor.toString().substring(10, 17).trim());
		assertThat("5").isEqualTo(outputStreamCaptor.toString().substring(18, 20).trim());
	}

}
