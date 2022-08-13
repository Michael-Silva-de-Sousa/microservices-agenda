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
    ResponseEntity<Agenda> cadastrar(@RequestBody Agenda agenda);

    @PutMapping
    ResponseEntity<Agenda> atualizar(@RequestBody Agenda agenda);

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
    ResponseEntity<Agenda> pesquisarPorID(@PathVariable("agendaID") String id);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<Agenda>> pesquisarTodosPorProcessoID(@RequestBody AgendaRecord agendaRequest);

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<Agenda>> pesquisarTodosPorContratoID(@RequestBody AgendaRecord agendaRequest);
}