package br.com.avocat.agenda;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.persistence.AgendaRepository;
import br.com.avocat.agenda.service.AgendaService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

@SpringBootTest
class AgendaRepositoryTest {

    @Autowired
    private AgendaRepository agendaRepository;

    @Autowired
    private AgendaService agendaService;

    @Test
    void insereAgenda_entao200(){
        //Given
        Agenda agenda = Agenda.builder()
                .titulo("Agenda teste")
                .descricao("Um teste de agendamento")
                .build();
        //When
        var result = agendaRepository.save(agenda);
        //Then
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    void pesquisarPorPeriodo_entao200(){
        //Given
        var dataInicial = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 1);
        var dataFinal = LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), 30);
        //When
        var result = agendaRepository.pesquisaPorPeriodo(dataInicial, dataFinal, Pageable.ofSize(10));
        //Then
        Assertions.assertThat(result).isNotNull();
    }

    @Test
    void buscarPorId() {
        //Given
        String id = "62fa7a1b67a0a30f9ce2353a";
        //When
        var result = agendaService.pesquisarPorId(id);
        //Then
        Assertions.assertThat(result).isNotNull();
    }
}
