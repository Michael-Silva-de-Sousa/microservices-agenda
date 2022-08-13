package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.web.dto.AgendaDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class AgendaServiceImpl implements AgendaService {

    @Override
    public Optional<AgendaDTO> salvar(Agenda agenda) {
        return Optional.empty();
    }

    @Override
    public Optional<AgendaDTO> atualizar(Agenda agenda) {
        return Optional.empty();
    }

    @Override
    public Optional<AgendaDTO> pesquisarPorID(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<AgendaDTO> pesquisarTodosPorProcessoID(Long processoID) {
        return Optional.empty();
    }

    @Override
    public Optional<AgendaDTO> pesquisarTodosPorContratoID(Long contratoID) {
        return Optional.empty();
    }

    @Override
    public Optional<List<AgendaDTO>> pesquisarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal) {
        return Optional.empty();
    }

    @Override
    public void inativar(Long id) {

    }

    @Override
    public void excluir(Long id) {

    }
}
