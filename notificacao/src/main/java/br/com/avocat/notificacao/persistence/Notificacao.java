package br.com.avocat.notificacao.persistence;

import br.com.avocat.notificacao.enums.StatusEnvio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notificacoes")
public class Notificacao {

    @Id
    private UUID id;
    private LocalDate dataEnvio;
    private StatusEnvio statusEnvio;
    private String conteudo;
}
