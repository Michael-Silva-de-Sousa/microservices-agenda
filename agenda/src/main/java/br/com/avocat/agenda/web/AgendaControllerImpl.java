package br.com.avocat.agenda.web;

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
    public ResponseEntity<AgendaRecord> salvar(AgendaRecord agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<AgendaRecord> atualizar(AgendaRecord agendaRequest) {
        return null;
    }

    @Override
    public Page<Agenda> pesquisarPorPeriodo(
            LocalDate dataInicial,
            LocalDate dataFinal,
            Integer page,
            Integer size) {
        Pageable pageable = PageRequest.of(page != null ? page : 0, size != null ? size : 10);

        return agendaService.pesquisarPorPeriodo(dataInicial, dataFinal, pageable);
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
