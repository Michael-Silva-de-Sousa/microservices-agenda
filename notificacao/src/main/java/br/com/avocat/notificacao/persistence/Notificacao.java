package br.com.avocat.notificacao.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.time.LocalDate;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "notificacoes")
public class Notificacao {

    @Id
    @SequenceGenerator(name = "sq_notificacao", sequenceName = "sq_notificacao", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_notificacao")
    private Long id;

    private LocalDate dataEnvio;
    private String statusEnvio;
    private String conteudo;
}
