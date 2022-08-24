package br.com.avocat.notificacao.service;

import br.com.avocat.notificacao.dto.NotificacaoRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class NotificacaoService {

    public void save(NotificacaoRequest notificacaoRequest) {
        log.info("Recebeu a mensagem {}", notificacaoRequest);
    }
}
