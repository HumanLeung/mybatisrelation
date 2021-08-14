package com.company.mybatis;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.AdditionalAnswers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MockitoTest {

    @Mock
    private MockitoRepository mockitoRepository;
//    private AutoCloseable closeable;

    @InjectMocks
    private MockitoService mockitoService;

//    @BeforeEach
//    void initService() {
//        closeable = MockitoAnnotations.openMocks(this);
//        mockitoService = new MockitoService(mockitoRepository);

//        mockitoRepository = mock(MockitoRepository.class);
//        mockitoService = new MockitoService(mockitoRepository);
//    }

//    @AfterEach
//    void closeService() throws Exception {
//        closeable.close();
//    }

    @Test
    void createMockitoSetsTheCreationDate() {
        MockitoPOJO mockitoPOJO = new MockitoPOJO();
        when(mockitoRepository.save(any(MockitoPOJO.class))).then(returnsFirstArg());

        MockitoPOJO mockitoPOJO1 = mockitoService.create(mockitoPOJO);
        assertNotNull(mockitoPOJO1.getCreationDate());
//        System.out.println(mockitoPOJO1.getCreationDate());
    }
}
