package br.com.avocat.agenda.persistence;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@Table(name = "agendas")
public class Agenda {

    @Id
    @SequenceGenerator(name = "sq_agenda", sequenceName = "sq_agenda", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_agenda")
    private Long id;

    private String usuario;

    private String chavePrivada;

    private String processoId;

    private String contratoId;

    @NotBlank(message = "Título é obrigatório")
    @Length(max = 100, message = "O título deverá ter no máximo {max} caracteres.")
    private String titulo;

    @NotBlank(message = "Descrição é obrigatória")
    private String descricao;

    @CreatedDate
    private LocalDate dataCadastro;

    @LastModifiedDate
    private LocalDate dataAtualizacao;

    private LocalDateTime dataFinal;

    private LocalDateTime dataLembrete;

    private String lembreteStatus;
}

