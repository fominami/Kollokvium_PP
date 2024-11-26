package com.example.example_kol;
import com.example.example_kol.controllers.TaskController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExampleKolApplicationTests {

	private TaskController factorialController;

	@BeforeEach
	public void setUp() {
		factorialController = new TaskController();
	}

	@Test
	public void testGetFactorials_ValidInput() {
		ResponseEntity<List<Long>> response = factorialController.getFibonacci(5);

		assertEquals(200, response.getStatusCodeValue());
		assertEquals(5, response.getBody().size());
		assertEquals(List.of(0L, 1L, 1L, 2L, 3L), response.getBody());
	}

	@Test
	public void testGetFactorials_InvalidInput_Negative() {
		ResponseEntity<List<Long>> response = factorialController.getFibonacci(-1);

		assertEquals(400, response.getStatusCodeValue());
		assertEquals(null, response.getBody());
	}


}
