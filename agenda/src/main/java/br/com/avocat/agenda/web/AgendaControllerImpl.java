package br.com.avocat.agenda.web;

import br.com.avocat.agenda.web.dto.AgendaDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/agenda")
@RestController
public class AgendaControllerImpl implements AgendaController {

    @Override
    public ResponseEntity<AgendaDTO> salvar(AgendaDTO agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<AgendaDTO> atualizar(AgendaDTO agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> pesquisarPorPeriodo(String dataInicio, String dataFinal) {
        return null;
    }

    @Override
    public ResponseEntity<AgendaDTO> pesquisarPorID(Long id) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> pesquisarTodosPorProcessoID(AgendaDTO agendaRequest) {
        return null;
    }

    @Override
    public ResponseEntity<List<AgendaDTO>> pesquisarTodosPorContratoID(AgendaDTO agendaRequest) {
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
