package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.persistence.AgendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AgendaServiceImpl implements AgendaService {

    private AgendaRepository agendaRepository;

    @Override
    public Optional<Agenda> salvar(Agenda agenda) {
        return Optional.of(agendaRepository.save(agenda));
    }

    @Override
    public Optional<Agenda> pesquisarPorId(String agendaId) {
        return agendaRepository.findById(agendaId);
    }

    @Override
    public Page<Agenda> pesquisarTodosPorProcessoId(Long processoId, Pageable pageable) {
        return agendaRepository.findAll(pageable);
    }

    @Override
    public Page<Agenda> pesquisarTodosPorContratoId(Long contratoId) {
        return Page.empty();
    }

    @Override
    public Page<Agenda> pesquisarPorPeriodo(String dataInicial, String dataFinal, Pageable pageable) {

        LocalDate dataInicialLocalDate = LocalDate.parse(dataInicial);
        LocalDate dataFinalLocalDate = LocalDate.parse(dataFinal);

        return agendaRepository.pesquisaPorPeriodo(dataInicialLocalDate, dataFinalLocalDate, pageable);
    }

    @Override
    public void excluir(String id) {
        var agenda = agendaRepository.findById(id);
        agenda.ifPresent(value -> agendaRepository.delete(value));
    }
}
