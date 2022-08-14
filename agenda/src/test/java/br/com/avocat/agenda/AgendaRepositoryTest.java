package br.com.avocat.agenda;

import br.com.avocat.agenda.persistence.Agenda;
import br.com.avocat.agenda.persistence.AgendaRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class AgendaRepositoryTest {

    @Autowired
    private AgendaRepository agendaRepository;

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
}
