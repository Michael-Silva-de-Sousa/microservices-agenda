package br.com.avocat.agenda.web;

import br.com.avocat.agenda.exception.AgendaException;
import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.service.AgendaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@AllArgsConstructor
@RequestMapping("/v1/api/agenda")
@RestController
public class AgendaController {

    private AgendaServiceImpl agendaService;

    @PostMapping
    public ResponseEntity<Agenda> salvar(@RequestBody @Valid Agenda agenda) {

        try {
            var result = agendaService.salvar(agenda);
            return result
                    .map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.badRequest().build());

        } catch (AgendaException e) {
            throw new AgendaException("Erro ao salvar o agendamento:", e);
        }
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<Page<Agenda>> pesquisarPorPeriodo(
            @RequestParam(value = "dt-ini", required = true) String dataInicial,
            @RequestParam(value = "dt-fin", required = true) String dataFinal,
            @RequestParam(value="page", defaultValue = "0", required = false) Integer page,
            @RequestParam(value="size", defaultValue = "10", required = false) Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(agendaService.pesquisarPorPeriodo(dataInicial, dataFinal, pageable));
    }

    @GetMapping("/{agendaId}")
    public ResponseEntity<Agenda> pesquisarPorId(@PathVariable("agendaId") String agendaId) {
        try {
            return agendaService.pesquisarPorId(agendaId)
                    .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (AgendaException e) {
            throw new AgendaException("Erro ao pesquisar o agendamento de ID: " + agendaId, e);
        }
    }

    @GetMapping("/processo/{processoId}")
    public ResponseEntity<Page<Agenda>> pesquisarPorProcessoId(@PathVariable("processoId") Long processoId) {
        return null;
    }

    @GetMapping("/contrato/{contratoId}")
    public ResponseEntity<Page<Agenda>> pesquisarPorContratoId(@PathVariable("contratoId") Long contratoId) {
        return null;
    }

    @DeleteMapping("/excluir/{agendaId}")
    public ResponseEntity<Void> excluir(@PathVariable("agendaId") String id) {
        agendaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
