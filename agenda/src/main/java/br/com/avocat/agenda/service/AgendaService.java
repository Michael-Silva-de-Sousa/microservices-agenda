package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.web.dto.AgendaRecord;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Optional;

public interface AgendaService {

    Optional<AgendaRecord> salvar(Agenda agenda);

    Optional<AgendaRecord> atualizar(Agenda agenda);

    Optional<AgendaRecord> pesquisarPorID(Long id);

    Page<AgendaRecord> pesquisarTodosPorProcessoID(Long processoID);

    Page<AgendaRecord> pesquisarTodosPorContratoID(Long contratoID);

    Page<Page<AgendaRecord>> pesquisarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal);

    void inativar(Long id);

    void excluir(Long id);
}
