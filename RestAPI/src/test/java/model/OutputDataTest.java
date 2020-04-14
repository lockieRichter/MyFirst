package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class OutputDataTest {

	@Test
	public void constuctor_WithThreeDecimals_SetsTwoDecimalPlaces() {
		double threeDecimals = 3.123;
		OutputData output = new OutputData(threeDecimals);

		double expected = 3.12;

		assertEquals(expected, output.getOutput());
	}

	@Test
	public void constuctor_WithOneDecimal_DoesntChange() {
		double oneDecimal = 3.1;
		OutputData output = new OutputData(oneDecimal);

		double expected = 3.1;

		assertEquals(expected, output.getOutput());
	}
}
