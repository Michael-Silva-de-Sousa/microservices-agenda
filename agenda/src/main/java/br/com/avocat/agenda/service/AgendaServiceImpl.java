package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.persistence.AgendaRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
    public Optional<Agenda> atualizar(Agenda agenda) {

        var result = agendaRepository.findById(agenda.getId());

        if (result.isPresent()) {
            result.get().setTitulo(agenda.getTitulo());
            result.get().setDescricao(agenda.getDescricao());
            result.get().setDataFinal(agenda.getDataFinal());
            result.get().setDataLembrete(agenda.getDataLembrete());
            result.get().setDataAtualizacao(LocalDateTime.now());

            return Optional.of(agendaRepository.save(result.get()));

        } else {
            return Optional.empty();
        }
    }

    @Override
    public Optional<Agenda> pesquisarPorID(String agendaID) {
        return agendaRepository.findById(agendaID);
    }

    @Override
    public Page<Agenda> pesquisarTodosPorProcessoID(Long processoID, Pageable pageable) {
        return agendaRepository.findAll(pageable);
    }

    @Override
    public Page<Agenda> pesquisarTodosPorContratoID(Long contratoID) {
        return Optional.empty();
    }

    @Override
    public Page<Agenda> pesquisarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable) {
        return agendaRepository.findAll(pageable);
    }

    @Override
    public void inativar(Long id) {

    }

    @Override
    public void excluir(Long id) {

    }
}
