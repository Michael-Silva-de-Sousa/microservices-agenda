package br.com.avocat.agenda.persistence.repository;

import br.com.avocat.agenda.persistence.Processo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcessoRepository extends JpaRepository<Processo, Long> {
}
