package br.com.avocat.agenda.web;

import br.com.avocat.agenda.persistence.Agenda;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;

public interface AgendaController {

    @PostMapping
    ResponseEntity<Agenda> salvar(@RequestBody @Valid Agenda agenda);

    @GetMapping("/pesquisar")
    ResponseEntity<Page<Agenda>> pesquisarPorPeriodo(
            @RequestParam(value = "dt-ini", required = true) LocalDate dataInicio,
            @RequestParam(value = "dt-fin", required = true) LocalDate dataFinal,
            @RequestParam(defaultValue = "0", required = false) Integer page,
            @RequestParam(defaultValue = "10", required = false) Integer size);

    @GetMapping("/id")
    ResponseEntity<Agenda> pesquisarPorId(@PathVariable("agendaID") String id);

    @GetMapping("/processos")
    ResponseEntity<Page<Agenda>> pesquisarPorProcessoId(@PathVariable("processoID") Long processoID);

    @GetMapping("/contratos")
    ResponseEntity<Page<Agenda>> pesquisarPorContratoId(@PathVariable("contratoID") Long contratoID);

    @DeleteMapping("/excluir")
    ResponseEntity<Void> excluir(@PathVariable("/{id}") String id);
}