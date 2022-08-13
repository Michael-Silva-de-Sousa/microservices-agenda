package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.persistence.AgendaRepository;
import br.com.avocat.agenda.web.dto.AgendaRecord;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AgendaServiceImpl implements AgendaService {

    private AgendaRepository agendaRepository;

    @Override
    public Optional<AgendaRecord> salvar(Agenda agenda) {
        return Optional.empty();
    }

    @Override
    public Optional<AgendaRecord> atualizar(Agenda agenda) {
        return Optional.empty();
    }

    @Override
    public Optional<AgendaRecord> pesquisarPorID(Long id) {
        return Optional.empty();
    }

    @Override
    public Page<AgendaRecord> pesquisarTodosPorProcessoID(Long processoID) {

        Pageable pageable = PageRequest.of(0, 10);
        Page<Agenda> agendas = agendaRepository.findAll(pageable);
        return ;
    }

    @Override
    public Page<AgendaRecord> pesquisarTodosPorContratoID(Long contratoID) {
        return Optional.empty();
    }

    @Override
    public Page<Page<AgendaRecord>> pesquisarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return Optional.empty();
    }

    @Override
    public void inativar(Long id) {

    }

    @Override
    public void excluir(Long id) {

    }
}
