package br.com.avocat.agenda.web;

import br.com.avocat.agenda.web.dto.AgendaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface AgendaController {

    @PostMapping
    ResponseEntity<AgendaDTO> salvar(@RequestBody AgendaDTO agendaRequest);

    @PutMapping
    ResponseEntity<AgendaDTO> atualizar(@RequestBody AgendaDTO agendaRequest);

    @GetMapping
    ResponseEntity<List<AgendaDTO>> pesquisarPorPeriodo(
            @RequestParam("dt-ini") String dataInicio,
            @RequestParam("dt-fin") String dataFinal);

    @GetMapping
    ResponseEntity<AgendaDTO> pesquisarPorID(Long id);

    @GetMapping
    ResponseEntity<List<AgendaDTO>> pesquisarTodosPorProcessoID(@RequestBody AgendaDTO agendaRequest);

    @GetMapping
    ResponseEntity<List<AgendaDTO>> pesquisarTodosPorContratoID(@RequestBody AgendaDTO agendaRequest);

    @PutMapping
    ResponseEntity<Void> inativar(@PathVariable("/{id}") Long id);

    @DeleteMapping
    ResponseEntity<Void> excluir(@PathVariable("/{id}") Long id);
}