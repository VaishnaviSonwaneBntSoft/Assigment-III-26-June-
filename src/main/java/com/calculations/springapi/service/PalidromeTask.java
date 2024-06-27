package com.calculations.springapi.service;

import org.springframework.stereotype.Component;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@NoArgsConstructor
@Slf4j
public class PalidromeTask implements Runnable{
    private int number;
    private String result;
    
    public PalidromeTask(int number) {
        this.number=number;
    }

    @Override
    public void run() {
        log.info("Checking Number Is ArmStrong Or Not");
        int tempNumber = number;
        int reveseNumber=0;
        while(tempNumber>0)
        {
            int remender = tempNumber%10;
            reveseNumber = reveseNumber*10+remender;
            tempNumber = tempNumber/10;
            System.out.println(tempNumber);
        }
        if(reveseNumber==number)
             result="Given Number Is Palidrome";
        else
             result="Given Number Is Not Palidrome";
    }

    public String getResult()
    {
        return result;
    }

}
