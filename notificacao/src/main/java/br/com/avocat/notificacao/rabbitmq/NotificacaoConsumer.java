package br.com.avocat.notificacao.rabbitmq;

import br.com.avocat.notificacao.dto.NotificacaoRequest;
import br.com.avocat.notificacao.service.NotificacaoService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@Slf4j
public class NotificacaoConsumer {

    private final NotificacaoService notificacaoService;

    @RabbitListener(queues = "${rabbitmq.queues.notificacao}")
    public void consumer(NotificacaoRequest notificacaoRequest) {
        log.info("Consumindo {} da fila", notificacaoRequest);
        notificacaoService.save(notificacaoRequest);
    }
}
