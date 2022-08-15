package br.com.avocat.agenda.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AgendaRepository extends MongoRepository<Agenda, String> {

    @Query("{ 'dataCadastro':{ $gte: ?0, $lt: ?1} } ")
    Page<Agenda> pesquisaPorPeriodo(LocalDate dataInicial, LocalDate dataFinal, Pageable pageable);
}
