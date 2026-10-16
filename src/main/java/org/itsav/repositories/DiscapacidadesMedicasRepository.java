package org.itsav.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.entities.DiscapacidadMedica;


@ApplicationScoped
public class DiscapacidadesMedicasRepository implements PanacheRepositoryBase<DiscapacidadMedica, Integer> {
}
