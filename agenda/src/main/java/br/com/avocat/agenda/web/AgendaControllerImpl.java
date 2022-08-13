package br.com.avocat.agenda.web;

import br.com.avocat.agenda.exception.AgendaException;
import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.service.AgendaService;
import br.com.avocat.agenda.web.dto.AgendaRecord;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@AllArgsConstructor
@RequestMapping("/v1/api/agenda")
@RestController
public class AgendaControllerImpl implements AgendaController {

    private AgendaService agendaService;

    @Override
    public ResponseEntity<Agenda> salvar(Agenda agenda) {

        try {
            var result = agendaService.salvar(agenda);
            return result
                    .map(value -> ResponseEntity.ok().body(value))
                    .orElseGet(() -> ResponseEntity.badRequest().build());

        } catch (AgendaException e) {
            throw new AgendaException("Erro ao salvar agendamento:", e);
        }
    }

    @Override
    public ResponseEntity<AgendaRecord> atualizar(AgendaRecord agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Page<Agenda>> pesquisarPorPeriodo(
            LocalDate dataInicial,
            LocalDate dataFinal,
            Integer page,
            Integer size) {
        Pageable pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 10);

        return ResponseEntity.ok(agendaService.pesquisarPorPeriodo(dataInicial, dataFinal, pageable));
    }

    @Override
    public ResponseEntity<AgendaRecord> pesquisarPorID(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Page<AgendaRecord>> pesquisarTodosPorProcessoID(AgendaRecord agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Page<AgendaRecord>> pesquisarTodosPorContratoID(AgendaRecord agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Void> inativar(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<Void> excluir(Long id) {
        return null;
    }
}
