package com.example.backendmodule.dto.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

@Schema(description = "Dados para transferência de benefício")
public record BeneficioRequest(
        @Schema(description = "ID origem", example = "1")
        @NotNull(message = "fromId é obrigatório")
        Long fromId,

        @Schema(description = "ID destino", example = "2")
        @NotNull(message = "toId é obrigatório")
        Long toId,

        @Schema(description = "Valor da transferência", example = "100.00")
        @NotNull(message = "O valor é obrigatório")
        @Positive(message = "O valor deve ser positivo e maior que zero")
        BigDecimal amount
) {
}
