package br.com.avocat.agenda.web;

import br.com.avocat.agenda.persistence.Agenda;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

public interface AgendaController {

    @PostMapping("/cadastrar")
    ResponseEntity<Agenda> cadastrar(@RequestBody Agenda agenda);

    @PutMapping("/atualizar")
    ResponseEntity<Agenda> atualizar(@RequestBody Agenda agenda);

    @GetMapping("/inativar")
    ResponseEntity<Void> inativar(@PathVariable("/{id}") Long id);

    @DeleteMapping("/excluir")
    ResponseEntity<Void> excluir(@PathVariable("/{id}") Long id);

    @GetMapping("/pesquisar")
    ResponseEntity<Page<Agenda>> pesquisarPorPeriodo(
            @RequestParam("dt-ini") LocalDate dataInicio,
            @RequestParam("dt-fin") LocalDate dataFinal,
            @RequestParam(required = false) Integer page,
            @RequestParam(required = false) Integer size);

    @GetMapping("/id")
    ResponseEntity<Agenda> pesquisarPorID(@PathVariable("agendaID") String id);

    @GetMapping("/processos")
    ResponseEntity<Page<Agenda>> pesquisarTodosPorProcessoID(@PathVariable("processoID") Long processoID);

    @GetMapping("/contratos")
    ResponseEntity<Page<Agenda>> pesquisarTodosPorContratoID(@PathVariable("contratoID") Long contratoID);
}