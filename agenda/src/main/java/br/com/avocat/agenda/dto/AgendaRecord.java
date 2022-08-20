package br.com.avocat.agenda.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record AgendaRecord(
        String chavePrivada,
        String titulo,
        String descricao,
        LocalDate dataCadastro,
        LocalDateTime dataLembrete,
        LocalDateTime dataFinal,
        LocalDate dataAtualizacao
        ) {
}
