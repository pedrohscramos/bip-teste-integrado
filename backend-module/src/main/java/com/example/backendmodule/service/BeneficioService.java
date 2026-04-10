package com.example.backendmodule.service;

import com.example.backendmodule.dto.request.BeneficioRequest;
import com.example.backendmodule.dto.request.CriarBeneficioRequest;
import com.example.backendmodule.dto.response.BeneficioResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BeneficioService {

    BeneficioResponse create(CriarBeneficioRequest criarBeneficioRequest);
    Page<BeneficioResponse> findAll(Pageable pageable);
    void delete(Long id);
    void transfer(BeneficioRequest beneficioRequest);
}
