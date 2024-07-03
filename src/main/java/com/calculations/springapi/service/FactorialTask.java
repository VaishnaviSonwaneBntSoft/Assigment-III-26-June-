package com.calculations.springapi.service;

import org.springframework.stereotype.Component;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@NoArgsConstructor
public class FactorialTask implements Runnable{
    private int number;
    private int result;
    
    public FactorialTask(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        log.info("Calculating Factorial of {}",number);
        int factorial=1 , i=1;
        while(i<=number)
        {
            factorial = factorial*i;
        }
        result=factorial;
        log.info("Factorial of {} is {}", number,result);
    }

    public int getResult()
    {
        return result;
    }

}
