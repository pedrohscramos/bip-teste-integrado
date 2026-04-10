package com.example.backendmodule.unit.service;

import com.example.backendmodule.dto.request.CriarBeneficioRequest;
import com.example.backendmodule.repository.BeneficioRepository;
import com.example.backendmodule.service.impl.BeneficioServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class BeneficioServiceImplTest {

    @Mock
    private BeneficioRepository repository;

    @InjectMocks
    private BeneficioServiceImpl service;

    @Test
    void deveCriarBeneficioComSucesso() {

        var request = new CriarBeneficioRequest("Vale Refeição Teste", "Desc", new BigDecimal("500"));

        when(repository.save(any())).thenAnswer(invocation -> invocation.getArgument(0));

        var response = service.create(request);

        assertNotNull(response);
        verify(repository).save(any());
    }
}
