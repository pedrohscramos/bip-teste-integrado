package com.example.backendmodule.service.impl;

import com.example.backendmodule.dto.request.BeneficioRequest;
import com.example.backendmodule.dto.request.CriarBeneficioRequest;
import com.example.backendmodule.dto.response.BeneficioResponse;
import com.example.backendmodule.entity.Beneficio;
import com.example.backendmodule.exception.BeneficioNotFoundException;
import com.example.backendmodule.exception.SaldoInsuficienteException;
import com.example.backendmodule.repository.BeneficioRepository;
import com.example.backendmodule.service.BeneficioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BeneficioServiceImpl implements BeneficioService {


    @Autowired
    private BeneficioRepository beneficioRepository;

    @Transactional
    public void transfer(BeneficioRequest beneficioRequest) {
        Beneficio from = beneficioRepository.findById(beneficioRequest.fromId())
                .orElseThrow(() -> new BeneficioNotFoundException(beneficioRequest.fromId()));

        Beneficio to = beneficioRepository.findById(beneficioRequest.toId())
                .orElseThrow(() -> new BeneficioNotFoundException(beneficioRequest.toId()));

        if (from.getValor().compareTo(beneficioRequest.amount()) < 0) {
            throw new SaldoInsuficienteException("Saldo insuficiente");
        }

        from.setValor(from.getValor().subtract(beneficioRequest.amount()));
        to.setValor(to.getValor().add(beneficioRequest.amount()));

        beneficioRepository.save(from);
        beneficioRepository.save(to);

    }

    public Page<BeneficioResponse> findAll(Pageable  pageable) {
        Page<Beneficio> beneficios = beneficioRepository.findAll(pageable);
        return beneficios.map(this::convertToDTO);
    }

    public BeneficioResponse create(CriarBeneficioRequest beneficioRequest) {

        Beneficio novoBeneficio = new Beneficio();
        novoBeneficio.setNome(beneficioRequest.nome());
        novoBeneficio.setDescricao(beneficioRequest.descricao());
        novoBeneficio.setValor(beneficioRequest.valor());
        novoBeneficio.setAtivo(true);

        beneficioRepository.save(novoBeneficio);
        return convertToDTO(novoBeneficio);
    }

    public void delete(Long id) {
        if (!beneficioRepository.existsById(id)){
            throw new BeneficioNotFoundException(id);
        }
        beneficioRepository.deleteById(id);
    }

    private BeneficioResponse convertToDTO(Beneficio beneficio) {
        BeneficioResponse beneficioResponse = new BeneficioResponse(
                beneficio.getId(),
                beneficio.getNome(),
                beneficio.getDescricao(),
                beneficio.getValor(),
                beneficio.getAtivo()

        );
        return beneficioResponse;
    }
}
