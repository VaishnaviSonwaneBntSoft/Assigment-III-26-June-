package com.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.calculations.springapi.controller.OperationsController;

public class OperationsControllerTest {

    @Mock
    private ExecutorService executorServiceMock;

    @InjectMocks
    private OperationsController operationsController;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void tearDown() {
        verifyNoMoreInteractions(executorServiceMock);
    }


    @Test
    public void testCalculate_Success() {
        int number = 10;

        when(executorServiceMock.submit(any(Runnable.class))).thenReturn(mock(Future.class));

        ResponseEntity<String> responseEntity = operationsController.calculate(number);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals("Calculation tasks submitted successfully.", responseEntity.getBody());

        verify(executorServiceMock, times(8)).submit(any(Runnable.class));

        ArgumentCaptor<Runnable> runnableCaptor = ArgumentCaptor.forClass(Runnable.class);
        verify(executorServiceMock, times(8)).submit(runnableCaptor.capture());

    }

    @Test
    public void testCalculate_Error() {
        int number = 10;

        when(executorServiceMock.submit(any(Runnable.class))).thenThrow(new RuntimeException("Mocked error"));

        ResponseEntity<String> responseEntity = operationsController.calculate(number);

        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertEquals("Error submitting calculation tasks.", responseEntity.getBody());

        verify(executorServiceMock, times(1)).submit(any(Runnable.class));

    }
}

