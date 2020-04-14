package controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.InputData;
import model.OutputData;

public class DataControllerTest {

	MockMvc mockMvc;

	DataController dataController = new DataController();

	@BeforeEach
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(dataController).build();
	}

	@Test
	public void getSumSquares_WithValidInput_ReturnsCorrectSquares() {
		double[] validArray = { 5, 4, 6, 1 };
		InputData validInput = new InputData();
		validInput.setData(validArray);

		OutputData result = dataController.getSumSquares(validInput);
		double expected = 8.77;

		Assertions.assertEquals(expected, result.getOutput());
	}

	@Test
	public void postData_WithValidInput_ReturnsOutput() throws Exception {
		double[] validArray = { 5, 4, 6, 1 };
		InputData validInput = new InputData();
		validInput.setData(validArray);

		mockMvc.perform(post("").contentType(MediaType.APPLICATION_JSON_VALUE)
				.accept(MediaType.APPLICATION_JSON_VALUE)
				.content(asJsonString(validInput))).andExpect(status().isOk()).andExpect(
						jsonPath(".output").value((8.77)));
	}

	/*
	 * converts a Java object into JSON representation
	 */
	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
