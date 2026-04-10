package com.example.backendmodule.integration.repository;

import com.example.backendmodule.entity.Beneficio;
import com.example.backendmodule.repository.BeneficioRepository;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;


import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class BeneficioRepositoryTest {

    @Autowired
    private BeneficioRepository repository;

    @Test
    void deveSalvarBeneficio() {

        var beneficio = new Beneficio();
        beneficio.setNome("Teste");
        beneficio.setValor(new BigDecimal("100"));
        beneficio.setAtivo(true);

        var saved = repository.save(beneficio);

        assertNotNull(saved.getId());
    }
}
