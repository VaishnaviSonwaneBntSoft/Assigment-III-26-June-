package com.calculations.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.calculations.springapi.OperationsApplication;
import com.calculations.springapi.service.ArmstrongTask;
import com.calculations.springapi.service.CubeTask;
import com.calculations.springapi.service.EvenOddTask;
import com.calculations.springapi.service.FactorialTask;
import com.calculations.springapi.service.PalidromeTask;
import com.calculations.springapi.service.PrimeTask;
import com.calculations.springapi.service.ReverseTask;
import com.calculations.springapi.service.SqaureTask;

@SpringBootTest(classes = {OperationsApplication.class})
public class CalculationTasksTest {


    @Test
    public void testArmstrongTask() {
        ArmstrongTask task = new ArmstrongTask(153);
        task.run();
        assertEquals("Given Number Is ArmStrong", task.getResult());
        
        ArmstrongTask task2 = new ArmstrongTask(123);
        task2.run();
        assertEquals("Given Number Is Not ArmStrong", task2.getResult());
    }


    @Test
    public void testCubeTask() {
        CubeTask task = new CubeTask(3);
        task.run();
        assertEquals(27, task.getResult());
        
        CubeTask task2 = new CubeTask(5);
        task2.run();
        assertEquals(125, task2.getResult());
    }


    @Test
    public void testEvenOddTask() {
        EvenOddTask task = new EvenOddTask(4);
        task.run();
        assertEquals("Given Number Is Even", task.getResult());
        
        EvenOddTask task2 = new EvenOddTask(7);
        task2.run();
        assertEquals("Given Number Is Odd", task2.getResult());
    }


    @Test
    public void testFactorialTask() {
        FactorialTask task = new FactorialTask(5);
        task.run();
        assertEquals(120, task.getResult());
        
        FactorialTask task2 = new FactorialTask(0);
        task2.run();
        assertEquals(1, task2.getResult());
    }

   
    @Test
    public void testPalindromeTask() {
        PalidromeTask task = new PalidromeTask(121);
        task.run();
        assertEquals("Given Number Is Palidrome", task.getResult());
        
        PalidromeTask task2 = new PalidromeTask(123);
        task2.run();
        assertEquals("Given Number Is Not Palidrome", task2.getResult());
    }

    @Test
    public void testPrimeTask() {
        PrimeTask task = new PrimeTask(7);
        task.run();
        assertEquals("Given Number is Prime Number", task.getResult());
        
        PrimeTask task2 = new PrimeTask(4);
        task2.run();
        assertEquals("Given Number is Not Prime Number", task2.getResult());
    }

    
    @Test
    public void testReverseTask() {
        ReverseTask task = new ReverseTask(123);
        task.run();
        assertEquals(321, task.getResult());
        
        ReverseTask task2 = new ReverseTask(987);
        task2.run();
        assertEquals(789, task2.getResult());
    }


    @Test
    public void testSquareTask() {
        SqaureTask task = new SqaureTask(4);
        task.run();
        assertEquals(16, task.getResult());
        
        SqaureTask task2 = new SqaureTask(9);
        task2.run();
        assertEquals(81, task2.getResult());
    }
}

