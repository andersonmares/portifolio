package br.com.anderson.portifolio.repository;

import br.com.anderson.portifolio.model.Projeto;
import br.com.anderson.portifolio.model.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjetoRepository extends JpaRepository<Projeto, Long> {
    List<Projeto> findByStatus(Status status);
}
