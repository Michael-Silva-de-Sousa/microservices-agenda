package br.com.avocat.agenda.persistence.repository;

import br.com.avocat.agenda.persistence.Agenda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, Long> {

}
