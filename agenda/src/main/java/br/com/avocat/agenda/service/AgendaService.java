package br.com.avocat.agenda.service;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.web.dto.AgendaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface AgendaService {

    Optional<AgendaDTO> salvar(Agenda agenda);

    Optional<AgendaDTO> atualizar(Agenda agenda);

    Optional<AgendaDTO> pesquisarPorID(Long id);

    Optional<AgendaDTO> pesquisarTodosPorProcessoID(Long processoID);

    Optional<AgendaDTO> pesquisarTodosPorContratoID(Long contratoID);

    Optional<List<AgendaDTO>> pesquisarPorPeriodo(LocalDate dataInicial, LocalDate dataFinal);

    void inativar(Long id);

    void excluir(Long id);
}
