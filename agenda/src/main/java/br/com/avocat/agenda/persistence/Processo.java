package br.com.avocat.agenda.persistence;

import lombok.Builder;

import javax.persistence.*;

@Builder
@Entity
@Table(name = "processos")
public class Processo {

    @Id
    @SequenceGenerator(name = "sq_processo", sequenceName = "sq_processo", initialValue = 1, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sq_processo")
    private Long id;

    @Column(nullable = true)
    private String numeroProcesso;
}
