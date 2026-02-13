package com.quiroz.apimitalla.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.quiroz.apimitalla.Entity.Talla;

@Repository
public interface TallaRepository extends JpaRepository<Talla, Long> {
}
