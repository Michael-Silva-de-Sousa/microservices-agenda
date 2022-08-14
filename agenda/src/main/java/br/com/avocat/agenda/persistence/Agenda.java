package br.com.avocat.agenda.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Document(collection = "agendas")
public class Agenda {

    @Id
    private String id;

    private  String usuario;
    private String chavePrivada;
    private Long processoID;
    private Long contratoID;
    private String titulo;
    private String descricao;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataFinal;
    private LocalDateTime dataLembrete;
}
