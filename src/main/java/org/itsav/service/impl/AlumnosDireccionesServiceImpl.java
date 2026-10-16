package org.itsav.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.itsav.domain.entities.AlumnoDireccion;
import org.itsav.repositories.AlumnosDireccionesRepository;
import org.itsav.service.AlumnosDireccionesService;

import java.util.List;

@ApplicationScoped
public class AlumnosDireccionesServiceImpl implements AlumnosDireccionesService {

    @Inject
    AlumnosDireccionesRepository alumnosDireccionesRepository;

    @Override
    public List<AlumnoDireccion> findAll() {
        return alumnosDireccionesRepository.findAll().stream().toList();
    }
}
