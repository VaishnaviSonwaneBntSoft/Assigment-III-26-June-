package com.calculations.springapi.service;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@NoArgsConstructor
public class SqaureTask implements Runnable{
    private int number;
    private int result;
    
    public SqaureTask(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        log.info("Calculating Sqaure of {}",number);
        result = number*number;
        log.info("Sqaure of {} is {}", number,result);
    }

    public int getResult()
    {
        return result;
    }

}
