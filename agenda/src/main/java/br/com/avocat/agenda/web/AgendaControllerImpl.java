package br.com.avocat.agenda.web;

import br.com.avocat.agenda.web.dto.AgendaRecord;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/v1/api/agenda")
@RestController
public class AgendaControllerImpl implements AgendaController {

    @Override
    public ResponseEntity<AgendaRecord> salvar(AgendaRecord agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<AgendaRecord> atualizar(AgendaRecord agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<Page<AgendaRecord>> pesquisarPorPeriodo(String dataInicio, String dataFinal) {
        return null;
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
