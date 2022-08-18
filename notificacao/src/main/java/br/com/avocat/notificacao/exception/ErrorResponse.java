package br.com.avocat.notificacao.exception;

import java.util.List;

public record ErrorResponse(
        int statusCode,
        String descricao,
        List<String> falhas
) {
}
