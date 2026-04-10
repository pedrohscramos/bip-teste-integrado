package com.example.backendmodule.dto.response;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDateTime;
import java.util.List;

public record ResponseWrapper<T>(
        @Schema(description = "Indica se a operação foi bem-sucedida", example = "true")
        boolean success,

        @Schema(description = "Dados retornados pela API")
        T data,

        @Schema(description = "Mensagem da operação", example = "Operação realizada com sucesso")
        String message,

        @Schema(description = "Timestamp da resposta")
        LocalDateTime timestamp,

        @Schema(description = "Lista de erros (quando houver)")
        List<String> errors
) {
}
