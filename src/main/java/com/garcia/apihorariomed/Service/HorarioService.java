package com.garcia.apihorariomed.Service;

import java.util.List;
import java.util.Optional;
import com.garcia.apihorariomed.Entity.Horario;

public interface HorarioService {
    List<Horario> findAll();

    Optional<Horario> findById(Long id);

    Horario save(Horario horario);

    void deleteById(Long id);

    boolean existsById(Long id);
}
