package br.com.avocat.agenda.persistence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@Document(collection = "agendas")
public class Agenda {

    @Id
    private String id;

    private  String usuario;

    private String chavePrivada;

    private String processoID;

    private String contratoID;

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
}
