package com.calculations.springapi.controller;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.calculations.springapi.service.ArmstrongTask;
import com.calculations.springapi.service.CubeTask;
import com.calculations.springapi.service.EvenOddTask;
import com.calculations.springapi.service.FactorialTask;
import com.calculations.springapi.service.PalidromeTask;
import com.calculations.springapi.service.PrimeTask;
import com.calculations.springapi.service.ReverseTask;
import com.calculations.springapi.service.SqaureTask;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestMapping;


@Slf4j
@RestController
@RequestMapping("/api/calculator")
public class OperationsController {
    
    private ExecutorService executor = Executors.newFixedThreadPool(8);

    @PostMapping("/calculate/{number}")
    public ResponseEntity<String> calculate(@PathVariable("number") int number)
    {  
        log.info("Received request to calculate tasks for number: {}", number);

        try{
            executor.submit(new SqaureTask(number));
            executor.submit(new ArmstrongTask(number));
            executor.submit(new CubeTask(number));
            executor.submit(new EvenOddTask(number));
            executor.submit(new FactorialTask(number));
            executor.submit(new PalidromeTask(number));
            executor.submit(new PrimeTask(number));
            executor.submit(new ReverseTask(number));
           
          
            return ResponseEntity.ok("Calculation tasks submitted successfully.");
        }
        catch(Exception ex)
        {
            log.error("Error Occur During Calculations", ex.getMessage());
            return ResponseEntity.internalServerError().body("Error submitting calculation tasks.");
        }
    }
}
