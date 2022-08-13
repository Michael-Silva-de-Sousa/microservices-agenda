package br.com.avocat.agenda.web;

import br.com.avocat.agenda.web.dto.AgendaRecord;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface AgendaController {

    @PostMapping
    ResponseEntity<AgendaRecord> salvar(@RequestBody AgendaRecord agendaRequest);

    @PutMapping
    ResponseEntity<AgendaRecord> atualizar(@RequestBody AgendaRecord agendaRequest);

    @GetMapping
    ResponseEntity<Page<AgendaRecord>> pesquisarPorPeriodo(
            @RequestParam("dt-ini") String dataInicio,
            @RequestParam("dt-fin") String dataFinal);

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