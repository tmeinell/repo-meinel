package br.com.tms.repository;

import br.com.tms.controller.domain.model.TerminalModel;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TerminalRepository extends JpaRepository<TerminalModel, Integer> {
    TerminalModel findById(int logic);
}
