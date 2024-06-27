package com.calculations.springapi.service;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@NoArgsConstructor
public class CubeTask implements Runnable{
    private int number;
    private int result;
    
    public CubeTask(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        log.info("Calculating Cube of {}",number);
        result = number*number*number;
        System.out.println("From run - > "+result);
        log.info("Cube of {} is {}", number,result);
    }

    public int getResult()
    {
        return result;
    }

}
