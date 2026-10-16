package org.itsav.service;

import org.itsav.domain.entities.Alergia;

import java.util.List;

public interface AlergiasService {

    public List<Alergia> findAll();
    public Alergia findById(Integer id);
}
