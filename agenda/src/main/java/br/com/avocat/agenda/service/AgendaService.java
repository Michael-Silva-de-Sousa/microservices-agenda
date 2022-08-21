package br.com.avocat.agenda.service;

import br.com.avocat.agenda.dto.AgendaRecord;
import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.persistence.AgendaRepository;
import br.com.avocat.agenda.persistence.enums.LembreteStatus;
import br.com.avocat.amqp.RabbitMQMessageProducer;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@AllArgsConstructor
@Service
public class AgendaService {

    private final AgendaRepository agendaRepository;
    private final RabbitMQMessageProducer rabbitMQMessageProducer;

    @Transactional
    public Optional<Agenda> salvar(AgendaRecord agendaRecord) {

        var agenda = Agenda.builder()
                        .titulo(agendaRecord.titulo())
                        .descricao(agendaRecord.descricao())
                        .dataLembrete(LocalDateTime.parse(agendaRecord.dataLembrete()))
                        //.dataFinal(LocalDateTime.parse(agendaRecord.dataFinal()))
                        .build();

        if(!ObjectUtils.isEmpty(agenda.getDataLembrete())) {
            agenda.setLembreteStatus(LembreteStatus.UNPUBLISHED.name());
            enviarNotificacaoMensageria(agendaRecord);
            agenda.setLembreteStatus(LembreteStatus.PUBLISHED.name());
        }
        return Optional.of(agendaRepository.save(agenda));
    }

    public Optional<Agenda> pesquisarPorId(String agendaId) {
        return agendaRepository.findById(agendaId);
    }

    public Page<Agenda> pesquisarTodosPorProcessoId(Long processoId, Pageable pageable) {
        //TODO falta implementação
        return Page.empty();
    }

    public Page<Agenda> pesquisarTodosPorContratoId(Long contratoId) {
        //TODO falta implementação
        return Page.empty();
    }

    public Page<Agenda> pesquisarPorPeriodo(String dataInicial, String dataFinal, Pageable pageable) {

        LocalDate dataInicialLocalDate = LocalDate.parse(dataInicial);
        LocalDate dataFinalLocalDate = LocalDate.parse(dataFinal);

        return agendaRepository.pesquisaPorPeriodo(dataInicialLocalDate, dataFinalLocalDate, pageable);
    }

    @Transactional
    public void excluir(String agendaId) {
        var agenda = agendaRepository.findById(agendaId);
        agenda.ifPresent(agendaRepository::delete);
    }

    private void enviarNotificacaoMensageria(AgendaRecord agendaRecord) {
        //TODO construir um retorno para notificar que a publicação foi realizada com sucesso.
        rabbitMQMessageProducer.publish(
                agendaRecord,
                "exchanges.direct.notificacao",
                "lembrete");
    }
}
