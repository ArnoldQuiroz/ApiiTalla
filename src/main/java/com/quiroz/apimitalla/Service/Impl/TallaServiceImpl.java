package com.quiroz.apimitalla.Service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quiroz.apimitalla.Entity.Talla;
import com.quiroz.apimitalla.Repository.TallaRepository;
import com.quiroz.apimitalla.Service.TallaService;

@Service
public class TallaServiceImpl implements TallaService {

    @Autowired
    private TallaRepository repository;

    @Override
    public List<Talla> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Talla> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Talla save(Talla talla) {
        return repository.save(talla);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) {
        return repository.existsById(id);
    }
}
