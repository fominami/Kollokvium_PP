package com.example.example_kol.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/fibonacci")
public class TaskController {

    @GetMapping
    public ResponseEntity<List<Long>> getFibonacci(@RequestParam int n) {
        if (n <= 0) return ResponseEntity.badRequest().body(null);

        List<Long> fibonacciNumbers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            fibonacciNumbers.add(fibonacci(i));
        }
        return ResponseEntity.ok(fibonacciNumbers);
    }

    private long fibonacci(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        }

        long a = 0;
        long b = 1;
        long result = 0;
        for (int i = 2; i <= number; i++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }
}
