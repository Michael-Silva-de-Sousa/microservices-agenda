package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

public interface AgendaService {

    @Transactional
    Optional<Agenda> salvar(Agenda agenda);

    Optional<Agenda> pesquisarPorId(String agendaID);

    Page<Agenda> pesquisarTodosPorProcessoId(Long processoId, Pageable pageable);

    Page<Agenda> pesquisarTodosPorContratoId(Long contratoId);

    Page<Agenda> pesquisarPorPeriodo(String dataInicial, String dataFinal, Pageable pageable);

    void excluir(String id);
}
