package com.calculations.springapi.service;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@NoArgsConstructor
public class ReverseTask implements Runnable{
    private int number;
    private int result;
    
    public ReverseTask(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        log.info("Performing Reverse of {}",number);
        int reveseNumber=0;
        while(number>0)
        {
            int remender = number%10;
            reveseNumber = reveseNumber*10+remender;
            number = number/10;
        }
        result=reveseNumber;
        log.info("Reverse of {} is {}", number,result);
    }

    public int getResult()
    {
        return result;
    }
}
