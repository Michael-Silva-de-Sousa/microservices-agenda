package br.com.avocat.agenda.persistence;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends MongoRepository<Agenda, String> {

    //Page<Agenda> findAll(LocalDateTime dataInicial, LocalDateTime dataFinal, Pageable pageable);
}
