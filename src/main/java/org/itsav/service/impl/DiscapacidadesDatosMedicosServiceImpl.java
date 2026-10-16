package org.itsav.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.itsav.domain.entities.DiscapacidadDatosMedicos;
import org.itsav.repositories.DiscapacidadesDatosMedicosRepository;
import org.itsav.service.DiscapacidadesDatosMedicosService;

import java.util.List;

@ApplicationScoped
public class DiscapacidadesDatosMedicosServiceImpl implements DiscapacidadesDatosMedicosService {

    @Inject
    DiscapacidadesDatosMedicosRepository discapacidadesDatosMedicosRepository;

    @Override
    public List<DiscapacidadDatosMedicos> findAll() {
        return discapacidadesDatosMedicosRepository.findAll().stream().toList();
    }
}
