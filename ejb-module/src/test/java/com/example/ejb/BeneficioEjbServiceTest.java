package com.example.ejb;

import com.example.ejb.entity.Beneficio;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BeneficioEjbServiceTest {
    @Mock
    private EntityManager em;
    @InjectMocks
    private BeneficioEjbService service;

    @Test
    @DisplayName("Deve lancar excecao quando o saldo for menor do que o transferido")
    void testSaldoInsuficiente() {
        var origin = createBeneficio(1L, new BigDecimal("100.00"));
        var destination = createBeneficio(2L, new BigDecimal("50.00"));

        when(em.find(eq(Beneficio.class), eq(1L), eq(LockModeType.PESSIMISTIC_WRITE))).thenReturn(origin);
        when(em.find(eq(Beneficio.class), eq(2L), eq(LockModeType.PESSIMISTIC_WRITE))).thenReturn(destination);

        var exception = assertThrows(IllegalStateException.class,
                () -> service.transfer(1L, 2L, new BigDecimal("150.00")));

        assertTrue(exception.getMessage().contains("Saldo insuficiente"));
    }

    private Beneficio createBeneficio(Long id, BigDecimal balance) {
        var b = new Beneficio();
        b.setId(id);
        b.setValor(balance);
        b.setAtivo(true);
        return b;
    }
}
