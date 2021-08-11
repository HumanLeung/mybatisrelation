package com.company.mybatis;

import java.time.LocalDateTime;

public class MockitoService {

    private final MockitoRepository mockitoRepository;

    public MockitoService(MockitoRepository mockitoRepository){
        this.mockitoRepository = mockitoRepository;
    }

    public MockitoPOJO create(MockitoPOJO mockitoPOJO) {
        mockitoPOJO.setCreationDate(LocalDateTime.now());
        return mockitoRepository.save(mockitoPOJO);
    }
}
