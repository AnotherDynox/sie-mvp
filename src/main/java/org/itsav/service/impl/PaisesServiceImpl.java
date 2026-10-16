package org.itsav.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.itsav.domain.entities.Pais;
import org.itsav.repositories.PaisesRepository;
import org.itsav.service.PaisesService;

import java.util.List;

@ApplicationScoped
public class PaisesServiceImpl implements PaisesService {

    @Inject
    PaisesRepository paisesRepository;

    @Override
    public List<Pais> findAll() {
        return paisesRepository.findAll().stream().toList();
    }
}
