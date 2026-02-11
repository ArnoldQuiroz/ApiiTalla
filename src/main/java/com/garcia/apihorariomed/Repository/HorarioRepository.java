package com.garcia.apihorariomed.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.garcia.apihorariomed.Entity.Horario;

public interface HorarioRepository extends JpaRepository<Horario, Long> {
    // Basic CRUD is provided by JpaRepository
}
