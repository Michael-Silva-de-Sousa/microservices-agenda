package br.com.avocat.agenda.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AgendaRepository extends JpaRepository<Agenda, String> {

    @Query("select a from  Agenda a where a.dataInicial >= ?1 and a.dataFinal =< ?2")
    Page<Agenda> pesquisaPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);
}
