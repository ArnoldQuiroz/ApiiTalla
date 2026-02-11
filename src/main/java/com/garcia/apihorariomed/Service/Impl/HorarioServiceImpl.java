package com.garcia.apihorariomed.Service.Impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.garcia.apihorariomed.Entity.Horario;
import com.garcia.apihorariomed.Repository.HorarioRepository;
import com.garcia.apihorariomed.Service.HorarioService;

@Service
public class HorarioServiceImpl implements HorarioService {

    @Autowired
    private HorarioRepository repository;

    @Override
    public List<Horario> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Horario> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public Horario save(Horario horario) {
        return repository.save(horario);
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
