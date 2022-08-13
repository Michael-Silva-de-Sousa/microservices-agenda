package br.com.avocat.agenda.exception;

public record ErrorResponse(
        int statusCode,
        String descricao
) {
}
