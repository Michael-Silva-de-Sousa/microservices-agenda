package br.com.avocat.agenda.web.dto;

import java.time.LocalDateTime;

public record AgendaRecord(
        Long processoID,
        Long contratoID,
        String descricao,
        LocalDateTime dataInclusao,
        LocalDateTime dataFatal
) {
}
