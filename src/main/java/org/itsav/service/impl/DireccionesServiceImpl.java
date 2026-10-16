package org.itsav.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.itsav.domain.entities.Direccion;
import org.itsav.repositories.DireccionesRepository;
import org.itsav.service.DireccionesService;

import java.util.List;

@ApplicationScoped
public class DireccionesServiceImpl implements DireccionesService {

    @Inject
    DireccionesRepository direccionesRepository;

    @Override
    public List<Direccion> findAll() {
        return direccionesRepository.findAll().stream().toList();
    }
}
