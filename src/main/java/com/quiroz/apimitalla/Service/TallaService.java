package com.quiroz.apimitalla.Service;

import java.util.List;
import java.util.Optional;

import com.quiroz.apimitalla.Entity.Talla;

public interface TallaService {
    List<Talla> findAll();

    Optional<Talla> findById(Long id);

    Talla save(Talla talla);

    void deleteById(Long id);

    boolean existsById(Long id);
}
