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

    @Transactional
    Optional<Agenda> atualizar(Agenda agenda);

    Optional<Agenda> pesquisarPorID(String agendaID);

    Page<Agenda> pesquisarTodosPorProcessoID(Long processoID, Pageable pageable);

    Page<Agenda> pesquisarTodosPorContratoID(Long contratoID);

    Page<Agenda> pesquisarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);

    void inativar(Long id);

    void excluir(Long id);
}
