package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class InputDataTest {

	InputData data = new InputData();
	private double[] validArray = { 5, 4, 6, 1 };
	private double[] invalidArray = { 5, 4 };

	@Test
	public void setData_WithValidInput_Succesful() {
		data.setData(validArray);

		assertEquals(validArray, data.getData());
	}

	@Test
	public void setData_WithInvalidInput_ThrowsIllegalArgument() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			data.setData(invalidArray);
		});

		String expectedMessage = "";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
}