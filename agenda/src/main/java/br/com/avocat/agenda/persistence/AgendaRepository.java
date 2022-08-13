package br.com.avocat.agenda.persistence;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgendaRepository extends PagingAndSortingRepository<Agenda, String> {
}
