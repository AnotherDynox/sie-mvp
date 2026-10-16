package org.itsav.repositories;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import org.itsav.domain.entities.DiscapacidadDatosMedicos;
import org.itsav.domain.entities.DiscapacidadDatosMedicosId;

@ApplicationScoped
public class DiscapacidadesDatosMedicosRepository implements PanacheRepositoryBase<DiscapacidadDatosMedicos, DiscapacidadDatosMedicosId> {
}
