package br.com.avocat.agenda.web;

import br.com.avocat.agenda.exception.AgendaException;
import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.service.AgendaServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@AllArgsConstructor
@RequestMapping("/v1/api/agenda")
@RestController
public class AgendaControllerImpl implements AgendaController {

    private AgendaServiceImpl agendaService;

    @Override
    public ResponseEntity<Agenda> salvar(Agenda agenda) {

        try {
            var result = agendaService.salvar(agenda);
            return result
                    .map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.badRequest().build());

        } catch (AgendaException e) {
            throw new AgendaException("Erro ao salvar o agendamento:", e);
        }
    }

    @Override
    public ResponseEntity<Page<Agenda>> pesquisarPorPeriodo(
            LocalDate dataInicial, LocalDate dataFinal, Integer page, Integer size) {

        Pageable pageable = PageRequest.of(page, size);
        return ResponseEntity.ok(agendaService.pesquisarPorPeriodo(dataInicial, dataFinal, pageable));
    }

    @Override
    public ResponseEntity<Agenda> pesquisarPorId(String agendaId) {
        try {
            return agendaService.pesquisarPorId(agendaId)
                    .map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } catch (AgendaException e) {
            throw new AgendaException("Erro ao pesquisar o agendamento de ID: " + agendaId, e);
        }
    }

    @Override
    public ResponseEntity<Page<Agenda>> pesquisarPorProcessoId(Long processoId) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Agenda>> pesquisarPorContratoId(Long contratoId) {
        return null;
    }

    @Override
    public ResponseEntity<Void> excluir(String id) {
        agendaService.excluir(id);
        return ResponseEntity.ok().build();
    }
}
