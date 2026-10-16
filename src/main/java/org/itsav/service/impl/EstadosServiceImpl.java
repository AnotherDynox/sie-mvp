package org.itsav.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.itsav.domain.entities.Estado;
import org.itsav.repositories.EstadosRepository;
import org.itsav.service.EstadosService;

import java.util.List;

@ApplicationScoped
public class EstadosServiceImpl implements EstadosService {

    @Inject
    EstadosRepository estadosRepository;

    @Override
    public List<Estado> findAll() {
        return estadosRepository.findAll().stream().toList();
    }
}
