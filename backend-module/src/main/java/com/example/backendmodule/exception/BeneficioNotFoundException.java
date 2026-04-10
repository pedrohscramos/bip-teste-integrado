package com.example.backendmodule.exception;

public class BeneficioNotFoundException extends RuntimeException {
    public BeneficioNotFoundException(Long id) {
        super("Beneficio id " + id + " não encontrado");
    }
}
