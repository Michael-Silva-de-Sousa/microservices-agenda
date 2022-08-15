package br.com.avocat.agenda.exception;

import java.util.List;

public record ErrorResponse(
        int statusCode,
        String descricao,
        List<String> falhas
) {
}
