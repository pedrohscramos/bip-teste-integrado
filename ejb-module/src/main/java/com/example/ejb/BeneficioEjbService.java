package com.example.ejb;

import com.example.ejb.entity.Beneficio;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.LockModeType;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Stateless
@Component
public class BeneficioEjbService {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void transfer(Long fromId, Long toId, BigDecimal amount) {

        validateTransfer(fromId, toId, amount);

        Long primeiroId = Math.min(fromId, toId);
        Long segundoId = Math.max(fromId, toId);

        Beneficio primeiroBeneficio = em.find(Beneficio.class, primeiroId, LockModeType.PESSIMISTIC_WRITE);
        Beneficio segundoBeneficio = em.find(Beneficio.class, segundoId, LockModeType.PESSIMISTIC_WRITE);


        Beneficio from = fromId.equals(primeiroId) ? primeiroBeneficio : segundoBeneficio;
        Beneficio to   = toId.equals(primeiroId) ? primeiroBeneficio : segundoBeneficio;

        validateBeneficioExists(from, to);
        validateBeneficioAtivo(from, to);
        validateSaldo(from, amount);

        from.setValor(from.getValor().subtract(amount));
        to.setValor(to.getValor().add(amount));

        em.merge(from);
        em.merge(to);
        em.flush();
    }


    private void validateTransfer(Long fromId, Long toId, BigDecimal amount) {
        if (fromId == null || toId == null) {
            throw new IllegalArgumentException("IDs de origem e destino são obrigatórios");
        }
        if (fromId.equals(toId)) {
            throw new IllegalArgumentException("Origem e destino devem ser diferentes");
        }
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Valor da transferência deve ser maior que zero");
        }
    }

    private void validateBeneficioExists(Beneficio from, Beneficio to) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Benefício de origem ou destino não encontrado");
        }
    }

    private void validateBeneficioAtivo(Beneficio from, Beneficio to) {
        if (!Boolean.TRUE.equals(from.getAtivo()) || !Boolean.TRUE.equals(to.getAtivo())) {
            throw new IllegalStateException("Transferência permitida apenas entre benefícios ativos");
        }
    }

    private void validateSaldo(Beneficio from, BigDecimal amount) {
        if (from.getValor().compareTo(amount) < 0) {
            throw new IllegalStateException("Saldo insuficiente para transferência");
        }
    }
}
