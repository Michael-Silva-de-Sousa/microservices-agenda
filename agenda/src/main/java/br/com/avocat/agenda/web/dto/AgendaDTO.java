package br.com.avocat.agenda.web.dto;

import java.time.LocalDateTime;

public record AgendaDTO(
        Long processoID,
        Long contratoID,
        String descricao,
        LocalDateTime dataInclusao,
        LocalDateTime dataFatal
) {
}
