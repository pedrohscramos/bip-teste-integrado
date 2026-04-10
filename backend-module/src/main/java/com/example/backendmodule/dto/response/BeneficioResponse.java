package com.example.backendmodule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.math.BigDecimal;

@Schema(description = "Dados retornados de um benefício")
public record BeneficioResponse(
        @Schema(
                description = "ID único do benefício",
                example = "1"
        )
        Long id,

        @Schema(
                description = "Nome do benefício",
                example = "Vale Refeição"
        )
        String nome,

        @Schema(
                description = "Descrição do benefício",
                example = "Benefício destinado à alimentação"
        )
        String descricao,

        @Schema(
                description = "Valor do benefício",
                example = "500.00"
        )
        BigDecimal valor,

        @Schema(
                description = "Indica se o benefício está ativo",
                example = "true"
        )
        boolean ativo
) {
}
