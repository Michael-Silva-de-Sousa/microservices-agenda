package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.persistence.AgendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AgendaServiceImpl {

    private AgendaRepository agendaRepository;

    @Transactional
    public Optional<Agenda> salvar(Agenda agenda) {
        return Optional.of(agendaRepository.save(agenda));
    }

    public Optional<Agenda> pesquisarPorId(String agendaId) {
        return agendaRepository.findById(agendaId);
    }

    public Page<Agenda> pesquisarTodosPorProcessoId(Long processoId, Pageable pageable) {
        return agendaRepository.findAll(pageable);
    }

    public Page<Agenda> pesquisarTodosPorContratoId(Long contratoId) {
        return Page.empty();
    }

    public Page<Agenda> pesquisarPorPeriodo(String dataInicial, String dataFinal, Pageable pageable) {

        LocalDate dataInicialLocalDate = LocalDate.parse(dataInicial);
        LocalDate dataFinalLocalDate = LocalDate.parse(dataFinal);

        return agendaRepository.pesquisaPorPeriodo(dataInicialLocalDate, dataFinalLocalDate, pageable);
    }

    @Transactional
    public void excluir(String agendaId) {
        var agenda = agendaRepository.findById(agendaId);
        agenda.ifPresent(value -> agendaRepository.delete(value));
    }
}
