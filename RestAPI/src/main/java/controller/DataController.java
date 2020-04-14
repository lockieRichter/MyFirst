package controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import model.InputData;
import model.OutputData;

@RestController
public class DataController {

	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<OutputData> postData(@RequestBody InputData data) {

		OutputData output = getSumSquares(data);

		return new ResponseEntity<>(output, HttpStatus.OK);
	}

	OutputData getSumSquares(InputData data) {
		Optional<Double> maxSquares = Arrays.stream(data.getData())
				.boxed()
				.sorted(Collections.reverseOrder())
				.limit(3)
				.map(e -> Math.pow(e, 2))
				.reduce((a, b) -> a + b);

		OutputData output = new OutputData(Math.sqrt(maxSquares.get()));
		return output;
	}
}
