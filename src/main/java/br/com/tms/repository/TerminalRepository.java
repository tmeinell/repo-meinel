package br.com.tms.repository;

import br.com.tms.controller.domain.model.TerminalModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<TerminalModel, Integer> {
    TerminalModel findByLogincId(int logic);
}
