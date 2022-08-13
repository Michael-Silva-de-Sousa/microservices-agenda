package br.com.avocat.agenda.web;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.web.dto.AgendaRecord;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

public interface AgendaController {

    @PostMapping
    ResponseEntity<AgendaRecord> salvar(@RequestBody AgendaRecord agendaRequest);

    @PutMapping
    ResponseEntity<AgendaRecord> atualizar(@RequestBody AgendaRecord agendaRequest);

    @GetMapping
    Page<Agenda> pesquisarPorPeriodo(
            @RequestParam("dt-ini") LocalDate dataInicio,
            @RequestParam("dt-fin") LocalDate dataFinal,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size);

    @GetMapping
    ResponseEntity<AgendaRecord> pesquisarPorID(Long id);

    @GetMapping
    ResponseEntity<Page<AgendaRecord>> pesquisarTodosPorProcessoID(@RequestBody AgendaRecord agendaRequest);

    @GetMapping
    ResponseEntity<Page<AgendaRecord>> pesquisarTodosPorContratoID(@RequestBody AgendaRecord agendaRequest);

    @PutMapping
    ResponseEntity<Void> inativar(@PathVariable("/{id}") Long id);

    @DeleteMapping
    ResponseEntity<Void> excluir(@PathVariable("/{id}") Long id);
}