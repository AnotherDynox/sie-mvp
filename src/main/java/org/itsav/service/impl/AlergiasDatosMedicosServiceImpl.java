package org.itsav.service.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.itsav.domain.entities.AlergiaDatosMedicos;
import org.itsav.repositories.AlergiasDatosMedicosRepository;
import org.itsav.service.AlergiasDatosMedicosService;

import java.util.List;

@ApplicationScoped
public class AlergiasDatosMedicosServiceImpl implements AlergiasDatosMedicosService {

    @Inject
    AlergiasDatosMedicosRepository alergiasDatosMedicosRepository;

    @Override
    public List<AlergiaDatosMedicos> findAll() {
        return alergiasDatosMedicosRepository.findAll().stream().toList();
    }
}
