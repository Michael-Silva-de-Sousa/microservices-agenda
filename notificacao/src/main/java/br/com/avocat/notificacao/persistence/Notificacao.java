package br.com.avocat.notificacao.persistence;

import br.com.avocat.notificacao.persistence.enums.StatusEnvio;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "notificacoes")
public class Notificacao {

    @Id
    private String id;
    private LocalDate dataEnvio;
    private String statusEnvio;
    private String conteudo;
}
