package br.com.avocat.notificacao.service;

import br.com.avocat.notificacao.dto.NotificacaoRequest;
import br.com.avocat.notificacao.persistence.Notificacao;
import br.com.avocat.notificacao.persistence.NotificacaoRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Slf4j
@Service
public class NotificacaoService {

    private final NotificacaoRepository notificacaoRepository;

    @Transactional
    public void save(NotificacaoRequest notificacaoRequest) {
        log.info("Recebeu a mensagem {}", notificacaoRequest);
        notificacaoRepository.save(
                Notificacao.builder()
                        .conteudo(notificacaoRequest.message())
                        .build()
        );

    }
}
