package br.com.avocat.agenda.dto;

import java.io.Serializable;
import java.time.LocalDate;

public record AgendaRecord(
        String chavePrivada,
        String titulo,
        String descricao,
        String dataFinal,
        String dataLembrete,
        LocalDate dataCadastro,
        LocalDate dataAtualizacao
) implements Serializable {
}