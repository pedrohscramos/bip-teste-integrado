package com.example.backendmodule.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Schema(description = "Dados para criação de um benefício")
public record CriarBeneficioRequest(
        @Schema(
                description = "Nome do benefício",
                example = "Vale Refeição",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @NotBlank(message = "Nome é obrigatório")
        String nome,

        @Schema(
                description = "Descrição do benefício",
                example = "Benefício destinado à alimentação"
        )
        String descricao,


        @Schema(
                description = "Valor do benefício",
                example = "500.00",
                requiredMode = Schema.RequiredMode.REQUIRED
        )
        @Positive
        BigDecimal valor
) {
}
