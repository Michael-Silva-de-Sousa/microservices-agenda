package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.web.dto.AgendaRecord;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Optional;

public interface AgendaService {

    Optional<AgendaRecord> salvar(Agenda agenda);

    Optional<AgendaRecord> atualizar(Agenda agenda);

    Optional<AgendaRecord> pesquisarPorID(Long id);

    Page<Agenda> pesquisarTodosPorProcessoID(Long processoID, Pageable pageable);

    Page<Agenda> pesquisarTodosPorContratoID(Long contratoID);

    Page<Agenda> pesquisarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);

    void inativar(Long id);

    void excluir(Long id);
}
