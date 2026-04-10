package com.example.backendmodule.controller;

import com.example.backendmodule.dto.request.BeneficioRequest;
import com.example.backendmodule.dto.request.CriarBeneficioRequest;
import com.example.backendmodule.dto.response.BeneficioResponse;
import com.example.backendmodule.dto.response.ResponseFactory;
import com.example.backendmodule.dto.response.ResponseWrapper;
import com.example.backendmodule.service.BeneficioService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Benefícios", description = "API para gerenciamento de benefícios")
@RestController
@RequestMapping("/api/v1/beneficios")
public class BeneficioController {

    private final BeneficioService beneficioService;

    public BeneficioController(BeneficioService beneficioService) {
        this.beneficioService = beneficioService;
    }


    @Operation(
            summary = "Transferir benefício",
            description = "Realiza a transferência de valor entre benefícios"
    )
    @ApiResponse(responseCode = "201", description = "Transferência realizada com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @PutMapping
    public ResponseEntity<ResponseWrapper<Void>> transfer(@RequestBody @Valid BeneficioRequest request) {
        beneficioService.transfer(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseFactory.success(null,"Transferência realizada com sucesso"));
    }

    @Operation(
            summary = "Listar benefícios",
            description = "Retorna lista paginada de benefícios"
    )
    @ApiResponse(responseCode = "200", description = "Lista retornada com sucesso")
    @GetMapping
    public ResponseEntity<ResponseWrapper<List<BeneficioResponse>>> getBeneficios(@ParameterObject @Parameter(description = "Parâmetros de paginação") @PageableDefault(size = 10) Pageable pageable) {
        var list = beneficioService.findAll(pageable).getContent();
        return ResponseEntity.ok(ResponseFactory.success(list));

    }

    @Operation(
            summary = "Criar benefício",
            description = "Cria um novo benefício"
    )
    @ApiResponse(responseCode = "201", description = "Benefício criado com sucesso")
    @ApiResponse(responseCode = "400", description = "Dados inválidos")
    @PostMapping
    public ResponseEntity<ResponseWrapper<Void>> criarBeneficio(@RequestBody @Valid CriarBeneficioRequest beneficioRequest) {
        beneficioService.create(beneficioRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(ResponseFactory.success(null, "Benefício criado com sucesso"));
    }

    @Operation(
            summary = "Deletar benefício",
            description = "Remove um benefício pelo ID"
    )
    @ApiResponse(responseCode = "204", description = "Benefício removido com sucesso")
    @ApiResponse(responseCode = "404", description = "Benefício não encontrado")
    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseWrapper<Void>> deleteBeneficio(@Parameter(description = "ID do benefício", example = "1") @PathVariable Long id){
        beneficioService.delete(id);
        return ResponseEntity.ok(ResponseFactory.success(null, "Benefício removido com sucesso"));
    }
}
