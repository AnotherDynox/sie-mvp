package org.itsav.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.itsav.domain.entities.Ciudad;
import org.itsav.repositories.CiudadesRepository;
import org.itsav.service.CiudadesService;

import java.util.List;

@ApplicationScoped
public class CiudadesServiceImpl implements CiudadesService {

    @Inject
    CiudadesRepository ciudadesRepository;

    @Override
    public List<Ciudad> findAll() {
        return ciudadesRepository.findAll().stream().toList();
    }
}
