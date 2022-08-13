package br.com.avocat.agenda.web;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.web.dto.AgendaRecord;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

public interface AgendaController {

    @PostMapping
    ResponseEntity<Agenda> salvar(@RequestBody Agenda agenda);

    @PutMapping
    ResponseEntity<AgendaRecord> atualizar(@RequestBody AgendaRecord agendaRequest);

    @GetMapping
    ResponseEntity<Void> inativar(@PathVariable("/{id}") Long id);

    @DeleteMapping
    ResponseEntity<Void> excluir(@PathVariable("/{id}") Long id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<Agenda>> pesquisarPorPeriodo(
            @RequestParam("dt-ini") LocalDate dataInicio,
            @RequestParam("dt-fin") LocalDate dataFinal,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<AgendaRecord> pesquisarPorID(Long id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<AgendaRecord>> pesquisarTodosPorProcessoID(@RequestBody AgendaRecord agendaRequest);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<AgendaRecord>> pesquisarTodosPorContratoID(@RequestBody AgendaRecord agendaRequest);
}